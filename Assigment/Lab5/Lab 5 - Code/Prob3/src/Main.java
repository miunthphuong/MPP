import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<>();

        figures.add(new Rectangle(5.0, 4.0));  // Area: 20.0
        figures.add(new Triangle(10.0, 2.0)); // Area: 10.0
        figures.add(new Circle(3.0));         // Area: ~28.27

        double totalArea = 0;
        for (Figure f : figures) {
            totalArea += f.computeArea();
        }

        System.out.printf("Sum of Areas = %.2f%n", totalArea);
    }
}