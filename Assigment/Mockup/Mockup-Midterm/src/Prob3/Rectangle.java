package Prob3;

public class Rectangle {
    private double length, width, diagonal;

    private Rectangle(double length, double width, double diagonal) {
        this.length = length;
        this.width = width;
        this.diagonal = diagonal;
    }

    public static Rectangle fromSides(double len, double width) {
        double diag = Math.sqrt(len * len + width * width);
        return new Rectangle(len, width, diag);
    }

    public static Rectangle fromDiagonal(double width, double diag) {
        double len = Math.sqrt(diag * diag - width * width);
        return new Rectangle(len, width, diag);
    }

    public double computeArea() {
        return length * width;
    }
}
