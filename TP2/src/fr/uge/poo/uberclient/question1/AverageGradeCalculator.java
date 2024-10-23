package fr.uge.poo.uberclient.question1;

import java.util.List;

@FunctionalInterface
public interface AverageGradeCalculator {
    AverageGradeCalculator STANDARD =s->s.stream().mapToLong(l -> l).average().orElseThrow(() -> new AssertionError("Client are meant to have at least one grade"));

    double averaging(List<Integer> grades);
}
