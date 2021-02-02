package lambdaintro.filenames;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class OfficeDocumentReader {

    public List<File> listOfficeDocuments(File path) {
        List<File> result = Arrays.asList(Objects.requireNonNull(path.listFiles(
                pathname -> pathname.isFile() && (
                        pathname.getName().toLowerCase().endsWith("docx") ||
                                pathname.getName().toLowerCase().endsWith("xlsx") ||
                                pathname.getName().toLowerCase().endsWith("pptx")
                )))
        );
        result.sort(Comparator.comparing(File::getName));

        return result;
    }
}
