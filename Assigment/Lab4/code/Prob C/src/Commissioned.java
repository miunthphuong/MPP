import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee {
    private double commission;
    private double baseSalary;
    private List<Order> orders = new ArrayList<>();

    public Commissioned(int empId, double baseSalary, double commission) {
        super(empId);
        this.baseSalary = baseSalary;
        this.commission = commission;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    protected double calcGrossPay(int month, int year) {
        double totalSales = 0;

        for (Order o : orders) {
            if (o.getMonth() == month && o.getYear() == year) {
                totalSales += o.getOrderAmount();
            }
        }

        return baseSalary + (commission * totalSales);
    }
}