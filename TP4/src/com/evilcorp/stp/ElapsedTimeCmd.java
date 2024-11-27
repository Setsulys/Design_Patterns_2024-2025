package com.evilcorp.stp;

import fr.uge.visitor.exo1.stpfixed.ComplexTreatmentProcessor;

import java.util.List;
import java.util.Objects;

public class ElapsedTimeCmd implements STPCommand {

    private final List<Integer> timers;

    public ElapsedTimeCmd(List<Integer> timers) {
        Objects.requireNonNull(timers);
        this.timers = List.copyOf(timers);
    }

    public List<Integer> getTimers() {
        return timers;
    }

    @Override
    public void accept(ComplexTreatmentProcessor complexTreatment) {

    }
}
