package fr.uge.poo.uberclient.question1;

import fr.uge.poo.uberclient.question1.UberClient.*;
public record ToHTML() implements UberClientFormatter {
    @Override
    public String format(UberClient.UberClientInfo v) {
        //var averageGrade= v.grades().stream().mapToLong(l -> l).average().orElseThrow(() -> new AssertionError("Client are meant to have at least one grade"));
        return String.format("<h2>%s %s  (%1.2f*)</h2>",v.firstName(),v.lastName(), v.average());
    }
}
