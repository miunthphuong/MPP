package prob2;

public class ExpressionEvaluator {

    public static int eval(Expr expr) {
        return switch (expr) {
            case Constant c -> c.value();
            case Add a -> eval(a.left()) + eval(a.right());
            case Multiply m -> eval(m.left()) * eval(m.right());
        };
    }

    public static void main(String[] args) {
        // 3. Evaluate the complex expression: (2 + 3) * 4
        Expr expression = new Multiply(
                new Add(new Constant(2), new Constant(3)),
                new Constant(4)
        );

        int result = eval(expression);

        System.out.println("Expression: (2 + 3) * 4");
        System.out.println("Expected output: 20");
        System.out.println("Actual result: " + result);
    }
}
