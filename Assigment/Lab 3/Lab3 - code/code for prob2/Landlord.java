package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
    private List<Building> buildings;

    public Landlord() {
        buildings = new ArrayList<>();
    }

    public void addBuilding(Building b) {
        buildings.add(b);
    }

    public double calcProfits() {
        double totalProfit = 0;
        for (Building b : buildings) {
            totalProfit += b.calcProfit();
        }
        return totalProfit;
    }
}