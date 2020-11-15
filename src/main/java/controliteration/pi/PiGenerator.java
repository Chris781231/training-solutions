package controliteration.pi;

public class PiGenerator {


    public String getPi() {
        int counter = 0;
        String poem = "Nem a régi s durva közelítés, " +
                "mi szótól szóig így kijön " +
                "betűiket számlálva. " +
                "Ludolph eredménye már, " +
                "ha itt végezzük húsz jegyen. " +
                "De rendre kijő még tíz pontosan, " +
                "Azt is bízvást ígérhetem.";
        String pi = "";

        for (int i = 0; i < poem.length(); i++) {
            if (Character.isAlphabetic(poem.charAt(i))) {
                counter++;
            } else if (counter != 0) {
                pi += counter;
                counter = 0;

                if (pi.length() == 1) {
                    pi += '.';
                }
            }
        }

        return pi;
    }
}
