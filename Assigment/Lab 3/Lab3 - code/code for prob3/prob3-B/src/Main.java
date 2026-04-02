public class Main {
    public static void main(String[] args) {
        Cylinder c = new Cylinder(3, 5);

        System.out.println("Radius: " + c.getRadius());
        System.out.println("Height: " + c.getHeight());
        System.out.println("Volume: " + c.computeVolume());
    }
}