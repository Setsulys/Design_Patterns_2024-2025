package com.evilcorp.stp;

import fr.uge.visitor.exo1.stpfixed.ComplexTreatmentProcessor;

public interface STPCommand {
    void accept(ComplexTreatmentProcessor complexTreatment);
}
