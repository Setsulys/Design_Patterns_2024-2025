package fr.uge.visitor.exo3;

import java.nio.file.Path;
import java.util.Objects;

public record File(Path path,String name,String extension) implements FileSystemEntry {


    public File{
        Objects.requireNonNull(path);
        Objects.requireNonNull(name);
    }

    public static File of(Path path) {
        var name = path.getFileName().toString();
        var extension = name.substring(name.lastIndexOf('.') + 1);
        return new File(path, name, extension);
    }

    @Override
    public String toString() {
        return "File: "+name;
    }
}