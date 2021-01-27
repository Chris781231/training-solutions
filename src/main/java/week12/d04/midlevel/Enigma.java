package week12.d04.midlevel;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Enigma {

    public static void main(String[] args) {
        Enigma enigma = new Enigma();
        enigma.decodeFile(Enigma.class.getResourceAsStream("/secret.dat"));
    }

    void decodeFile(InputStream in) {
        if (in == null) {
            throw new IllegalArgumentException("InputStream is null");
        }
        try (BufferedInputStream bis = new BufferedInputStream(in)) {
            byte temp;
            while((temp = (byte) bis.read()) > -1) {
                System.out.print((char) (temp + 10));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("cannot read file!", ioe);
        }
    }
}
