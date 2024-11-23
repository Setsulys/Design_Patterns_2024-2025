package fr.uge.visitor.exo3;

import java.nio.file.Path;
import java.util.Objects;

public final class File implements FileSystemEntry {

    private final String name;
    private final Path path;
    private final String extension;

    public File(Path path, String name, String extension) {
        this.path = Objects.requireNonNull(path);
        this.name = Objects.requireNonNull(name);
        this.extension = extension;
    }

    public static File of(Path path) {
        var name = path.getFileName().toString();
        var extension = name.substring(name.lastIndexOf('.') + 1);
        return new File(path, name, extension);
    }
}