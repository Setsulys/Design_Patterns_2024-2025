package fr.uge.poo.uberclient.question4;

@FunctionalInterface
public interface UserValidator {
    boolean isValid(User user);
}
