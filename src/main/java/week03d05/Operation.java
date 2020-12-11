package week03d05;

public class Operation {

    private final int leftOperand;
    private final int rightOperand;

    public Operation(String literal) {
        if (literal.isBlank()) {
            throw new IllegalArgumentException("Nem lehet üres paraméter");
        }
        if (!literal.contains("+")) {
            throw new IllegalArgumentException("Csak összeadás ('+') megengedett!");
        }
        leftOperand = Integer.parseInt(literal.substring(0, literal.indexOf("+")).trim());
        rightOperand = Integer.parseInt(literal.substring(literal.indexOf("+") + 1).trim());
    }

    public int getResult() {
        return leftOperand + rightOperand;
    }
}
