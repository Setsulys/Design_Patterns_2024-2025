package fr.uge.visitor.exo2;

import java.util.Iterator;

public interface Expr {
    //public int eval();

    public<T> T accept(ExprVisitor<T> v);

    public static Expr parseExpr(Iterator<String> it) {
        if (!it.hasNext()) {
            throw new IllegalArgumentException("no more tokens");
        }
        String token = it.next();
        switch(token) {
            case "+":
                return new BinOp(parseExpr(it), parseExpr(it), token, (a, b) -> a + b);
            case "-":
                return new BinOp(parseExpr(it), parseExpr(it), token, (a, b) -> a - b);
            case "*":
                return new BinOp(parseExpr(it), parseExpr(it), token, (a, b) -> a * b);
            case "/":
                return new BinOp(parseExpr(it), parseExpr(it), token, (a, b) -> a / b);
            default:
                return new Value(Integer.parseInt(token));
        }
    }

}
