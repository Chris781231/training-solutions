package controlselection.greetings;

public class Greetings {

    public String greet(int hour, int minute) {
        if((hour == 5 && minute > 0) || (hour > 5 && hour < 9) || (hour == 9 && minute == 0)) {
            return "jó reggelt";
        } else if((hour == 9 && minute > 0) || (hour > 9 && hour < 18) || (hour == 18 && minute <= 30)) {
            return "jó napot";
        } else if((hour == 18 && minute > 30) || (hour > 18 && hour < 20) || (hour == 20 && minute == 0)) {
            return "jó estét";
        }
        return "jó éjt";
    }
}
