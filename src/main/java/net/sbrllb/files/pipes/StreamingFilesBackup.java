package net.sbrllb.files.pipes;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.List;

//@ApplicationScoped
public class StreamingFilesBackup {
//
//    @Outgoing("ticks")
//    public Multi<Long> ticks() {
//        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
//                .onOverflow().drop();
//    }
//
//    @Incoming("ticks")
//    @Outgoing("groups")
//    public Multi<List<String>> group(Multi<Long> stream) {
//        // Group the incoming messages into groups of 5.
//        return stream
//                .onItem().transform(l -> Long.toString(l))
//                .group().intoLists().of(5);
//    }
//
//
//    @Incoming("groups")
//    @Outgoing("hello")
//    public String processGroup(List<String> list) {
//        return "Hello " + String.join(",", list);
//    }
//
//
//    @Incoming("hello")
//    public void print(String msg) {
//        System.out.println(msg);
//    }
}
