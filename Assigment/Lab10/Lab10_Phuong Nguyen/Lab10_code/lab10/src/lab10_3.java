import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class lab10_3 {
    public static void main(String[] args) {

        // 1. Assign the lambda to an appropriate BiFunction type
        BiFunction<Double, Double, List<Double>> myBiFunc = (x, y) -> {
            List<Double> list = new ArrayList<>();
            list.add(Math.pow(x, y));
            list.add(x * y);
            return list;
        };

        // 2. Call the apply method with arguments (2.0, 3.0)
        List<Double> result = myBiFunc.apply(2.0, 3.0);

        // 3. Print the result to the console
        System.out.println(result);
    }
}