package interfacedefaultmethods;

public interface Printable {

    String BLACK = "#000000";

    int getLength();

    String getPage(int pageNumber);

    default String getColor(int pageNumber) {
        return BLACK;
    }
}
