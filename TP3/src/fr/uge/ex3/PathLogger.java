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

public class PathLogger implements Logger, Closeable{
    private static PathLogger INSTANCE;

    static {
        try {
            INSTANCE = new PathLogger();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Level minLevel;

    private BufferedWriter writer;
    private boolean closed = false;

    private PathLogger() throws IOException {
        this.writer=Files.newBufferedWriter(Path.of("PathLoger.txt"),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    @Override
    public void log(Level level, String message){
        Objects.requireNonNull(level);
        Objects.requireNonNull(message);
        if(closed || minLevel!= null){
            if( minLevel.ordinal()> level.ordinal()){
                return;
            }
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
    public void setMinLogLevel(Level level) {
        this.minLevel = level;
    }

    @Override
    public Level getMinLogLevel() {
        return null;
    }

    public static PathLogger getInstance() throws IOException {
        return INSTANCE;
    }

    @Override
    public void close() throws IOException {
        closed=true;
        writer.close();
    }
}

/**
 * Quel design pattern doit-on utiliser dans ce cas ? Faites les changements qui s'impose dans la classe SystemLogger.
 *
 *  On doit utiliser un singleton
 *
 */