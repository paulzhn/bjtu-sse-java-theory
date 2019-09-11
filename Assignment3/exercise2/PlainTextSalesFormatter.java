

public class PlainTextSalesFormatter implements SalesFormatter {
    private static final PlainTextSalesFormatter singletonInstance = new PlainTextSalesFormatter();

    private PlainTextSalesFormatter() {
    }

    public static PlainTextSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }

    @Override
    public String formatSales(Sales sales) {
        StringBuilder result = new StringBuilder("");
        int i = 0;
        for (Order order : sales) {
            i++;
            result.append("------------------------\n");
            result.append("Order ").append(i).append("\n\n");
            for (OrderItem item : order) {
                result.append(item.getQuantity() + " " + item.getProduct().getCode() + " " + item.getProduct().getPrice() + "\n");

            }
            result.append("\n" + "Total = " + order.getTotalCost() + "\n");
        }
        return result.toString();
    }
}
