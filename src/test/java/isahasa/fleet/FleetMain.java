package isahasa.fleet;

public class FleetMain {

    public static void main(String[] args) {

        Fleet fleet = new Fleet();
        Liner liner1 = new Liner(100);
        Liner liner2 = new Liner(200);
        CargoShip cargoShip = new CargoShip(50);
        FerryBoat ferryBoat = new FerryBoat(100, 40);

        fleet.addShip(liner1);
        fleet.addShip(liner2);
        fleet.addShip(cargoShip);
        fleet.addShip(ferryBoat);

        fleet.loadShip(350, 170);

        int liner1Passengers = liner1.getPassengers();
        int liner2Passengers = liner2.getPassengers();
        int ferryBoatPassengers = ferryBoat.getPassengers();

        System.out.println(liner1.getPassengers());
        System.out.println(liner2.getPassengers());
        System.out.println(ferryBoat.getPassengers());
        System.out.println(fleet.getWaitingPersons());
    }
}
