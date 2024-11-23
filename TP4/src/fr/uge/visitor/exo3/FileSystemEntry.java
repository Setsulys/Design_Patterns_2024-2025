package fr.uge.visitor.exo3;

import java.io.IOException;
import java.nio.file.Path;

public interface FileSystemEntry {

    public static FileSystemEntry of(Path path) throws IOException {
        return null;
    }
}

