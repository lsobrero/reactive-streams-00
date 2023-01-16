package net.sbrllb.files.pipes;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.Vertx;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Duration;
import java.util.List;

//@ApplicationScoped
public class StreamingFiles {

    @Inject
    Vertx vertx;

    @Inject
    StreamingFilesUtils filesUtils;

    @ConfigProperty(name = "pipes.file.inputdir", defaultValue ="/home/luis/tmp/from")
    String inputDir;
    @ConfigProperty(name = "pipes.file.outputdir", defaultValue ="/home/luis/tmp/to")
    String outputDir;

    @Outgoing("ticks")
    public Multi<String> ticks() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
                .onOverflow().drop()
                .onItem().transformToMulti(t -> getDirectoryContentAsMulti())
                .merge();
    }

    @Incoming("ticks")
    @Outgoing("groups")
    public Multi<String> fileMover(Multi<String> stream) {
        // Group the incoming messages into groups of 5.
        return stream
                .onItem().transform(s -> "grouped=" + s)
                .call(moveFile().onItem());
    }


    @Incoming("groups")
    @Outgoing("hello")
    public String processGroup(String sPath) {
        return "Hello:: " + sPath;
    }


    @Incoming("hello")
    public void print(String msg) {
        System.out.println(msg);
    }

    private Multi<String> getDirectoryContentAsMulti() {
        return vertx.fileSystem().readDir("/home/luis/tmp")
                .onItem()
                .transformToMulti(list -> Multi.createFrom().iterable(list))
                .onFailure().recoverWithItem("");
    }


    private Uni<Void> moveFile(){
        return filesUtils.moveFile(inputDir , outputDir);
    }

}
