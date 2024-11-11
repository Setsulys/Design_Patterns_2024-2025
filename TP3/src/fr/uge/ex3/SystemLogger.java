package fr.uge.ex3;

import java.util.Objects;
import java.util.function.Predicate;

public class SystemLogger implements Logger{
    private static final SystemLogger INSTANCE = new SystemLogger();
    private Predicate<Level> levelpredicate= t->true;
    private SystemLogger(){}
    public static SystemLogger getInstance(){
        return INSTANCE;
    }

    @Override
    public void log(Level level, String message) {
        if(!levelpredicate.test(level)){
            return;
        }
        System.err.println(level + " " + message);
    }

    @Override
    public void setLevelPredicate(Predicate<Level> level) {
        this.levelpredicate= Objects.requireNonNull(level);
    }
}