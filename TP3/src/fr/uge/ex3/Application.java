package fr.uge.ex3;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;

public class Application {
    public static void main(String[] args) {
        try {
            UpperLogger logger = new UpperLogger(Path.of("./tmp/logs.txt"));
            logger.log(Logger.Level.INFO,"HELLO");
            logger.log(Logger.Level.WARNING,"In class "+ Application.class.getName()+" logger");
            logger.close();
        } catch (UncheckedIOException | IOException e) {
            e.getCause();
        }
    }
}
