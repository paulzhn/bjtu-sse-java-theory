import javax.xml.crypto.Data;
import java.io.*;

/**
 * The class {@code FileCatalogLoader} implements interface {@code CatalogLoader}.
 * It is used to obtain a product catalog from a file.
 *
 * @author paulzhn
 * @version 1.0
 */

public class FileCatalogLoader implements CatalogLoader {


    private Product readProduct(String line) throws DataFormatException {
        String[] split = line.split("_");
        final int NUMBER_OF_TOKENS = 4;

        if (split.length != NUMBER_OF_TOKENS) {
            throw new DataFormatException(line);
        }

        return new Product(split[1], split[2], Double.parseDouble(split[3]));
    }

    private Coffee readCoffee(String line) throws DataFormatException {
        String[] split = line.split("_");
        final int NUMBER_OF_TOKENS = 10;

        if (split.length != NUMBER_OF_TOKENS) {
            throw new DataFormatException(line);
        }

        return new Coffee(split[1], split[2], Double.parseDouble(split[3]), split[4], split[5], split[6], split[7], split[8], split[9]);
    }

    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException {
        String[] split = line.split("_");
        final int NUMBER_OF_TOKENS = 7;

        if (split.length != NUMBER_OF_TOKENS) {
            throw new DataFormatException(line);
        }

        return new CoffeeBrewer(split[1], split[2], Double.parseDouble(split[3]), split[4], split[5], Integer.parseInt(split[6]));
    }

    @Override
    public Catalog loadCatalog(String fileName) throws FileNotFoundException, IOException, DataFormatException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        Catalog catalog = new Catalog();
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Product")) {
                catalog.addProduct(readProduct(line));
            }
            if (line.startsWith("Coffee")) {
                catalog.addProduct(readCoffee(line));
            }
            if (line.startsWith("Brewer")) {
                catalog.addProduct(readCoffeeBrewer(line));
            }
        }
        reader.close();
        return catalog;
    }
}
