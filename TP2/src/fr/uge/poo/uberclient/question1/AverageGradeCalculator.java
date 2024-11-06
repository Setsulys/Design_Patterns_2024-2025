package fr.uge.poo.uberclient.question1;

import java.util.List;
import java.util.OptionalDouble;

@FunctionalInterface
public interface AverageGradeCalculator {
    AverageGradeCalculator STANDARD =s -> s.stream().mapToLong(l -> l).average();

    OptionalDouble averaging(List<Integer> grades);
}
