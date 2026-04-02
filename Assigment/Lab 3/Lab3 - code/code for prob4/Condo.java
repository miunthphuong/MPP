package prob1;

public class Condo extends Property {
    private int numFloors;

    public Condo(Address address, int numFloors) {
        super(address);
        this.numFloors = numFloors;
    }

    @Override
    public double computeRent() {
        return 400 * numFloors;
    }
}