package fr.uge.ex3;

import java.io.Closeable;
import java.io.IOException;

public class UpperLogger implements Logger, Closeable {
    private final SystemLogger console = SystemLogger.getInstance();
    private final PathLogger pathlogger = PathLogger.getInstance();

    public UpperLogger() throws IOException {
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
