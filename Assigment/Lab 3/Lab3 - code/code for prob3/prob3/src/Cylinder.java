public class Cylinder extends Circle {
    private double height;

    // Constructor
    public Cylinder(double radius, double height) {
        super(radius); // gọi constructor của Circle
        this.height = height;
    }

    // Getter
    public double getHeight() {
        return height;
    }

    // Compute volume
    public double computeVolume() {
        return computeArea() * height; // dùng method của Circle
    }
}