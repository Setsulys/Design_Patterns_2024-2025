package fr.uge.ex3;

public interface Logger {
    enum Level{
        ERROR,WARNING,INFO
    }

    public void log(Level level,String message);

    void setMinLogLevel(Level level);

    Level getMinLogLevel();
}
