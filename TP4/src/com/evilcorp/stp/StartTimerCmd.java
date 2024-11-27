package com.evilcorp.stp;

import fr.uge.visitor.exo1.stpfixed.ComplexTreatmentProcessor;

public class StartTimerCmd implements STPCommand {

    private int  timerId;

    public StartTimerCmd(int timerId){
        this.timerId=timerId;
    }

    public int getTimerId() {
        return timerId;
    }

    @Override
    public void accept(ComplexTreatmentProcessor complexTreatment) {

    }
}
