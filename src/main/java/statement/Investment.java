package statement;

public class Investment {

    private double cost;
    private int fund;
    private int interestRate;
    private boolean active;

    public Investment(int fund, int interestRate) {
        this.cost = 0.3 / 100;
        this.fund = fund;
        this.interestRate = interestRate;
        this.active = true;
    }

    public int getFund() {
        return this.fund;
    }

    public double getYield(int days) {
        return this.getFund() * this.interestRate / 100.0 / 365 * days;
    }

    public double close(int days) {
        double withdraw = active ? (this.getFund() + this.getYield(days)) * (1 - this.cost) : 0;
        active = false;
        return withdraw;
    }
}
