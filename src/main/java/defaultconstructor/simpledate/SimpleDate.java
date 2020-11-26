package defaultconstructor.simpledate;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if (!isCorrect(year, month, day)) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }
        this.year = year;
        this.month = month;
        this.day = day;
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



    private boolean isCorrect(int year, int month, int day) {
        boolean isCorrect = true;

        if (year < 1900) {
            isCorrect = false;
        }

        if (month < 1 || month > 12) {
            isCorrect = false;
        }

        if (day < 1 || day > calculateMonthLength(year, month)) {
            isCorrect = false;
        }

        return isCorrect;
    }

    private int calculateMonthLength(int year, int month) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return 31;
            }
            case 4, 6, 9, 11 -> {
                return 30;
            }
            default -> {
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    return 29;
                }
                return 28;
            }
        }
    }
}
