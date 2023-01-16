package net.sbrllb.files.pipes;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class StreamingFilesTest {

    @Inject
    StreamingFilesUtils filesUtils;

    String from = System. getProperty("java.io.tmpdir") + "/files/pipes/from";
    String to = System. getProperty("java.io.tmpdir") + "/files/pipes/to";

    @Test
    public void moveFile() throws IOException {
        String fileName = "/tester-00.txt";
        Files.createDirectories(Path.of(from));
        Files.createDirectories(Path.of(to));
        StreamingFilesUtils.removeFile(Path.of(to + fileName));
        StreamingFilesUtils.touch(Path.of(from), Path.of(from + fileName));
        Uni<Void> mover = filesUtils.moveFile(from + fileName, to + fileName);
                mover.onItem()
                .invoke(x -> System.out.println("File moved"))
                .onFailure().invoke(x -> System.out.println("File moved error=" + x))
                .subscribe().with(x -> System.out.println("File moved"));
        waitFor(1000);
        assertTrue(StreamingFilesUtils.fileExists(to + fileName));
        StreamingFilesUtils.removeFile(Path.of(to + fileName));
    }

    private void waitFor(long i) {
        try{
            Thread.sleep(i);
        }catch (Exception e){}
    }


}
