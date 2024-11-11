package fr.uge.ex3;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Predicate;

public class UpperLogger implements Logger {
    private final Logger firstLogger;
    private final Logger systemLogger;

    public UpperLogger(Logger logger) throws IOException {
        firstLogger = logger;
        systemLogger = SystemLogger.getInstance();
    }

    @Override
    public void log(Level level, String message) {
        firstLogger.log(level,message);
        systemLogger.log(level,message);
    }

    @Override
    public void setLevelPredicate(Predicate<Level> level) {
        firstLogger.setLevelPredicate(level);
        systemLogger.setLevelPredicate(level);
    }
}
