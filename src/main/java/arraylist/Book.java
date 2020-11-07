package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private List<String> titles = new ArrayList<>();

    public void add(String book) {
        titles.add(book);
    }

    public List<String> removeByPrefix(String prefix) {
        List<String> removed = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            if(titles.get(i).startsWith(prefix)) {
                removed.add(titles.remove(i));
            }
        }
        return removed;
    }

    public boolean removeAllByPrefix(String prefix) {
        List<String> toBeRemoved = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            if (titles.get(i).startsWith(prefix)) {
                toBeRemoved.add(titles.get(i));
            }
        }
        boolean success = titles.removeAll(toBeRemoved);
        return success;
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

        System.out.println(books.removeByPrefix("Gyű"));
        System.out.println(books.getTitles());

        System.out.println(books.removeAllByPrefix("Harry"));
        System.out.println(books.getTitles());
    }
}
