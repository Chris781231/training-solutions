package introexception.patient;

public class SsnValidator {

    public boolean isValidSsn(String ssn) {

        if (ssn.length() != 9) {
            return false;
        }

        int sum = 0;
        try {
            for (int i = 0; i < 9; i += 2) {
                if (!Character.isDigit(ssn.charAt(i))) {
                    throw new IllegalArgumentException();
                } else {
                    if (i % 2 != 0) {
                        sum += (ssn.charAt(i) - '0') * 3;
                    } else {
                        sum += (ssn.charAt(i) - '0') * 7;
                    }
                }
            }
            return (sum % 10 == ssn.charAt(8) - '0');
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid Social Security Number: " + ssn);
            return false;
        }
    }
}
