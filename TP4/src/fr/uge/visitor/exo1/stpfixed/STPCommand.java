package fr.uge.visitor.exo1.stpfixed;

public sealed interface STPCommand permits ElapsedTimeCmd,HelloCmd,StartTimerCmd,StopTimerCmd{
    void accept(STPCommandVisitor visitor);
}
