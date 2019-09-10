package exercise1;

public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint a = new MyPoint();
        MyPoint b = new MyPoint(1, 2);
        a.setXY(2, 2);
        System.out.println(a);
        System.out.println(b.getXY()[0] + " " + b.getXY()[1]);
        System.out.println(a.distance());
        System.out.println(a.distance(b));
        System.out.println(a.distance(1, 2));
    }
}
