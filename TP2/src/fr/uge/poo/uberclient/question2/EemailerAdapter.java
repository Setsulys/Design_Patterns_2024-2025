package fr.uge.poo.uberclient.question2;

import com.evilcorp.eemailer.EEMailer;

import java.util.Objects;

public class EemailerAdapter implements Mailer{

    private EEMailer mailer = new EEMailer();
    @Override
    public void sendMail(String mail, String subject, String content) {
        mailer.send(new EEMailer.Mail(Objects.requireNonNull(mail),Objects.requireNonNull(subject),Objects.requireNonNull(content)));
    }
}
