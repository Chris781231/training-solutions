package classstructuremethods;

public class ClientMain {

    public static void main(String[] args) {

        Client client = new Client();
        client.setName("Charlie Parker");
        client.setYear(1978);
        client.setAddress("2618 Nézsa, Szondy út 45.");

        System.out.println(client.getName() + " (" +
                client.getYear() + ")\n" +
                client.getAddress());

        client.migrate("2600 Vác, Piarista u. 6.");

        System.out.println(client.getName() + " (" +
                client.getYear() + ")\n" +
                client.getAddress());

    }

}
