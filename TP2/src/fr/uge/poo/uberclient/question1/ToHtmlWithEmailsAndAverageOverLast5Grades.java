package fr.uge.poo.uberclient.question1;

public record ToHtmlWithEmailsAndAverageOverLast5Grades() implements UberClientFormatter{

    @Override
    public String format(UberClient.UberClientInfo v) {
        var averageGrade= v.grades().stream().limit(5).mapToLong(l -> l).average().orElseThrow(() -> new AssertionError("Client are meant to have at least one grade"));
        return String.format("<h2>%s %s (%1.2f*) : %s </h2>",v.firstName(),v.lastName(),averageGrade,v.emails());
    }
}
