package fr.uge.poo.uberclient.question4;


public class SubscribeObserver implements NewsletterObserver {
    private final Mailer mailer = new GMailerAdapter();

    @Override
    public void onSubscribeWelcome(Newsletter newsletter, User user) {
        mailer.sendMail(user.email(), newsletter.name(), "Welcome to"+newsletter.name()+"\\'s newsletter");
    }

    @Override
    public void onSubscribeError(Newsletter newsletter, User user){
    }
    @Override
    public void onSubscribeGoal(Newsletter newsletter) {
    }
    @Override
    public void onSpecificMail(Newsletter newsletter,User user) {
    }
}
