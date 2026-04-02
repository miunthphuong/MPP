package prob1;

public class Trailer extends Property {

    public Trailer(Address address) {
        super(address);
    }

    @Override
    public double computeRent() {
        return 500;
    }
}
