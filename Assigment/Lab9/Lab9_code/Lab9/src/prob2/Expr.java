package prob2;

public sealed interface Expr permits Constant, Add, Multiply {
}

record Constant(int value) implements Expr {
}

record Add(Expr left, Expr right) implements Expr {
}

record Multiply(Expr left, Expr right) implements Expr {
}