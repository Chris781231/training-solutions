package interfacedefaultmethods;

public class Printer {

    public String print(Printable printable) {

        StringBuilder printedPages = new StringBuilder(printable.getLength());

        for (int i = 0; i < printable.getLength(); i++) {
            if (!printable.getColor(i).equals(Printable.BLACK)) {
                printedPages.append("[").append(printable.getColor(i)).append("]");
            }
            printedPages.append(printable.getPage(i)).append("\n");
        }

        return printedPages.toString();
    }
}
