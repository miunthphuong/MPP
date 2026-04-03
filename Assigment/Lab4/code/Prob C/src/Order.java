public class Order {
    private int orderNo;
    private String orderDate;
    private double orderAmount;

    public Order(int orderNo, String orderDate, double orderAmount) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}