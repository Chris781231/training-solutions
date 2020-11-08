package attributes.bill;

public class BillMain {

    public static void main(String[] args) {

        Bill bill = new Bill();
        bill.addItem(new Item("Beer", 2, 380));
        bill.addItem(new Item("Cola", 1, 400));
        bill.addItem(new Item("Wine", 1, 1250));
        bill.addItem(new Item("Soda", 1, 150));

        System.out.println(bill.calculateTotalPrice());
    }
}
