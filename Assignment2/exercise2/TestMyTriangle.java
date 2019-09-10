package exercise2;

import exercise1.MyPoint;

public class TestMyTriangle {
    public static void main(String[] args) {
        MyTriangle a = new MyTriangle(0, 0, 1, 1, 0, 1);
        MyTriangle b = new MyTriangle(new MyPoint(0, 0), new MyPoint(2, 2), new MyPoint(0, 2));

    }
}
