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
			private List<Integer> grades = new ArrayList<>();
			private List<String> emails= new ArrayList<>();
			private List<String> phoneNumbers= new ArrayList<>();

			public LastNameStep firstName(String firstName) {
				this.firstName = Objects.requireNonNull(firstName);
				return this;
			}

			public UidStep lastName(String lastName) {
				this.lastName = Objects.requireNonNull(lastName);
				return this;
			}

			public GradeStep uid(long uid) {
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
				if (emails.size()==0 && phoneNumbers.size()==0) {
					throw new IllegalArgumentException("A client must have at least an email or a phoneNumber");
				}
				return new UberClient(firstName,lastName,grades,emails,phoneNumbers);
			}
		}   
	}
}

