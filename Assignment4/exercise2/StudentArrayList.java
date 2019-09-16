import java.sql.Array;
import java.util.*;

/**
 * This class contains methods to process array lists of {@link Student}
 * objects.
 *
 * @author autor name
 * @version 1.0.0
 * @see Student
 * @see ArrayList
 */
public class StudentArrayList {

    /**
     * Returns an array list with three elements.
     *
     * @param first  a <code>Student</code> object.
     * @param second a <code>Student</code> object.
     * @param third  a <code>Student</code> object.
     * @return an array list with the objects <code>first</code>,
     * <code>second</code>, and <code>third</code>
     */
    public static ArrayList<Student> makeArrayList(
            Student first,
            Student second,
            Student third) {
        ArrayList<Student> a = new ArrayList<>();
        a.add(first);
        a.add(second);
        a.add(third);
        return a;
    }

    /**
     * Returns an array list with the same elements of the specified array
     * arranged in the same order.
     *
     * @param array an array with <code>Student</code> objects .
     * @return an array list with the same elements of the specified array
     * arranged in the same order
     */
    public static ArrayList<Student> makeArrayListFromArray(Student[] array) {

        return new ArrayList<Student>(Arrays.asList(array));
    }

    /**
     * Returns <code>true</code> if the specified array list contains a
     * student whose id matches the specified ID.
     *
     * @param arrayList an array list of <code>Student</code> objects.
     * @param id        a student ID.
     * @return <code>true</code> if the specified array list contains a
     * student whose ID matches the specified ID;
     * <code>false</code> otherwise.
     */
    public static boolean hasStudent(
            ArrayList<Student> arrayList,
            int id) {
        for (Student student : arrayList) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of students in the specified array list whose
     * grade is greater than or equal to the specified grade.
     *
     * @param arrayList an array list of <code>Student</code> objects.
     * @param grade     a grade.
     * @return the number of students in the specified array list whose
     * grade is greater than or equal to the specified grade.
     */
    public static int countGradeGreaterOrEqual(
            ArrayList<Student> arrayList,
            int grade) {
        int count = 0;
        for (Student student : arrayList) {
            if (student.getGrade() >= grade) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the smallest grade of the students in the specified array list.
     * <p>
     * This method assumes that the array list is not empty.
     *
     * @param arrayList an array list of <code>Student</code> objects.
     * @return the smallest grade of the students in the specified array list.
     */
    public static int getMinGrade(ArrayList<Student> arrayList) {
        int min = Integer.MAX_VALUE;
        Iterator<Student> i = arrayList.iterator();
        // Stupid requirement
        while (i.hasNext()) {
            int temp = i.next().getGrade();

            if (temp < min) {
                min = temp;

            }

        }

        return min;
    }

    /**
     * Returns the average grade of the students in the specified array list.
     *
     * @param arrayList an array list of <code>Student</code> objects.
     * @return the average grade of the students in the specified array list.
     */
    public static double getGradeAverage(ArrayList<Student> arrayList) {
        double avg = 0.0;
        for (Student student : arrayList) {
            avg += (double)student.getGrade() / arrayList.size();
        }
        return avg;
    }

    /**
     * Removes all students in the specified array list whose grade
     * is less than the specified grade.
     *
     * @param arrayList an array list of <code>Student</code> objects.
     * @param grade     a grade.
     */
    public static void removeGradeLess(
            ArrayList<Student> arrayList,
            int grade) {
        Iterator<Student> i = arrayList.iterator();
        while (i.hasNext()) {
            if (i.next().getGrade() < grade) {
                i.remove();
            }
        }
    }

    /**
     * Returns the string representation of the objects in the specified
     * array list.
     * <p>
     * A new line character ( \n ) should separate the string
     * representations of the objects. For example:
     * </p>
     * <pre>
     * Student[328,Galileo Galilei,80]\nStudent[123,Albert Einstein,100]
     * </pre>
     * <p>
     * Note that the string does <i>not</i> end with a new line character ( \n )
     * </p>
     *
     * @param arrayList an array list of <code>Student</code> objects.
     * @return the string representation of the objects in the specified
     * array list.
     */
    public static String displayAll(ArrayList<Student> arrayList) {
        Iterator<Student> i = arrayList.iterator();
        StringBuffer ans = new StringBuffer();
        while (i.hasNext()) {
            Student temp = i.next();
            ans.append("Student[").append(temp.getId()).append(",")
                    .append(temp.getName()).append(",")
                    .append(temp.getGrade()).append("]\n");
        }
        ans.delete(ans.length() - 1, ans.length());
        return ans.toString();
    }
}