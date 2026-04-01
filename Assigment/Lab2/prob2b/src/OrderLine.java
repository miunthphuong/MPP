public class OrderLine {
    private Order order;
    private String productName;
    private int quantity;
    private double price;

    public OrderLine(Order order, String productName, int quantity, double price) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        this.order = order;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;

        order.registerLine(this); // tự động add vào Order
    }

    public double getSubTotal() {
        return quantity * price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
