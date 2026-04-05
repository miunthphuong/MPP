package Prob4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDate orderDate;
    private List<Item> items;

    private Order(LocalDate orderDate) {
        this.orderDate = orderDate;
        items = new ArrayList<Item>();
    }

    static Order createOrder(LocalDate date) {
        return new Order(date);
    }

    public void addItem(String name){
        items.add(new Item(name));
    }

    @Override
    public String toString() {
        return orderDate + ": " + items.toString();
    }
}