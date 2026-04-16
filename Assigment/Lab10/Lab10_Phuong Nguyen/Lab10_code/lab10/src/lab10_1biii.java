import java.util.function.Supplier;

public class lab10_1biii {

    // Nested inner class implementing the functional interface
    private static class RandomNumberSupplier implements Supplier<Double> {
        @Override
        public Double get() {
            return Math.random();
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the inner class
        Supplier<Double> supplier = new RandomNumberSupplier();

        // Outputting the random number
        System.out.println("Random number (Inner Class): " + supplier.get());
    }
}