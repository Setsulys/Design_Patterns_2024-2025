package fr.uge.poo.uberclient.question2;

import com.goodcorp.gmailer.GMailer;

import java.util.Objects;

public class GMailerAdapter implements Mailer {
    private GMailer gMailer = new GMailer();
    @Override
    public void sendMail(String mail, String subject, String content) {
        gMailer.send(mail,new GMailer.Mail(Objects.requireNonNull(subject),Objects.requireNonNull(content)));
    }
}
