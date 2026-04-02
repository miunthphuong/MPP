package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private double maintenanceCost;
    private List<Apartment> apartments;

    public Building(double maintenanceCost, int i) {
        this.maintenanceCost = maintenanceCost;
        this.apartments = new ArrayList<>();
    }

    public void addApartment(Apartment apt) {
        apartments.add(apt);
    }

    public double calcProfit() {
        double totalRent = 0;
        for (Apartment a : apartments) {
            totalRent += a.getRent();
        }
        return totalRent - maintenanceCost;
    }
}