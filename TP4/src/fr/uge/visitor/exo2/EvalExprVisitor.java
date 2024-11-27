package fr.uge.visitor.exo2;

public class EvalExprVisitor implements ExprVisitor<Integer> {
    @Override
    public Integer visitValue(Value value) {
        return value.value();
    }

    @Override
    public Integer visitBinOp(BinOp binOp) {
        return binOp.op().applyAsInt(binOp.expr().accept(this), binOp.expr2().accept(this));
    }
}
