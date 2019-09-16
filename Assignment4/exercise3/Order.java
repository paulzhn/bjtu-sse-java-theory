import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Iterator;

public class Order implements Iterable<OrderItem>{
    ArrayList<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        items.remove(orderItem);
    }

    @Override
    public Iterator<OrderItem> iterator() {
        return items.iterator();
    }

    public OrderItem getItem(Product product) {
        for (OrderItem item : items) {
            if (item.getProduct().equals(product)) {
                return item;
            }
        }
        return null;
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public double getTotalCost() {
        double totalCost = 0.0;
        for (OrderItem item : items) {
            totalCost += item.getValue();
        }
        return totalCost;
    }
}
