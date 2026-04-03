public class Main {
    public static void main(String[] args) {


        Employee e1 = new Hourly(1, 20, 40);
        Employee e2 = new Salaried(2, 5000);
        Commissioned e3 = new Commissioned(3, 2000, 0.1);

        e3.addOrder(new Order(101, 3, 2026, 1000));
        e3.addOrder(new Order(102, 3, 2026, 2000));
        e3.addOrder(new Order(103, 2, 2026, 5000)); // không tính

        Paycheck p1 = e1.calcCompensation(3, 2026);
        Paycheck p2 = e2.calcCompensation(3, 2026);
        Paycheck p3 = e3.calcCompensation(3, 2026);

        System.out.println("Hourly:");
        p1.print();
        System.out.println("\nSalaries:");
        p2.print();
        System.out.println("\nCommissioned:");
        p3.print();
    }
}