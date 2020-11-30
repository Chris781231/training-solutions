package week06d01.senior;

public class SeparatedSumBySign {

    private double positiveNum;
    private double negativeNum;

    public double getPositiveNum() {
        return positiveNum;
    }

    public void addPositiveNum(double positiveNum) {
        this.positiveNum += positiveNum;
    }

    public double getNegativeNum() {
        return negativeNum;
    }

    public void addNegativeNum(double negativeNum) {
        this.negativeNum += negativeNum;
    }
}
