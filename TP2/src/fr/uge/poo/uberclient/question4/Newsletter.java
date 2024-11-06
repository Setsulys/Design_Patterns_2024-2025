package fr.uge.poo.uberclient.question4;

import java.util.*;
import java.util.function.Consumer;

public class Newsletter {
    private final String name;
    private final Set<User> users = new HashSet<>();
    private final UserValidator restrictions;
    private final Mailer mailer;

    private final List<NewsletterObserver> observers = new ArrayList<>();
    private final NewsletterObserver subObservers = new SubscribeObserver();

    public static class Step{

        public static Builder newbuilder(){return new Builder();}

        private static class Builder {
            private UserValidator restrictions;
            private Mailer mailer = new EemailerAdapter();

            public Builder nationalityRestriction(UserValidator validator) {
                var previous = this.restrictions;
                this.restrictions = (previous==null)? validator : e-> previous.isValid(e) && validator.isValid(e);
                return this;
            }

            public Builder ageRestriction(UserValidator validator){
                var previous = this.restrictions;
                this.restrictions = (previous==null)? validator : e-> previous.isValid(e) && validator.isValid(e);
                return this;
            }

            public Builder emailRestriction(UserValidator validator){
                var previous = this.restrictions;
                this.restrictions = (previous==null)? validator : e-> previous.isValid(e) && validator.isValid(e);
                return this;
            }

            public Builder GoodMailer(){
                this.mailer =new GMailerAdapter();
                return this;
            }

            public Builder EeMailer(){
                this.mailer =new EemailerAdapter();
                return this;
            }

            public Newsletter with(String name){
                return new Newsletter(name, restrictions,mailer);
            }
        }
    }

    /*public Newsletter(String name){
        this(name,(n,a,e)->true);
    }*/

    private Newsletter(String name, UserValidator restrictions, Mailer mailer){
        this.name = Objects.requireNonNull(name);
        this.restrictions = restrictions;
        this.mailer = mailer;
    }

    private Newsletter(String name, UserValidator restrictions){
        this.name = Objects.requireNonNull(name);
        this.restrictions = restrictions;
        this.mailer = new EemailerAdapter();
    }

    public void subscribe(User user){
        Objects.requireNonNull(user);
        if(!restrictions.isValid(user)|| users.contains(user)){
            new NotSubcribeObserver().onSubscribeError(this,user);
            throw new IllegalArgumentException();
        }
        users.add(user);
        new SubscribeObserver().onSubscribeWelcome(this,user);
        new GoalObserver().onSubscribeGoal(this);
        new SpyObserver().onSpecificMail(this,user);
    }

    public void unSubscribe(User user){
        if(!users.remove(Objects.requireNonNull(user))){
            throw new IllegalArgumentException();
        }
    }

    public void sendMessage(String title,String content){
        var subject = "["+ name + "]"+title;
        mailer.sendAll(users.stream().map(User::email).toList(),subject,content);
    }

    public String name(){
        return name;
    }
    public List<User> users(){
        return new ArrayList<User>(users);
    }

    public static void main(String[] args) {
//        var potter = new Newsletter("Potter 4ever",n->  n.nationality() == User.Nationality.BRITISH && n.age() >= 18);
//        var java = new Newsletter("Java 4ever",n-> n.nationality()==User.Nationality.FRENCH && n.age() >21);
//        var why = new Newsletter("Why me",n-> n.age()%2==0 && n.email().endsWith("@univ-eiffel.fr"));

        var user = new User("Steven","sly@user.fr",24, User.Nationality.FRENCH);
        var user2 = new User("Christophe","cha@user.fr",24, User.Nationality.FRENCH);
        var user3 = new User("youssef","youssef@univ-eiffel.fr",52,User.Nationality.FRENCH);
        var user4 = new User("Christophe","cha@user.fr",24, User.Nationality.BRITISH);
        var user5 = new User("Arnaud","arnaudcarayol@univ-eiffel.fr",52,User.Nationality.FRENCH);
        var user1= new User("Babyboy","XXXxxxXXX@univ-eiffel.fr",13,User.Nationality.FRENCH);


        var potter = Step.newbuilder().ageRestriction(n-> n.age()>=18).nationalityRestriction(n->n.nationality()==User.Nationality.BRITISH).with("Potter 4ever");
        var java = Step.newbuilder().ageRestriction(n-> n.age()>21).nationalityRestriction(n->n.nationality()==User.Nationality.FRENCH).with("Java 4ever");
        var why = Step.newbuilder().ageRestriction(n-> n.age()%2==0).emailRestriction(n->n.email().endsWith("@univ-eiffel.fr")).with("Potter 4ever");


        potter.subscribe(user4);
        java.subscribe(user5);
        java.subscribe(user);
        java.subscribe(user2);
        why.subscribe(user3);

        var pown = Step.newbuilder().ageRestriction(e->e.age()>=18).nationalityRestriction(e-> e.nationality()==User.Nationality.FRENCH).with("Youtube");

        pown.subscribe(user2);
        pown.sendMessage("Nouvelle video","RickRoll");
        //pown.subscribe(user1);
        pown.unSubscribe(user2);
        pown.sendMessage("Derniere video","Thread horreur");

        //Test GMailer et Eemailer
        var pown2 = Step.newbuilder().ageRestriction(e->e.age()>=18).nationalityRestriction(e-> e.nationality()==User.Nationality.FRENCH).GoodMailer().with("DALYMOTION");
        pown2.subscribe(user);
        pown2.subscribe(user2);
        pown2.sendMessage("Nouvelle video","RickRoll v2");
        pown2.unSubscribe(user);
        pown2.sendMessage("Derniere video","Thread JDG");
        var pown3 = Step.newbuilder().ageRestriction(e->e.age()>=18).nationalityRestriction(e-> e.nationality()==User.Nationality.FRENCH).EeMailer().with("DALYMOTION");
        pown3.subscribe(user);
        pown3.subscribe(user2);
        pown3.sendMessage("Nouvelle video","RickRoll v2");
        pown3.unSubscribe(user);
        pown3.sendMessage("Derniere video","Thread JDG");
    }
}

/**
 * Quel principe solide empêche de tout simplement coder ces fonctionalités dans la classe Newsletter ?
 *
 * Le principe solid non respecté est la Single responsibility principle
 */
