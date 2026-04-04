package Prob4;

import java.util.ArrayList;
import java.util.List;

class Building {
    private String buildingNumber;
    private List<Apartments> apartments;

    public Building(String buildingNumber) {
        this.buildingNumber = buildingNumber;
        this.apartments = new ArrayList<>();
    }

    public void addApartment(Apartments apartment) {
        apartments.add(apartment);
    }

    public double getRent() {
        double totalBuildingRent = 0;
        for (Apartments apt : apartments) {
            totalBuildingRent += apt.getRent();
        }
        return totalBuildingRent;
    }
}