package fr.uge.poo.uberclient.question1;

import java.util.ArrayList;
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

	public static class UberClientInfo{
			String firstName;
			String lastName;
			List<String> emails;
			double average;
			private UberClientInfo(String firstName,String lastName,List<Integer> grades,List<String> emails, AverageGradeCalculator strategy) {
				this.firstName = firstName;
				this.lastName = lastName;
				this.emails = emails;
				average = strategy.averaging(grades);
			}

			public String firstName(){
				return firstName;
			}
			public String lastName(){
				return lastName;
			}
			public List<String> emails(){
				return emails;
			}
			public double average(){
				return average;
			}
	}


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
	private List<String> printEmails(List<String> emails){
		return emails.stream().map(e-> {
			var split=e.split("@");
			var name = split[0].charAt(0)+"*";
			var domain = split[1].charAt(0)+"*";
			return name+"@"+domain;
		}).toList();
	}

	private UberClientInfo info(AverageGradeCalculator strategy) {
		return new UberClientInfo(firstName, lastName, grades, printEmails(emails), strategy);
	}
	private UberClientInfo info() {
		return new UberClientInfo(firstName, lastName, grades, printEmails(emails), AverageGradeCalculator.STANDARD);
	}
	
	public String exportView(UberClientFormatter formatter) {
        return formatter.format(info());
    }

	public String exportView(UberClientFormatter formatter,AverageGradeCalculator strategy){
		return formatter.format(info(strategy));
	}



	public static class Step{

		public static FirstNameStep newBuilder() {
			return new Builder();
		}
		public interface FirstNameStep{
			public LastNameStep firstName(String firstName);
		}
		public interface LastNameStep{
			public UidStep lastName(String lastName);
		}
		public interface UidStep{
			public GradeStep uid(long uid);
		}
		public interface GradeStep{
			public EmailStep grade(int grades);
		}
		public interface EmailStep{
			public PhoneNumberStep email(String emails);
		}
		public interface PhoneNumberStep{
			public BuildStep phoneNumber(String phoneNumbers);
		}

		public interface BuildStep{
			public UberClient build();
		}

		public static class Builder implements FirstNameStep, LastNameStep, UidStep, GradeStep, EmailStep, PhoneNumberStep,BuildStep{
			private String firstName;
			private String lastName;
			private long uid;
			private final List<Integer> grades = new ArrayList<>();
			private final List<String> emails= new ArrayList<>();
			private final List<String> phoneNumbers= new ArrayList<>();

			public LastNameStep firstName(String firstName) {
				this.firstName = Objects.requireNonNull(firstName);
				return this;
			}

			public UidStep lastName(String lastName) {
				this.lastName = Objects.requireNonNull(lastName);
				return this;
			}

			public GradeStep uid(long uid) {
				if (uid<0) {
					throw new IllegalArgumentException("UID must be positive");
				}
				this.uid = uid;
				return this;
			}

			public EmailStep grade(int grade) {
				if (grade < 1 ||grade > 5) {
					throw new IllegalArgumentException("All grades must be between 1 and 5");
				}
				this.grades.add(grade);
				return this;
			}

			public PhoneNumberStep email(String email) {
				this.emails.add(email);
				return this;
			}

			public BuildStep phoneNumber(String phoneNumbers) {
				this.phoneNumbers.add(phoneNumbers);
				return this;
			}

			public UberClient build() {
				if (firstName == null || lastName == null){
					throw new IllegalStateException();
				}
				if (emails.isEmpty() && phoneNumbers.isEmpty()) {
					throw new IllegalArgumentException("A client must have at least an email or a phoneNumber");
				}
				return new UberClient(firstName,lastName,grades,emails,phoneNumbers);
			}
		}   
	}
}

