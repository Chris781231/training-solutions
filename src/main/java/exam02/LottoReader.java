package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {

    int[] hits = new int[90];

    public LottoReader(InputStream is) {


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                for (int i = 11; i <= 15; i++) {
                    hits[Integer.parseInt(parts[i]) - 1]++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumber(int number) {
        return hits[number - 1];
    }
}
