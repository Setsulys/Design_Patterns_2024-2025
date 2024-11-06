package fr.uge.ex3;

public class SystemLogger implements Logger{

    @Override
    public void log(Level level, String message) {
        System.err.println(level + " " + message);
    }
}