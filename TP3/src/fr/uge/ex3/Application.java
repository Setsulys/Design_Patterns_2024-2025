package fr.uge.ex3;

import java.io.IOException;
import java.io.UncheckedIOException;

public class Application {
    public static void main(String[] args) {
        try {
            UpperLogger logger = new UpperLogger();
            logger.log(Logger.Level.INFO,"HELLO");
            logger.log(Logger.Level.WARNING,"HELLO");
            logger.close();
        } catch (UncheckedIOException | IOException e) {
            e.getCause();
        }
    }
}
