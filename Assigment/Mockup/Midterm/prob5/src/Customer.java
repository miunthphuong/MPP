import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private List<Service> subscribedServices;

    public Customer(String name) {
        this.name = name;
        this.subscribedServices = new ArrayList<>();
    }

    public void addService(Service service) {
        subscribedServices.add(service);
    }

    public double totalFee() {
        double total = 0;
        for (Service service : subscribedServices) {
            total += service.calcFee(getServicePrice(service));
        }
        return total;
    }

    // Helper method to retrieve the daily price of a service
    private double getServicePrice(Service service) {
        // Logic to retrieve the daily price based on the service type (Monthly or Daily)
        return service.getDailyPrice();
    }
}

