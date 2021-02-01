package week13.d04.midlevel;

public class Template {

    private final String emptyTemplate;
    private final int indexOfNameStart;
    private final int indexOfYearOfBirthStart;

    public Template(String emptyTemplate, int indexOfNameStart, int indexOfYearOfBirthStart) {
        this.emptyTemplate = emptyTemplate;
        this.indexOfNameStart = indexOfNameStart;
        this.indexOfYearOfBirthStart = indexOfYearOfBirthStart;
    }

    public String getEmptyTemplate() {
        return emptyTemplate;
    }

    public int getIndexOfNameStart() {
        return indexOfNameStart;
    }

    public int getIndexOfYearOfBirthStart() {
        return indexOfYearOfBirthStart;
    }
}
