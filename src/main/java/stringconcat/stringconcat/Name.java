package stringconcat.stringconcat;

public class Name {

    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    public Name(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        } else {
            this.familyName = familyName;
            this.middleName = middleName;
            this.givenName = givenName;
            this.title = title;
        }
    }

    public Name(String familyName, String middleName, String givenName) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        } else {
            this.familyName = familyName;
            this.middleName = middleName;
            this.givenName = givenName;
        }
    }

    public String concatNameWesternStyle() {
        return (!(title == null) ? title.getTitle() + " " : "") + givenName + " " + (!isEmpty(middleName) ? middleName + " " : "") + familyName;
    }

    public String concatNameHungarianStyle() {
        return (!(title == null) ? title.getTitle().concat(" ") : "")
                .concat(familyName).concat(" ")
                .concat(!isEmpty(middleName) ? middleName.concat(" ") : "")
                .concat(givenName);
    }

    private boolean isEmpty(String string) {
        return (string == null || string.equals(""));
    }
}
