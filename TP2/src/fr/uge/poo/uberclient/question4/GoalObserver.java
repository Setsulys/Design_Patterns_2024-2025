package fr.uge.poo.uberclient.question4;

public class GoalObserver implements NewsletterObserver {

    private final Mailer mailer = new GMailerAdapter();

    @Override
    public void onSubscribeWelcome(Newsletter newsletter, User user) {

    }

    @Override
    public void onSubscribeError(Newsletter newsletter, User user) {

    }

    @Override
    public void onSubscribeGoal(Newsletter newsletter) {
        if(newsletter.users().size()> 100){
            mailer.sendMail("sales@goodcorp.com", newsletter.name(), newsletter.users().stream().map(User::name).toList().toString());
        }
    }

    @Override
    public void onSpecificMail(Newsletter newsletter, User user) {

    }
}
