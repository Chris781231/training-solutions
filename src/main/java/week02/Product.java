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

    public static void printComparison(Product prod, Product anotherProd) {
        System.out.print(prod + " & " + anotherProd);
        System.out.println(prod.areTheyEqual(anotherProd) ? " are equal" : " are not equal");
    }

    public static void main(String[] args) {

        Product prod1 = new Product("Milk", "0091 3456728 2");
        Product prod2 = new Product("Bread", "0091 34567 2");
        Product prod3 = new Product("Bread", "0091 345674 2");

        printComparison(prod1, prod2);
        printComparison(prod1, prod3);
        printComparison(prod2, prod3);
    }
}
