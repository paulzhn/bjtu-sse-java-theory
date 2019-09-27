package exercise3;


public class MyTriangle {
    private MyPoint[] vPoints;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        vPoints = new MyPoint[3];
        for (int i = 0; i < 3; i++) {
            vPoints[i] = new MyPoint();
        }
        vPoints[0].setXY(x1, y1);
        vPoints[1].setXY(x2, y2);
        vPoints[2].setXY(x3, y3);
    }

    public MyTriangle(MyPoint[] vPoints) {
        this.vPoints = vPoints;
    }

    @Override
    public String toString() {
        return "MyTriangle[v1=" + vPoints[0].toString() + ", v2=" + vPoints[1].toString() + ", v3=" + vPoints[2].toString() + ")]";
    }

    public double getPerimeter() {
        return vPoints[0].distance(vPoints[1]) + vPoints[1].distance(vPoints[2]) + vPoints[2].distance(vPoints[0]);
    }

    public void printType() {
        if (vPoints[0].distance(vPoints[1]) == vPoints[1].distance(vPoints[2]) && vPoints[0].distance(vPoints[1]) == vPoints[2].distance(vPoints[0])) {
            System.out.println("equilateral");
        } else if (vPoints[0].distance(vPoints[1]) != vPoints[1].distance(vPoints[2]) && vPoints[0].distance(vPoints[1]) != vPoints[2].distance(vPoints[0]) && vPoints[0].distance(vPoints[2]) != vPoints[1].distance(vPoints[2])) {
            System.out.println("scalene");
        } else {
            System.out.println("isosceles");
        }
    }


}
