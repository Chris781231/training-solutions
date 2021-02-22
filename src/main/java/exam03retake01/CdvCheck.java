package exam03retake01;

public class CdvCheck {

    public boolean check(String cdv) {
        if (cdv.length() != 10) {
            throw new IllegalArgumentException("Invalid cdv number length");
        }
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            try {
                sum += Integer.parseInt(cdv.substring(i, i + 1)) * (i + 1);
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("cdv must not be contains letter");
            }
        }

        return sum % 11 == Integer.parseInt(cdv.substring(9));
    }
}
