package exercise2;

public class MyPoint {
    private int x, y;

    public MyPoint() {
        x = 0;
        y = 0;
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getXY() {
        return new int[]{x, y};
    }

    public double distance(int x, int y) {
        return (Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2)));
    }

    public double distance(MyPoint another) {
        return distance(another.x, another.y);
    }

    public double distance() {
        return distance(0, 0);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
