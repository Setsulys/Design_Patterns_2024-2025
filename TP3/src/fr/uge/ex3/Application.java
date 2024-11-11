package fr.uge.ex3;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;

public class Application {
    public static void main(String[] args) {
        try {
            PathLogger pathLogger = new PathLogger(Path.of("./tmp/logs.txt"));
            UpperLogger logger = new UpperLogger(pathLogger);

            logger.log(Logger.Level.INFO,"HELLO WORLD");
            logger.log(Logger.Level.WARNING,"In class "+ Application.class.getName()+" logger");
            logger.log(Logger.Level.ERROR,"PROBLEM ENCOUNTERED HERE "+ Application.class.getName());
            logger.setLevelPredicate(t-> t.ordinal()>= Logger.Level.WARNING.ordinal());
            logger.log(Logger.Level.INFO,"HELLO FROM WARNING+");
            logger.log(Logger.Level.WARNING,"In class "+ Application.class.getName()+" logger WARNING +");
            logger.log(Logger.Level.ERROR,"PROBLEM ENCOUNTERED HERE AFTER WARNING+ "+ Application.class.getName());

            pathLogger.close();
        } catch (UncheckedIOException | IOException e) {
            System.out.println("HELLLOO");
            e.getCause();
        }
    }
}
/**
 * Quel design pattern doit-on utiliser dans ce cas ? Faites les changements qui s'impose dans la classe SystemLogger.
 *
 *  On doit utiliser un singleton
 *
 */