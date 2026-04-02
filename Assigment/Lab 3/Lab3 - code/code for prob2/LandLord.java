package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class LandLord {
    private List<Building> buildings;

    public LandLord() {
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