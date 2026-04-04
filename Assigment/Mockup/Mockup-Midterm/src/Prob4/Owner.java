package Prob4;

import java.util.ArrayList;
import java.util.List;

class Owner {
    private String name;
    private String telNumber;
    private List<Building> buildings;

    public Owner(String name, String telNumber) {
        this.name = name;
        this.telNumber = telNumber;
        this.buildings = new ArrayList<>();
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public double getRent() {
        double totalRent = 0;
        for (Building b : buildings) {
            totalRent += b.getRent();
        }
        return totalRent;
    }
}