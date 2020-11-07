package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private List<String> titles = new ArrayList<>();

    public void add(String book) {
        titles.add(book);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> hits = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            if (titles.get(i).startsWith(prefix)) {
                hits.add(titles.get(i));
            }
        }
        return hits;
    }
    
    public List<String> getTitles() {
        return titles;
    }


    public static void main(String[] args) {
        Book books = new Book();

        books.add("Harry Potter és a bölcsek köve");
        books.add("Harry Potter és a titkok kamrája");
        books.add("Gyűrűk ura - A jég dala");

        System.out.println(books.findAllByPrefix("Harry"));

        System.out.println(books.getTitles());
    }
}
