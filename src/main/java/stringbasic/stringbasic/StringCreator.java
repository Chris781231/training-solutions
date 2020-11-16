package stringbasic.stringbasic;

public class StringCreator {


    public String createStringForPool() {
        return "Charlie Parker";
    }

    public String createStringForHeap() {
        return new String("Charlie Parker");
    }
}
