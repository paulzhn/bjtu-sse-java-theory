public class XMLSalesFormatter implements SalesFormatter {
    private final static XMLSalesFormatter singletonInstance = new XMLSalesFormatter();

    private XMLSalesFormatter() {

    }

    public static XMLSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }

    @Override
    public String formatSales(Sales sales) {
        StringBuilder result = new StringBuilder("");
        result.append("<Sales>\n");
        for (Order order : sales) {
            result.append("\t<Order total=\"").append(order.getTotalCost()).append("\">\n");
            for (OrderItem item : order) {
                result.append("\t\t<OrderItem quantity=\"").append(item.getQuantity())
                        .append("\" price=\"").append(item.getProduct().getPrice())
                        .append("\">").append(item.getProduct().getCode()).append("</OrderItem>\n");
            }
            result.append("\t</Order>\n");
        }
        result.append("</Sales>");
        return result.toString();
    }
}
