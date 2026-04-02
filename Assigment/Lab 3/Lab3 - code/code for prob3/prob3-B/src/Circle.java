public class Circle {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter
    public double getRadius() {
        return radius;
    }

    // Compute area
    public double computeArea() {
        return Math.PI * radius * radius;
    }
}