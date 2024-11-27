package com.evilcorp.stp;

import fr.uge.visitor.exo1.stpfixed.ComplexTreatmentProcessor;

public class StopTimerCmd implements STPCommand {

    private int  timerId;

    public StopTimerCmd(int timerId){
        this.timerId=timerId;
    }

    public int getTimerId() {
        return timerId;
    }

    @Override
    public void accept(ComplexTreatmentProcessor complexTreatment) {

    }
}
