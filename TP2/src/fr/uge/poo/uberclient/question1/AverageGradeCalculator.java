package fr.uge.poo.uberclient.question1;

import java.util.List;

@FunctionalInterface
public interface AverageGradeCalculator {
    double averaging(List<Integer> grades);
}
