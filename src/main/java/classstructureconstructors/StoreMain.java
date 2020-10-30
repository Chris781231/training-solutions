package classstructureconstructors;

public class StoreMain {

    public static void main(String[] args) {

        Store store1 = new Store("kidney");
        Store store2 = new Store("mica");

        store1.store(500);
        store2.store(314);

        System.out.println("KidneyStore stock is: " + store1.getStock());
        System.out.println("MicaStore stock is: " + store2.getStock());

        store1.dispatch(246);
        store2.dispatch(143);

        System.out.println("KidneyStore stock is: " + store1.getStock());
        System.out.println("MicaStore stock is: " + store2.getStock());

    }

}
