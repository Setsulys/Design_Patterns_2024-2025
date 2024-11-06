package fr.uge.ex3;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class PathLogger implements Logger{
    private final Path path;
    private static final PathLogger INSTANCE = null; //new PathLogger();

    PathLogger(Path path){
        this.path = Objects.requireNonNull(path);
    }

    @Override
    public void log(Level level, String message){
        try{
            var buffer =Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            buffer.write(path.toString()+":"+level+" " + message);
        }catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }

    public static PathLogger getInstance(){
        return INSTANCE;
    }


}

/**
 * Quel design pattern doit-on utiliser dans ce cas ? Faites les changements qui s'impose dans la classe SystemLogger.
 *
 *  On doit utiliser un singleton
 *
 */