package week03;

public class PhoneParser {

    public Phone parsePhone(String phoneNumber) {

        int hyphenIndex = phoneNumber.indexOf("-");
        String prefix = phoneNumber.substring(0, hyphenIndex);
        String number = phoneNumber.substring(hyphenIndex + 1);

        return new Phone(prefix, number);
    }
}
