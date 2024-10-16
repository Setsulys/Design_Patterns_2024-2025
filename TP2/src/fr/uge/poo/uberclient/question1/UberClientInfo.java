package fr.uge.poo.uberclient.question1;

import java.util.List;

public record UberClientInfo (String firstName,String lastName,List<Integer> grades,List<String> emails) {
	public String toHTML() {
		var averageGrade= grades.stream().mapToLong(l -> l).average().orElseThrow(() -> new AssertionError("Client are meant to have at least one grade"));
		return String.format("<h2>%s %s  (%1.2f*)</h2>",firstName,lastName,averageGrade);
	}

	public String toHTMWithAverageOverLast7Grades() {
		var averageGrade= grades.stream().limit(7).mapToLong(l -> l).average().orElseThrow(() -> new AssertionError("Client are meant to have at least one grade"));
		return String.format("<h2>%s %s  (%1.2f*)</h2>",firstName,lastName,averageGrade);
	}

	public String toHTMLSimple() {
		return String.format("<h2>%s %s </h2>",firstName,lastName);
	}

	public String toHtmlWithEmails() {
		var averageGrade = grades.stream().mapToLong(l -> l).average().orElseThrow(() -> new AssertionError("Client are meant to have at least one grade"));
		return String.format("<h2>%s %s (%1.2f*) : %s </h2>",firstName,lastName,averageGrade,emails);
	}

	public String toHtmlWithEmailsAndAverageOverLast5Grades() {
		var averageGrade= grades.stream().limit(5).mapToLong(l -> l).average().orElseThrow(() -> new AssertionError("Client are meant to have at least one grade"));
		return String.format("<h2>%s %s (%1.2f*) : %s </h2>",firstName,lastName,averageGrade,emails);
	}

}
