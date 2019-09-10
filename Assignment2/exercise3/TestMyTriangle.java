package exercise3;

import exercise1.MyPoint;
import exercise3.MyTriangle;

public class TestMyTriangle {
    public static void main(String[] args) {
        MyTriangle a = new MyTriangle(0, 0, 1, 1, 0, 1);
        MyPoint[] b = new MyPoint[] {new MyPoint(0, 0), new MyPoint(1, 1), new MyPoint(0, 1)};

        MyTriangle c = new MyTriangle(b);

        System.out.println(c.getPerimeter());
        c.printType();
        System.out.println(c);
    }
}
