package Prob4;

import java.time.LocalDate;

public class CustOrderFactory {

    public static Customer createCustomer(String name) {
        return new Customer(name);
    }

    public static Order addNewOrder(Customer cust, LocalDate date) {
        if(cust == null) throw new NullPointerException("Prob4.Customer cannot be null");
        Order ord = Order.createOrder(date);
        cust.addOrder(ord);
        return ord;
    }
}