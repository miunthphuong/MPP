import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("123456");

        order.addItem("Laptop", 1, 2000);
        order.addItem("Mouse", 2, 10);
        order.addItem("Keyboard", 1, 15);

        System.out.println("Order:");
        for (OrderLine line : order.getLines()) {
            System.out.println(
                    line.getProductName() +
                            " | Quality: " + line.getQuantity() +
                            " | Price: $" + line.getPrice() +
                            " | Subtotal: $" + line.getSubTotal()
            );
        }

        System.out.println("Total: $" + order.calculateTotal());

        System.out.println(order.toString());
    }
}