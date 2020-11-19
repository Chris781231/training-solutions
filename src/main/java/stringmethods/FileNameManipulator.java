package stringmethods;

public class FileNameManipulator {

    String emptyString = "Empty string!";
    String invalidArgument = "Invalid argument!";

    public char findLastCharacter(String str) {

        if (isEmpty(str)) {
            throw new IllegalArgumentException(emptyString);
        }

        String stripedStr = str.stripTrailing();
        return stripedStr.charAt(stripedStr.length() - 1);
    }

    public String findFileExtension(String fileName) {

        int lastIndexOfDot;

        if (isEmpty(fileName) || (lastIndexOfDot = fileName.lastIndexOf(".")) <= 0) {
            throw new IllegalArgumentException("Invalid file name!");
        }

        return fileName.substring(lastIndexOfDot);
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {

        if (isEmpty(ext) || isEmpty(fileName) || fileName.lastIndexOf(".") <= 0) {
            throw new IllegalArgumentException(invalidArgument);
        }

        String extByFilename = findFileExtension(fileName).substring(1);

        return ext.equals(extByFilename);
    }

    public String changeExtensionToLowerCase(String fileName) {

        if (isEmpty(fileName)) {
            throw new IllegalArgumentException(emptyString);
        }

        int lastIndexOfDot;
        if ((lastIndexOfDot = fileName.lastIndexOf(".")) <= 0) {
            throw new IllegalArgumentException(invalidArgument);
        }

        String fileNameWOExt = fileName.substring(0, lastIndexOfDot);
        String extToLowerCase = findFileExtension(fileName).toLowerCase();

        return fileNameWOExt + extToLowerCase;
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {

        if (isEmpty(searchedFileName) || isEmpty(actualFileName)) {
            throw new IllegalArgumentException(invalidArgument);
        }

        searchedFileName = changeExtensionToLowerCase(searchedFileName);
        actualFileName = changeExtensionToLowerCase(actualFileName);

        return searchedFileName.equals(actualFileName);
    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException(emptyString);
        }

        return fileName.replace(present, target);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
