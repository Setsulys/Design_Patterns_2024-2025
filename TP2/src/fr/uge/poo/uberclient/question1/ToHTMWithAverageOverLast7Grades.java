package fr.uge.poo.uberclient.question1;

public class ToHTMWithAverageOverLast7Grades implements UberClientFormatter {
    private AverageGradeCalculator averageGrade=  s -> s.stream().limit(7).mapToLong(l -> l).average().orElseThrow(() -> new AssertionError("Client are meant to have at least one grade"));
    @Override
    public String format(UberClient.UberClientInfo v) {
        return String.format("<h2>%s %s  (%1.2f*)</h2>",v.firstName(),v.lastName(),averageGrade.averaging(v.grades()));
    }
}
