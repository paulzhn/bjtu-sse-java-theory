package exercise4;

public class Product {
    private String code;
    private String description;
    private double price;

    public Product(String initialCode, String initialDescription, double initialPrice) {
        code = initialCode;
        description = initialDescription;
        price = initialPrice;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Product)) {
            return false;
        }

        final Product a = (Product) obj;
        return a.getCode().equals(this.getCode());
    }

    @Override
    public String toString() {
        return code + "_" + description + "_" + price;
    }


}
