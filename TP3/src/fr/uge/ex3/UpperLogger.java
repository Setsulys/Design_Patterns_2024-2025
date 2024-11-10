package fr.uge.ex3;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Path;

public class UpperLogger implements Logger, Closeable {
    private final SystemLogger console;
    private final PathLogger pathlogger;

    public UpperLogger(Path path) throws IOException {
        console = SystemLogger.getInstance();
        pathlogger = PathLogger.getInstance(path);
    }

    @Override
    public void log(Level level, String message) {
        console.log(level,message);
        pathlogger.log(level,message);
    }

    @Override
    public void setMinLogLevel(Level level) {
        console.setMinLogLevel(level);
        pathlogger.setMinLogLevel(level);
    }

    @Override
    public Level getMinLogLevel() {
        return console.getMinLogLevel();
    }

    @Override
    public void close() throws IOException {
        pathlogger.close();
    }
}
