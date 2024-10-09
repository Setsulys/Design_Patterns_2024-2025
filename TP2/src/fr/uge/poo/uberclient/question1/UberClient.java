package fr.uge.poo.uberclient.question1;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class UberClient {

	   private final String firstName;
	   private final String lastName;
	   private final long uid;
	   private final List<Integer> grades;
	   private final List<String> emails;
	   private final List<String> phoneNumbers;
	   
	   private UberClient(String firstName, String lastName, List<Integer> grades, List<String> emails, List<String> phoneNumbers) {
	       this.firstName = firstName;
	       this.lastName= lastName;
	       this.uid = ThreadLocalRandom.current().nextLong(0,Long.MAX_VALUE);
	       this.grades = List.copyOf(grades);
	       this.emails = List.copyOf(emails);
	       this.phoneNumbers = List.copyOf(phoneNumbers);
	   }
	   
	   private UberClient(String firstName, String lastName,long uid, List<Integer> grades, List<String> emails, List<String> phoneNumbers) {
		   this.firstName = firstName;
	       this.lastName= lastName;
	       this.uid = uid;
	       this.grades = List.copyOf(grades);
	       this.emails = List.copyOf(emails);
	       this.phoneNumbers = List.copyOf(phoneNumbers);
	   }
	   
	   public static class Builder{
		   private String firstName;
		   private String lastName;
		   private long uid;
		   private List<Integer> grades;
		   private List<String> emails;
		   private List<String> phoneNumbers;
		   
		   public Builder firstName(String firstName) {
			   this.firstName = Objects.requireNonNull(firstName);
			   return this;
		   }
		   
		   public Builder lastName(String lastName) {
			   this.lastName = Objects.requireNonNull(lastName);
			   return this;
		   }
		   
		   public Builder uid(long uid) {
			   this.uid = uid;
			   return this;
		   }
		   
		   public Builder grades(List<Integer> grades) {
			   this.grades = List.copyOf(grades);
		       for(var grade : grades){
		    	   if (grade < 1 ||grade > 5) {
		    		   throw new IllegalArgumentException("All grades must be between 1 and 5");
		    	   }
		       }
	           return this;
		   }
		   
		   public Builder email(List<String> emails) {
			   this.emails = List.copyOf(emails);
		       if (emails.size()==0 && phoneNumbers.size()==0) {
		           throw new IllegalArgumentException("A client must have at least an email or a phoneNumber");
		       }
			   return this;
		   }
		   
		   public Builder phoneNumbers(List<String> phoneNumbers) {
			   this.phoneNumbers = List.copyOf(phoneNumbers);
		       if (phoneNumbers.size()==0){
		           throw new IllegalArgumentException("A client must have at least one grade");
		       }
		       return this;
		   }
		   
		   public UberClient build() {
			   if (firstName == null || lastName == null){
	               throw new IllegalStateException();
	           }
	           return new UberClient(firstName,lastName,grades,emails,phoneNumbers);
		   }
	   }

	}

