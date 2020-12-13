package catalog;

public class SearchCriteria {

    private final String title;
    private final String contributor;

    private SearchCriteria(String title, String contributor) {
        if (title == null) {
            throw new IllegalArgumentException("title is null");
        }
        if (contributor == null) {
            throw new IllegalArgumentException("contributor is null");
        }
        this.title = title;
        this.contributor = contributor;
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        return new SearchCriteria(title, contributor);
    }

    public static SearchCriteria createByContributor(String contributor) {
        return new SearchCriteria("", contributor);
    }

    public static SearchCriteria createByTitle(String title) {
        return new SearchCriteria(title, "");
    }

    public boolean hasContributor() {
        return !contributor.equals("");
    }

    public boolean hasTitle() {
        return !title.equals("");
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }
}
