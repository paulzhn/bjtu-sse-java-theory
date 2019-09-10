package exercise4;

import com.sun.org.apache.xpath.internal.operations.Or;

public class OrderItem {
    private int quantity;
    private Product product;

    public OrderItem(Product initialProduct, int initialQuantity) {
        quantity = initialQuantity;
        product = initialProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return quantity * product.getPrice();
    }

    @Override
    public String toString() {
        return quantity + " " + product.getCode() + " " + product.getPrice();
    }
}
