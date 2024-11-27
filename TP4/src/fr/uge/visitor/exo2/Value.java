package fr.uge.visitor.exo2;

public record Value(int value) implements Expr{
//    @Override
//    public int eval() {
//        return value;
//    }

    @Override
    public <E> E accept(ExprVisitor<E> v) {
        return v.visitValue(this);
    }

//    @Override
//    public String toString() {
//        return String.valueOf(value);
//    }
}
