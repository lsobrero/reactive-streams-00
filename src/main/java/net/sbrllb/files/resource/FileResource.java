package net.sbrllb.files.resource;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.tuples.Tuple2;
import io.vertx.core.file.OpenOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.core.file.AsyncFile;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Duration;
import java.util.List;
import java.util.Random;

@Path("/")
public class FileResource {

//    @Inject
//    Vertx vertx;
//
//    @Inject
//    DirContentService dirContentService;
//
//    @GET
//    @Path("/dir-content")
//    @Produces(MediaType.SERVER_SENT_EVENTS)
//    public Multi<List<String>> getDirContent() {
//        return dirContentService.getDirectoryContentAsListOfStrings();
//    }
//
//    @GET
//    @Path("/dir-content-as-string")
//    @Produces(MediaType.SERVER_SENT_EVENTS)
//    public Multi<String> getDirContentAsString() {
//        return dirContentService.getEventStreamAsMultiString();
//    }
//
//    @ApplicationScoped
//    public static class DirContentService {
//
//        @Inject
//        Vertx vertx;
//
//        Multi<List<String>> getDirectoryContentAsListOfStrings() {
//            return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
//                    .onItem().transform(x -> getDirectoryContentAsList());
//        }
//
//        private List<String> getDirectoryContentAsList() {
//            return vertx.fileSystem().readDirAndAwait("/home/luis/tmp");
//        }
//
//
//        private Multi<String> getDirectoryContentAsMulti() {
//            return vertx.fileSystem().readDir("/home/luis/tmp")
//                    .onItem()
////                    .transformToMulti(list -> Multi.createFrom().item(list.listIterator().next()));
//                    .transformToMulti(list -> Multi.createFrom().iterable(list))
//                    .onFailure().recoverWithItem("");
//        }
//
//        private Uni<List<String>> getDirectoryContentAsUni() {
//            return vertx.fileSystem().readDir("/home/luis/tmp")
//                    .onItem()
//                    .invoke(x -> System.out.println(""));
//        }
//
//        public Multi<String> getEventStreamAsMultiString() {
//            /* OK working */
////            return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
////                    .onItem()
////                    .transform(l -> getDirectoryContentAsList())
////                    .onItem()
////                    .transformToMulti(list -> Multi.createFrom().iterable(list))
////                    .merge();
//
//            /* OK working */
////            return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
////                    .onOverflow().drop()
////                    .onItem().transformToMulti(t -> getDirectoryContentAsMulti())
////                    .merge();
//
//            /* OK working*/
//            return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
//                    .onOverflow().drop()
//                    .onItem().transformToMulti(t -> getDirectoryContentAsMulti())
//                    .merge();
//        }
//    }
}

