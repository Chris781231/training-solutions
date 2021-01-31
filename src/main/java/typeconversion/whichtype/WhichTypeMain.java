package typeconversion.whichtype;

public class WhichTypeMain {

    public static void main(String[] args) {

        System.out.println(new WhichType().whichType("-2147483649"));
        System.out.println(new WhichType().whichType("-2147483648"));
        System.out.println(new WhichType().whichType("-32769"));
        System.out.println(new WhichType().whichType("-32768"));
        System.out.println(new WhichType().whichType("-129"));
        System.out.println(new WhichType().whichType("-128"));
        System.out.println(new WhichType().whichType("127"));
        System.out.println(new WhichType().whichType("128"));
        System.out.println(new WhichType().whichType("32767"));
        System.out.println(new WhichType().whichType("32768"));
        System.out.println(new WhichType().whichType("2147483647"));
        System.out.println(new WhichType().whichType("2147483648"));
    }
}
