import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

/**
 * This class displays the catalog of the gourmet coffee system.
 *
 * @author author name
 * @version 1.1.0
 * @see Product
 * @see Coffee
 * @see CoffeeBrewer
 * @see Catalog
 * @see CatalogLoader
 * @see FileCatalogLoader
 * @see DataFormatException
 * @see DataField
 */
public class CatalogGUI extends JPanel {

    /** Standard error stream */
    static private PrintWriter stdErr = new PrintWriter(System.err, true);

    /** Window width in pixels */
    static private int WIDTH = 420;

    /** Window height in pixels */
    static private int HEIGHT = 340;

    /** Size of the list cell in pixels */
    static private int CELL_SIZE = 50;

    /** Visible rows in list */
    static private int LIST_ROWS = 10;

    /** Rows in status text area */
    static private int STATUS_ROWS = 5;

    /** Rows in status text area */
    static private int STATUS_COLS = 40;

    private JList catalogList;
    private JPanel productPanel;
    private JTextArea statusTextArea;

    private Catalog catalog;

    /**
     * Loads a product catalog and starts the application.
     *
     * @param args String arguments.  Not used.
     * @throws IOException if there are errors in the loading
     *                     the catalog.
     */
    public static void main(String[] args) throws IOException {

        String filename = "";

        if (args.length != 1) {
            filename = "catalog.dat";
        } else {
            filename = args[0];
        }
        try {
            Catalog catalog =
                    (new FileCatalogLoader()).loadCatalog(filename);

            JFrame frame = new JFrame("Catalog Gourmet Coffee");

            frame.setContentPane(new CatalogGUI(catalog));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);
            frame.setResizable(true);
            frame.setVisible(true);

        } catch (FileNotFoundException fnfe) {
            stdErr.println("The file does not exist");

            System.exit(1);

        } catch (DataFormatException dfe) {
            stdErr.println("The file contains malformed data: "
                    + dfe.getMessage());

            System.exit(1);
        }
    }

    /**
     * Instantiates the components and arranges them in a window.
     *
     * @param initialCatalog a product catalog.
     */
    public CatalogGUI(Catalog initialCatalog) {

        catalog = initialCatalog;

        // create the components
        catalogList = new JList(catalog.getCodes());
        catalogList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        catalogList.setVisibleRowCount(LIST_ROWS);
        catalogList.setFixedCellWidth(CELL_SIZE);
        statusTextArea = new JTextArea(STATUS_ROWS, STATUS_COLS);
        statusTextArea.setEditable(false);

        // create product information panel
        productPanel = new JPanel();
        // set layout to gridlayout, to make things easier
        productPanel.setLayout(new GridLayout(0, 1));
        productPanel.setBorder(
                BorderFactory.createTitledBorder("Product Information"));

        // create panel to hold list and Display button
        JPanel catalogPanel = new JPanel();
        catalogPanel.setBorder(BorderFactory.createTitledBorder("Catalog"));
        catalogPanel.add(
                new JScrollPane(catalogList,
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

        setLayout(new BorderLayout());
        add(catalogPanel, BorderLayout.WEST);
        add(productPanel, BorderLayout.CENTER);
        add(statusTextArea, BorderLayout.SOUTH);

        // start listening for list events
        catalogList.addListSelectionListener(new CatalogListListener());
    }

    /**
     * Obtains a {@link JPanel} object with the information of a product.
     *
     * @param dataFields  an {@link ArrayList} of {@link DataField}
     *                    with the product information.
     * @return  a {@link JPanel} with the product information.
     */
    private JPanel getDataFieldsPanel(ArrayList<DataField> dataFields) {
        ArrayList<JTextField> textFields = new ArrayList<>();
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 0;
        panel.add(new JLabel(), c);
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JLabel("Code: ", SwingConstants.LEFT), c);
        JTextField code = new JTextField();
        c.weightx = 1;
        c.gridwidth = 0;
        panel.add(code, c);
        textFields.add(code);
        panel.add(new JLabel("Description: ", SwingConstants.LEFT));
        JTextField description = new JTextField();
        panel.add(description, c);
        textFields.add(description);
        c.weightx = 0;
        c.gridwidth = 1;
        panel.add(new JLabel("Price: ", SwingConstants.LEFT), c);
        JTextField price = new JTextField();
        c.weightx = 1;
        c.gridwidth = 0;
        panel.add(price, c);
        textFields.add(price);
        c.weightx = 0;
        c.gridwidth = 1;
        panel.add(new JLabel("Origin: ", SwingConstants.LEFT), c);
        JTextField origin = new JTextField();
        c.weightx = 1;
        c.gridwidth = 0;
        panel.add(origin, c);
        textFields.add(origin);
        c.weightx = 0;
        c.gridwidth = 1;
        panel.add(new JLabel("Roast: ", SwingConstants.LEFT), c);
        JTextField roast = new JTextField();
        c.weightx = 1;
        c.gridwidth = 0;
        panel.add(roast, c);
        textFields.add(roast);
        c.weightx = 0;
        c.gridwidth = 1;
        panel.add(new JLabel("Flavor: ", SwingConstants.LEFT), c);
        JTextField flavor = new JTextField();
        c.weightx = 1;
        c.gridwidth = 0;
        panel.add(flavor, c);
        textFields.add(flavor);
        c.weightx = 0;
        c.gridwidth = 1;
        panel.add(new JLabel("Aroma: ", SwingConstants.LEFT), c);
        JTextField aroma = new JTextField();
        c.weightx = 1;
        c.gridwidth = 0;
        panel.add(aroma, c);
        textFields.add(aroma);
        c.weightx = 0;
        c.gridwidth = 1;
        panel.add(new JLabel("Acidity: ", SwingConstants.LEFT), c);
        JTextField acidity = new JTextField();
        c.weightx = 1;
        c.gridwidth = 0;
        panel.add(acidity, c);
        textFields.add(acidity);
        c.weightx = 0;
        c.gridwidth = 1;
        panel.add(new JLabel("Body: ", SwingConstants.LEFT), c);
        JTextField body = new JTextField();
        c.weightx = 1;
        c.gridwidth = 0;
        panel.add(body, c);
        textFields.add(body);
        for (int i = 0; i < dataFields.size(); i++) {
            textFields.get(i).setText(dataFields.get(i).getValue());
        }
        // todo: need to modify

        return panel;
    }

    /**
     * This inner class handles list-selection events.
     */
    class CatalogListListener implements ListSelectionListener {

        /**
         * Displays the information of the selected product.
         *
         * @param event the event object.
         */
        @Override
        public void valueChanged(ListSelectionEvent event) {

            String code = (String)catalogList.getSelectedValue();
            Product product = catalog.getProduct(code);

            productPanel.removeAll();
            productPanel.setVisible(false);                   // Use this
            productPanel.add(                                 // to update
                    getDataFieldsPanel(product.getDataFields())); // the panel
            productPanel.setVisible(true);                    // correctly

            statusTextArea.setText("Product " + code + " has been displayed");
        }
    }
}