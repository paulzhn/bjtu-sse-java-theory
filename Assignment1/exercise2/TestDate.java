package exercise2;

public class TestDate {
    public static void main(String[] args) {
        Date d = new Date(2000, 12, 31);
        d.addOneDay();
        System.out.println(d);
    }
}
