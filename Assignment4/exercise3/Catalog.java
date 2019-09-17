import java.util.ArrayList;
import java.util.Iterator;

public class Catalog implements Iterable<Product> {
    ArrayList<Product> products;

    public Catalog() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    public Product getProduct(String code) {
        for (Product product : products) {
            if (product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }

    public int getNumberOfProducts() {
        return products.size();
    }
}
