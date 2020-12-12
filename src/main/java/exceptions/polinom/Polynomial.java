package exceptions.polinom;

public class Polynomial {

    private final double[] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        this.coefficients = new double[coefficients.length];
        for (int i = 0; i < coefficients.length; i++) {
            try {
                this.coefficients[i] = Double.parseDouble(coefficients[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Illegal coefficients, not a number", e);
            }
        }

    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, coefficients.length - (i + 1.0));
        }
        return result;
    }

    public double[] getCoefficients() {
        return coefficients;
    }
}
