import java.util.*;
import java.io.*;

/**
 * This class provides two file I/O methods for handling employee data.
 *
 * @author author name
 * @version 1.0.0
 * @see Employee
 */
public class EmployeeFileIO {

    /**
     * Creates an <code>ArrayList</code> of <code>Employee</code> objects
     * from a file that contains employee data.
     * <p>
     * Every line in the specified file should contain three fields: ID, name,
     * and salary of an employee in the following format: ID_name_salary
     * </p>
     *
     * @param filename the name of a file containing employee data.
     * @return an <code>ArrayList</code> of <code>Employee</code> objects.
     * @throws FileNotFoundException  if the specified file does not exist.
     * @throws IOException            if an I/O error occurs.
     * @throws NoSuchElementException if the data in the file is incomplete.
     * @throws NumberFormatException  if the file contains invalid numbers.
     */
    public static ArrayList<Employee> read(String filename)
            throws FileNotFoundException,
            IOException,
            NoSuchElementException,
            NumberFormatException {
        ArrayList<Employee> arrayList = new ArrayList<>();
        File f = new File(filename);
        String str;
        BufferedReader reader = new BufferedReader(new FileReader(f));
        while ((str = reader.readLine()) != null) {
            /*
                StringTokenizer has been deprecated, and the doc of oracle recommend using the split() of String instead.
                The class is reserved for the compatibility of old code.

                If use StringTokenizer, the code should be:
                StringTokenizer st = new StringTokenizer(str, "_");
                arrayList.add(new Employee(Integer.parseInt(st.nextToken()), st.nextToken(), Double.parseDouble(st.nextToken())));
             */

            String[] temp = str.split("_");
            arrayList.add(new Employee(Integer.parseInt(temp[0]), temp[1], Double.parseDouble(temp[2])));
        }

        reader.close();
        return arrayList;
    }

    /**
     * Creates a file of employee data from an <code>ArrayList</code> of
     * <code>Employee</code> objects.
     * <p>
     * Every line in the file should contain the ID, name, and salary of an
     * employee separated by an underscore: ID_name_salary
     * </p>
     *
     * @param filename  the name of the file that will store the employee data.
     * @param arrayList an <code>ArrayList</code> of <code>Employee</code>
     *                  objects.
     * @throws IOException if an I/O error occurs.
     */
    public static void write(String filename, ArrayList<Employee> arrayList)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Employee employee : arrayList) {
            writer.write(Integer.toString(employee.getId()));
            writer.write("_");
            writer.write(employee.getName());
            writer.write("_");
            writer.write(Double.toString(employee.getSalary()));
            writer.newLine();
        }
        writer.close();


    }
}