package defaultconstructor.simpledate;

public class SimpleDate {

    private int year;
    private int month;
    private int day;



    public void setDate(int year, int month, int day) {
        boolean successYear = setYear(year);
        boolean successMonth = setMonth(month);
        boolean successDay = setDay(day);
        if (!successYear || !successMonth || !successDay) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }
    }



    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }



    private boolean setYear(int year) {
        if (year < 1900) {
            return false;
        }
        this.year = year;
        return true;
    }

    private boolean setMonth(int month) {
        if (month < 1 || month > 12) {
            return false;
        }
        this.month = month;
        return true;
    }

    private boolean setDay(int day) {
        boolean success;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                success = setDayOfThirtyOneDayMonth(day);
            }
            case 4, 6, 9, 11 -> {
                success = setDayOfThirtyDayMonth(day);
            }
            case 2 -> {
                success = setDayOfFebruary(day);
            }
            default -> {
                success = false;
            }
        }
        return success;
    }



    private boolean setDayOfThirtyOneDayMonth(int day) {
        if (day < 1 || day > 31) {
            return false;
        }
        this.day = day;
        return true;
    }

    private boolean setDayOfThirtyDayMonth(int day) {
        if (day < 1 || day > 30) {
            return false;
        }
        this.day = day;
        return true;
    }

    private boolean setDayOfFebruary(int day) {
        boolean isLeapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);

        if ((isLeapYear && (day < 1 || day > 29)) || (!isLeapYear && (day < 1 || day > 28))) {
            return false;
        }

        this.day = day;
        return true;
    }
}
