package fr.uge.poo.uberclient.question4;

import com.goodcorp.gmailer.GMailer;

public class GMailerAdapter implements Mailer {
    private GMailer gMailer = new GMailer();
    @Override
    public void sendMail(String mail, String subject, String content) {
        gMailer.send(mail,new GMailer.Mail(subject,content));
    }
}
