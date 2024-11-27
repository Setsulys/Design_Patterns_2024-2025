package fr.uge.visitor.exo2;

import java.util.function.IntBinaryOperator;

public record BinOp(Expr expr, Expr expr2, String token,IntBinaryOperator op) implements Expr {
//    @Override
//    public int eval() {
//        return op.applyAsInt(expr.eval(), expr2.eval());
//    }

    @Override
    public <R> R accept(ExprVisitor<R> v) {
        return v.visitBinOp(this);
    }

//    @Override
//    public String toString() {
//        return "("+expr.toString() + " " + token + " " + expr2.toString()+")";
//    }
}
