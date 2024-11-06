package fr.uge.poo.uberclient.question1;

public class ToHTMWithAverageOverLast7Grades implements UberClientFormatter {
    @Override
    public String format(UberClient.UberClientInfo v) {
        return String.format("<h2>%s %s  (%1.2f*)</h2>",v.firstName(),v.lastName(), v.average().orElseThrow());
    }
}
