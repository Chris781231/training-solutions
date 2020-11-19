package stringbuilder;

public enum Title {
    MR("Mr."),
    MS("Ms."),
    DR("Dr."),
    PROF("Prof.");

    private final String titleName;

    Title(String title) {
        this.titleName = title;
    }

    public String getTitle() {
        return titleName;
    }
}
