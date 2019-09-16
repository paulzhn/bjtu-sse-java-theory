import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Iterator;

public class Sales implements Iterable<Order>{
    ArrayList<Order> orders;

    public Sales() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }

    public int getNumberOfOrders() {
        return orders.size();
    }
}
