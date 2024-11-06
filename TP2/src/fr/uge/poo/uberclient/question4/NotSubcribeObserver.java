package fr.uge.poo.uberclient.question4;

public class NotSubcribeObserver implements NewsletterObserver{
    private final Mailer mailer = new GMailerAdapter();

    @Override
    public void onSubscribeWelcome(Newsletter newsletter, User user) {

    }

    @Override
    public void onSubscribeError(Newsletter newsletter, User user){
        mailer.sendMail("support@goodcorp.com", newsletter.name(), user.email());
    }

    @Override
    public void onSubscribeGoal(Newsletter newsletter) {

    }

    @Override
    public void onSpecificMail(Newsletter newsletter, User user) {

    }
}
