package stringtype.registration;

public class UserValidator {

    public boolean isValidUsername(String username) {
        return !username.equals("");
    }

    public boolean isValidPassword(String password1, String password2) {
        return (password1.length() >= 8) && (password1.equals(password2));
    }

    public boolean isValidEmail(String email) {
        int indexOfAt = email.indexOf('@');
        int indexOfDot = email.indexOf('.');
        boolean validAt = indexOfAt > 0;
        boolean validDot = (indexOfDot > (indexOfAt + 1)) && (indexOfDot < email.length() - 1);
        return validAt && validDot;
    }
}
