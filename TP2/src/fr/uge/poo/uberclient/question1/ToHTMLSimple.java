package fr.uge.poo.uberclient.question1;

public record ToHTMLSimple() implements UberClientFormatter {
    @Override
    public String format(UberClient.UberClientInfo v) {
        return String.format("<h2>%s %s </h2>",v.firstName(),v.lastName());
    }
}
