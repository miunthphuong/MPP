package Prob5;

import java.util.Vector;

public class Customer {
    private String Name;
    private int ID;
    private Vector<Service> Services = new Vector<>();

    public Customer(String name, int id) {
        this.Name = name;
        this.ID = id;
    }

    public void addService(Service service) {
        Services.add(service);
    }

    public void removeService(Service service) {
        Services.remove(service);
    }

    public int totalFee() {
        int total = 0;
        for (Service s : Services) {
            total += s.calcFee();
        }
        return total;
    }
}
