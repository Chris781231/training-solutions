package stringbuilder;

public class NameBuilder {

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {

        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        StringBuilder sb = new StringBuilder();

        if (title != null) {
            sb.append(title.getTitle()).append(" ");
        }

        sb.append(givenName).append(" ");

        if (!isEmpty(middleName)) {
            sb.append(middleName).append(" ");
        }

        sb.append(familyName);

        return sb.toString();
    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {

        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        StringBuilder sb = new StringBuilder();

        if (title != null) {
            sb.append(title.getTitle()).append(" ");
        }

        sb.append(familyName).append(" ");

        if (!isEmpty(middleName)) {
            sb.append(middleName).append(" ");
        }

        sb.append(givenName);

        return sb.toString();
    }

    public String insertTitle(String name, Title title, String where) {

        return new StringBuilder(name).insert(name.indexOf(where), " " + title.getTitle()).toString();
    }

    public String deleteNamePart(String name, String delete) {

        int fromIndex = name.indexOf(delete);
        int toIndex = name.indexOf(delete) + delete.length();
        return new StringBuilder(name).delete(fromIndex, toIndex).toString();
    }

    private boolean isEmpty(String s) {
        return s == null || s.isBlank();
    }
}
