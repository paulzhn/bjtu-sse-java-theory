package exercise3;


public class TestMyTriangle {
    public static void main(String[] args) {
        MyTriangle a = new MyTriangle(0, 0, 1, 1, 0, 1);
        MyPoint[] b = new MyPoint[] {new MyPoint(0, 0), new MyPoint(1, 1), new MyPoint(0, 1)};

        MyTriangle c = new MyTriangle(b);

        System.out.println(a.getPerimeter());
        a.printType();
        System.out.println(a + "\n");

        System.out.println(c.getPerimeter());
        c.printType();
        System.out.println(c);
    }
}
