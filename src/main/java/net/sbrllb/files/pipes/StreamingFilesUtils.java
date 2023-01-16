package net.sbrllb.files.pipes;


import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.Vertx;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Objects;

@ApplicationScoped
public class StreamingFilesUtils {

    @Inject
    Vertx vertx;

    public Uni<Void> moveFile(String from, String to) {
        return vertx.fileSystem().move(from, to);
    }

    public static boolean fileExists(String fileName) {
        boolean result = false;
        File f = new File(fileName);
        if (f.exists() && !f.isDirectory()) {
            return true;
        }
        return result;
    }

    public static void touch(final Path dirPath, final Path filePath) throws IOException {
        Objects.requireNonNull(filePath, "path is null");
        if (Files.exists(filePath)) {
            Files.setLastModifiedTime(filePath, FileTime.from(Instant.now()));
        } else {
            Files.createFile(filePath);
        }
    }

    public static void removeFile(final Path dirPath) throws IOException {
        Objects.requireNonNull(dirPath, "path is null");
        try {
            if (Files.exists(dirPath)) {
                Files.delete(dirPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
