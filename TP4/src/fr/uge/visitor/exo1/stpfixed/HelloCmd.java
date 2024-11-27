package fr.uge.visitor.exo1.stpfixed;

public final class HelloCmd implements STPCommand {


    @Override
    public void accept(STPCommandVisitor visitor) {
        visitor.visit(this);
    }
}