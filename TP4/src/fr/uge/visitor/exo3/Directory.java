package fr.uge.visitor.exo3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Directory implements FileSystemEntry {
    private final List<FileSystemEntry> content;
    private final String name;
    private final Path path;
    public Directory(Path path, String name, List<FileSystemEntry> content) {
        this.path = Objects.requireNonNull(path);
        this.name = Objects.requireNonNull(name);
        this.content = content;
    }

    public static Directory of(Path path) throws IOException {
        var name = path.getFileName().toString();
        List<FileSystemEntry> content = Files.list(path).map(p-> {
            try{
                if(p.toFile().isDirectory()){
                    return of(p);
                }
                if(p.toFile().isFile()){
                    return File.of(p);
                }
            }catch (IOException e){
                e.getCause();
            }
            return null;
        }).collect(Collectors.toList());
        return new Directory(path, name, content);
    }



}