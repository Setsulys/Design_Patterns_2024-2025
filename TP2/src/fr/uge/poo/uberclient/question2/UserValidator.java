package fr.uge.poo.uberclient.question2;

@FunctionalInterface
public interface UserValidator {
    boolean isValid(User user);
}
