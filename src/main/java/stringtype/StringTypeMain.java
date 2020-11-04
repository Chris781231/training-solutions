package stringtype;

public class StringTypeMain {

    public static void main(String[] args) {
        
        String prefix = "Hello ";
        String name = "John Doe";

        // message = prefix + name
        String message = prefix.concat(name);
        System.out.println(message);

        message += + 444;
        System.out.println(message);

        boolean b = message.equals("Hello John Doe");
        System.out.println(b);

        boolean c = message.equals("Hello John Doe444");
        System.out.println(c);

        String emptyStr = "";
        System.out.println(emptyStr.length());
        System.out.println((emptyStr + emptyStr).length());

        System.out.println("Abcde".length());
        System.out.println("Abcde".charAt(0) + ", " + "Abcde".charAt(2));
        System.out.println("Abcde".substring(0,3));
    }
}
