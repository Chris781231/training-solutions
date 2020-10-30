package classstructureconstructors;

public class BookMain {

    public static void main(String[] args) {

        Book book = new Book("Leslie L. Lawrence", "24 karátos autó");
        book.register("1342-76453798-ISB");

        System.out.println(book.getAuthor() + " - " + book.getTitle() + " [" + book.getRegNumber() + "]");

    }


}
