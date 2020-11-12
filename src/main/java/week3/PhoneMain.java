package week3;

public class PhoneMain {

    public static void main(String[] args) {

        PhoneParser ph = new PhoneParser();
        Phone phone = ph.parsePhone("30-1234567");

        System.out.println(phone.getPrefix());
        System.out.println(phone.getNumber());
    }
}
