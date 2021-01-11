package week10.d01.midlevel;

import java.util.List;

public class Hiking {

    public double getPlusElevation(List<Double> elevations) {
        double plusElevation = 0;
        double prevElevation = 0;

        for (double elevation : elevations) {
            if (prevElevation != 0 && prevElevation < elevation) {
                plusElevation += elevation - prevElevation;
            }
            prevElevation = elevation;
        }

        return plusElevation;
    }
}
