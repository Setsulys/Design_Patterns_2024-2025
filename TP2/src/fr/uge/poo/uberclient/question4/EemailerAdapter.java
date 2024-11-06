package fr.uge.poo.uberclient.question4;

import com.evilcorp.eemailer.EEMailer;

public class EemailerAdapter implements Mailer {

    private EEMailer mailer = new EEMailer();
    @Override
    public void sendMail(String mail, String subject, String content) {
        mailer.send(new EEMailer.Mail(mail,subject,content));
    }
}
