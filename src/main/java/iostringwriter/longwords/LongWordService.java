package iostringwriter.longwords;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    public void writeTo(Writer writer, List<String> words) {
        try {
            for (String word : words) {
                writer.write(word);
                writer.write(" (");
                writer.write(String.valueOf(word.length()));
                writer.write(" characters)\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file");
        }
    }

    public String writeWithStringWriter(List<String> testWords) {
        StringWriter stringWriter = new StringWriter();
        try (stringWriter) {
            writeTo(stringWriter, testWords);
        } catch (IOException e) {
            throw new IllegalStateException("Can't write");
        }
        return stringWriter.toString();
    }
}
