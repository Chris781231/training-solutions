package covid.service;

public class Validation {

    public static boolean isValidName(String name) {
        return !isEmpty(name);
    }

    public static boolean isValidZip(String postCode) {
        return !isEmpty(postCode);
    }

    public static boolean isValidAge(int age) {
        return age > 10 && age < 150;
    }

    public static boolean isValidEmail(String email) {
        return !isEmpty(email) && email.length() >= 3 && email.contains("@");
    }

    public static boolean equalEmails(String email, String emailAgain) {
        return email.equals(emailAgain);
    }

    public static boolean isValidSsnNumber(String ssn) {
        if (isEmpty(ssn) || ssn.length() != 9) {
            return false;
        }
        try {
            Integer.parseInt(ssn);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return cdnValidation(ssn);
    }

    public static boolean isValidDateFormat(String dateString) {
        if (isEmpty(dateString) || dateString.length() != 10 || dateString.charAt(4) != '-' || dateString.charAt(7) != '-') {
            return false;
        }
        for (String temp : dateString.split("-")) {
            try {
                Integer.parseInt(temp);
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidVaccina(String vaccina) {
        return !isEmpty(vaccina) && (
                vaccina.equals("Pfizer") ||
                        vaccina.equals("Moderna") ||
                        vaccina.equals("Szputnyik-V") ||
                        vaccina.equals("Sinopharm") ||
                        vaccina.equals("AstraZeneca")
        );
    }

    public static boolean isValidNote(String note) {
        return !isEmpty(note);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    private static boolean cdnValidation(String ssn) {
        int sum = 0;
        for (int i = 0; i < ssn.length() - 1; i++) {
            int temp = Integer.parseInt(ssn.substring(i, i + 1));
            if ((i + 1) % 2 == 1) {
                sum += temp * 3;
            } else {
                sum += temp * 7;
            }
        }
        return sum % 10 == Integer.parseInt(ssn.substring(8));
    }
}
