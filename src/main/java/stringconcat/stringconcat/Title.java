package stringconcat.stringconcat;

public enum Title {

    MR("Mr."),
    MS("Ms."),
    DR("Dr.");

    private String title;

    Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
