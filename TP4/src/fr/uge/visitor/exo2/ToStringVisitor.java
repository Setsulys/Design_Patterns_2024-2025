package fr.uge.visitor.exo2;

public class ToStringVisitor implements ExprVisitor<String>{
    private final StringBuilder buf = new StringBuilder();


    @Override
    public String visitValue(Value value) {
        return buf.append(String.valueOf(value.value())).toString();
        //return String.valueOf(value.value());
    }

    @Override
    public String visitBinOp(BinOp binOp) {
        buf.append("(");
        binOp.expr().accept(this);
        buf.append(" ").append(binOp.token());
        buf.append(" ");
        binOp.expr2().accept(this);
        buf.append(")");
        return buf.toString();
        //return "("+binOp.expr().accept(this) + " " + binOp.token() + " " + binOp.expr2().accept(this)+")";
    }
}
