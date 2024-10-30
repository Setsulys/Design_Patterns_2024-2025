package fr.uge.poo.uberclient.question2;

import java.util.List;
import com.goodcorp.gmailer.GMailer;

public interface Mailer {

    void sendMail(String mail,String subject,String content);

    default void sendAll(List<String> mails, String subject, String content){
        mails.forEach(e->sendMail(e,subject,content));
    }
}
