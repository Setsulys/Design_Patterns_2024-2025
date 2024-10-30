package fr.uge.ex1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggedDuck implements Duck{

    private static final Logger LOGGER = Logger.getLogger(LoggedDuck.class.getClass().getName());

    private final Duck duck;

    public LoggedDuck(Duck duck){
        this.duck = duck;
    }

    @Override
    public void quack() {
        LOGGER.log(Level.INFO,"Call to Quack!");
        duck.quack();
    }

/*    @Override
    public void quackManyTimes(int n) {
        duck.quackManyTimes(n);
    }*/
}
