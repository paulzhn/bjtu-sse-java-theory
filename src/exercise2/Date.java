package exercise2;

public class Date {
    private int year, month, day;
    public Date(int year, int month, int day) {
        setData(year, month, day);
    }

    public void setData(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
