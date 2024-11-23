package fr.uge.visitor.exo2;

public interface ExprVisitor<T> {
    public T visitValue(Value value);
    public T visitBinOp(BinOp binOp);
}