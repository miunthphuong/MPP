import java.util.function.Supplier;

public class lab10_1bii {
    public static void main(String[] args) {
        //Assigning the lambda to a Supplier interface
        Supplier<Double> randomSupplier = () -> Math.random();

        //Using the get() method to print the result
        System.out.println("Random number (Lambda): " + randomSupplier.get());
    }
}
