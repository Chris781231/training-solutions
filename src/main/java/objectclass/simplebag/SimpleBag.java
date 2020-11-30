package objectclass.simplebag;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {

    List<Object> items = new ArrayList<>();
    int cursor = 0;

    public void putItem(Object item) {
        items.add(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public void beforeFirst() {
        cursor = -1;
    }

    public boolean hasNext() {
        return cursor + 1 < size();
    }

    public Object next() {
        return items.get(++cursor);
    }

    public boolean contains(Object item) {
        for (Object object : items) {
            if (object.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int getCursor() {
        return cursor;
    }
}
