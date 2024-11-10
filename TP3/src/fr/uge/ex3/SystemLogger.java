package fr.uge.ex3;

public class SystemLogger implements Logger{

    private static final SystemLogger INSTANCE = new SystemLogger();

    private Level minLevel;

    private SystemLogger(){

    }

    public static SystemLogger getInstance(){
        return INSTANCE;
    }

    @Override
    public void log(Level level, String message) {
        if(minLevel!=null){
            if(minLevel.ordinal()> level.ordinal()){
                return;
            }
        }
        System.err.println(level + " " + message);
    }

    @Override
    public void setMinLogLevel(Level level) {
        this.minLevel = level;
    }

    @Override
    public Level getMinLogLevel() {
        return null;
    }
}