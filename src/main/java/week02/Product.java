package week02;

public class Product {

    private final String name;
    private final String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean areTheyEqual(Product product) {
        boolean nameEquals = name.equals(product.getName());
        boolean codeEquals = Math.abs(code.length() - product.getCode().length()) <= 1;

        return nameEquals && codeEquals;
    }

    @Override
    public String toString() {
        return "[Name: " + getName() + ", Code: " + getCode() + "]";
    }

    public static void main(String[] args) {

        Product prod1 = new Product("Milk", "0091 3456728 2");
        Product prod2 = new Product("Bread", "0091 34567 2");
        Product prod3 = new Product("Bread", "0091 345674 2");

        String equalString = " are equal";
        String notEqualString = " are not equal";

        System.out.print(prod1 + " & " + prod2);
        System.out.println(prod1.areTheyEqual(prod2) ? equalString : notEqualString);
        System.out.print(prod1 + " & " + prod3);
        System.out.println(prod1.areTheyEqual(prod3) ? equalString : notEqualString);
        System.out.print(prod2 + " & " + prod3);
        System.out.println(prod2.areTheyEqual(prod3) ? equalString : notEqualString);
    }
}
