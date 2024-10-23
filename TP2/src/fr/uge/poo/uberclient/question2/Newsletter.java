package fr.uge.poo.uberclient.question2;

import com.evilcorp.eemailer.EEMailer;

import java.util.*;

public class Newsletter {
    private String name;
    private Set<User> users = new HashSet<>();
    private EEMailer eemailer = new EEMailer();
    private final UserValidator restrictions;

    public record User(String name, String email, int age, Nationality nationality) {
        public enum Nationality {
            FRENCH,BRITISH,SPANISH
        }

        public User {
            Objects.requireNonNull(name);
            Objects.requireNonNull(email);
            if (age<0) {
                throw new IllegalArgumentException("Age must be positive");
            }
            Objects.requireNonNull(nationality);
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof User usr
                    && email.equals(usr.email);
        }
    }

    public Newsletter(String name){
        this(name,(n,a,e)->true);
    }

    public Newsletter(String name,UserValidator restrictions){
        this.name = Objects.requireNonNull(name);
        this.restrictions = restrictions;
    }

    public void subscribe(User user){
        Objects.requireNonNull(user);
        if(!restrictions.isValid(user.nationality(), user.age(), user.email() )|| users.contains(user)){
            throw new IllegalArgumentException();
        }
        users.add(user);
    }

    public void unSubscribe(User user){
        if(!users.remove(Objects.requireNonNull(user))){
            throw new IllegalArgumentException();
        }
    }

    public void sendMessage(String title,String content){
        var subject = "["+ name + "]"+title;
        users.forEach(e-> eemailer.send(new EEMailer.Mail(e.email,subject,content)));
    }


    public static void main(String[] args) {
        var potter = new Newsletter("Potter 4ever",(n, age, email) -> n == User.Nationality.BRITISH && age >= 18);
        var java = new Newsletter("Java 4ever",(n, age, email) -> n==User.Nationality.FRENCH && age >21);
        var why = new Newsletter("Why me",(n, age, email) -> age%2==0 && email.endsWith("@univ-eiffel.fr"));

        var user = new User("Steven","sly@user.fr",24, User.Nationality.FRENCH);
        var user2 = new User("Christophe","cha@user.fr",24, User.Nationality.FRENCH);

        var user3 = new User("youssef","youssef@univ-eiffel.fr",52,User.Nationality.FRENCH);
        var user4 = new User("Christophe","cha@user.fr",24, User.Nationality.BRITISH);
        var user5 = new User("Arnaud","arnaudcarayol@univ-eiffel.fr",52,User.Nationality.FRENCH);
        potter.subscribe(user4);
        java.subscribe(user5);
        java.subscribe(user);
        java.subscribe(user2);
        why.subscribe(user3);

    }
}
