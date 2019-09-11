public class HTMLSalesFormatter implements SalesFormatter {
    private static final HTMLSalesFormatter singletonInstance = new HTMLSalesFormatter();

    private HTMLSalesFormatter() {
    }

    public static HTMLSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }

    @Override
    public String formatSales(Sales sales) {
        StringBuilder result = new StringBuilder("");
        result.append("<html>\n\t<body>\n\t\t<center><h2>Orders</h2></center>\n");
        for (Order order : sales) {
            result.append("\t\t<hr>\n\t\t<h4>Total = ").append(order.getTotalCost()).append("</h4>\n");
            for (OrderItem item : order) {
                result.append("\t\t<p>\n");
                result.append("\t\t\t<b>code: </b>").append(item.getProduct().getCode()).append("<br>\n");
                result.append("\t\t\t<b>quantity: </b>").append(item.getQuantity()).append("<br>\n");
                result.append("\t\t\t<b>price: </b>").append(item.getProduct().getPrice()).append("\n");
                result.append("\t\t</p>\n");
            }
        }
        result.append("\t</body>\n</html>");
        return result.toString();
    }
}
