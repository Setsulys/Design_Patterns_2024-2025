package fr.uge.poo.uberclient.question4;


public interface NewsletterObserver {

    void onSubscribeWelcome(Newsletter newsletter, User user);
    void onSubscribeError(Newsletter newsletter, User user);
    void onSubscribeGoal(Newsletter newsletter);
    void onSpecificMail(Newsletter newsletter,User user);
}
