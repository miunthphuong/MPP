package Prob4.extpackage;

import java.time.LocalDate;
import Prob4.Customer;
import Prob4.Order;
import Prob4.CustOrderFactory; // Import Factory

public class Main {
    public static void main(String[] args) {
        Customer cust = CustOrderFactory.createCustomer("Phuong Nguyen");

        Order order = CustOrderFactory.addNewOrder(cust, LocalDate.now());
        order.addItem("Shirt");
        order.addItem("Laptop");

        order = CustOrderFactory.addNewOrder(cust, LocalDate.now());
        order.addItem("Pants");
        order.addItem("Screen");

        System.out.println("Orders for " + cust.getName() + ":");
        System.out.println(cust.getOrders());
    }
}