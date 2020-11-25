package methodparam.measurement;

public class ExtremValues {

    private final double min;
    private final double max;

    public ExtremValues(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
