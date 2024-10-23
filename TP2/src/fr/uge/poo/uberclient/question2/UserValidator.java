package fr.uge.poo.uberclient.question2;

@FunctionalInterface
public interface UserValidator {
    boolean isValid(Newsletter.User.Nationality n,int age, String email);
}
