public class Cylinder {
    private double height;
    private Circle base; // composition

    // Constructor
    public Cylinder(double radius, double height) {
        this.base = new Circle(radius);
        this.height = height;
    }

    // Getter
    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return base.getRadius(); // delegate to Circle
    }

    // Compute volume
    public double computeVolume() {
        return base.computeArea() * height;
    }
}