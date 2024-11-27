package fr.uge.visitor.exo1.stphipster;

public interface STPCommandVisitor {
    void visit(HelloCmd visitor);
    void visit(StartTimerCmd visitor);
    void visit(StopTimerCmd visitor);
    void visit(ElapsedTimeCmd visitor);
}
