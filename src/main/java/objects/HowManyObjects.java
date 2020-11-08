package objects;

public class HowManyObjects {

    public static void main(String[] args) {

        Book book1 = new Book();
        System.out.println("book1 was created. 1 object was created.");
        Book book2 = new Book();
        System.out.println("book2 was created. 2 objects were created.");
        Book book3 = new Book();
        System.out.println("book3 was created. 3 objects were created.");
        Book book4 = book1;
        System.out.println("book4 point to the same as book1. 3 objects were created.");
        Book book5 = book1;
        System.out.println("book5 point to the same as book1. 3 objects were created.");
        Book book6 = book3;
        System.out.println("book6 point to the same as book3. 3 objects were created.");
        Book book7 = null;
        System.out.println("book7 is null, so no new object was created. 3 objects were created.");
        book4 = book5;
        System.out.println("book4 point to the same as book5, so no new object was created. 3 objects were created.");
        book5 = new Book();
        System.out.println("book5 was created. 4 objects were created.");
        book6 = null;
        System.out.println("book6 is null, so no new object was created. 4 objects were created.");


    }
}
