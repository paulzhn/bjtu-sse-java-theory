package exercise2;

public class Date {
    private int year, month, day;
    private int[] monthDay = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int year, int month, int day) {
        setData(year, month, day);
    }

    public void setData(int year, int month, int day) {
        if (!validateDate(year, month, day)) {
            System.out.println("Wrong date. Try again.");
            return;
        }
        if (validateLeapYear(year)) {
            monthDay[1] = 29;
        } else {
            monthDay[1] = 28;
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void addOneDay() {

        if (day + 1 <= monthDay[month - 1]) {
            day++;
        } else if (day == 31 && month == 12) {
            year++;
            month = 1;
            day = 1;
        } else if (day == monthDay[month - 1]) {
            month++;
            day = 1;
        }

    }

    private boolean validateDate(int year, int month, int day) {

        // validate February
        if (month == 2) {
            if (validateLeapYear(year) && day > 29 || !validateLeapYear(year) && day > 28) {
                return false;
            } else {
                return true;
            }

        } else if (day < 0 || day > monthDay[month - 1]) {
            return false;
        }


        return true;
    }

    private boolean validateLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return year + " " + month + " " + day;
    }
}
