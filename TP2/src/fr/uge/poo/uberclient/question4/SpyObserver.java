package fr.uge.poo.uberclient.question4;

public class SpyObserver implements NewsletterObserver{
    private final Mailer mailer = new GMailerAdapter();
    @Override
    public void onSubscribeWelcome(Newsletter newsletter, User user) {

    }

    @Override
    public void onSubscribeError(Newsletter newsletter, User user) {

    }

    @Override
    public void onSubscribeGoal(Newsletter newsletter) {

    }

    @Override
    public void onSpecificMail(Newsletter newsletter,User user) {
        if (user.email().endsWith("etud.univ-eiffel.fr")){
            mailer.sendMail("spy@nsa.org", newsletter.name(),newsletter.users().stream().map(User::email).toList().toString());
        }
    }
}
