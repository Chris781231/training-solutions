package classstructureintegrate;

public class Bank {

    public static void main(String[] args) {

        BankAccount account1 = new BankAccount("12345678-12345678-12345678", "Stex von Boven", 99999999);
        BankAccount account2 = new BankAccount("98765432-98765432-98765432", "Nincsala Mizsna", 25);

        account2.deposit(25);
        account1.withdraw(99999);
        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());

        account1.transfer(account2, 1000000);

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());

    }

}
