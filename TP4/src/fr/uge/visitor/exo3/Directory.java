package fr.uge.visitor.exo3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public record Directory(Path path,String name,List<FileSystemEntry> content) implements FileSystemEntry {

    public Directory {
        Objects.requireNonNull(path);
        Objects.requireNonNull(name);
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

    @Override
    public String toString() {
        return "Directory:"+ name;
    }
}