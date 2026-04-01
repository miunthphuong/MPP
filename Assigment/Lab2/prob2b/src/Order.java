import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderNum;
    private List<OrderLine> lines;

    public Order(String orderNum) {
        this.orderNum = orderNum;
        this.lines = new ArrayList<>();
    }

    // thêm sản phẩm vào order
    public void addItem(String productName, int quantity, double price) {
        new OrderLine(this, productName, quantity, price);
    }

    // dùng nội bộ (giữ quan hệ 2 chiều)
    void registerLine(OrderLine line) {
        lines.add(line);
    }

    public double calculateTotal() {
        double sum = 0;
        for (OrderLine l : lines) {
            sum += l.getSubTotal();
        }
        return sum;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return "Order #" + orderNum + " | Total: $" + calculateTotal();
    }
}
