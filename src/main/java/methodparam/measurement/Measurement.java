package methodparam.measurement;

public class Measurement {

    double[] results;

    public Measurement(double[] results) {
        this.results = results;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        int firstIndex = -1;
        int i = 0;

        while (firstIndex < 0 && i < results.length) {
            if (results[i] > lower && results[i] < upper) {
                firstIndex = i;
            }
            i++;
        }

        return firstIndex;
    }

    public double minimum() {
        double min = Double.MAX_VALUE;

        for (double result : results) {
            if (result < min) {
                min = result;
            }
        }

        return min;
    }

    public double maximum() {
        double max = Double.MIN_VALUE;

        for (double result : results) {
            if (result > max) {
                max = result;
            }
        }

        return max;
    }

    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }
}
