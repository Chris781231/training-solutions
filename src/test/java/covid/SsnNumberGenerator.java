package covid;

import java.util.Random;

public class SsnNumberGenerator {

    public String createSsnNumberByRandom() {
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            int odd = rnd.nextInt(10);
            int even = rnd.nextInt(10);
            sum += odd * 3 + even * 7;
            sb.append(odd).append(even);
        }
        int remainder = sum % 10;
        sb.append(remainder);

        return sb.toString();
    }
}
