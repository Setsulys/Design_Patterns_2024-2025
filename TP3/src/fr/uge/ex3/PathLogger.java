package fr.uge.ex3;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.function.Predicate;

public class PathLogger implements Logger, Closeable{
    private Predicate<Level> levelPredicate=t->true;
    private final BufferedWriter writer;
    private boolean closed = false;

    public PathLogger(Path path) throws IOException {
        this.writer=Files.newBufferedWriter(path,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    @Override
    public void log(Level level, String message){
        Objects.requireNonNull(level);
        Objects.requireNonNull(message);
        if(closed){
            return;
        }
        if(!levelPredicate.test(level)){
            return;
        }
        try{
            writer.write(level + " " + message);
            writer.newLine();
            writer.flush();
        }catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void setLevelPredicate(Predicate<Level> level) {
        this.levelPredicate = Objects.requireNonNull(level);
    }

    @Override
    public void close() throws IOException {
        closed=true;
        writer.close();
    }
}

