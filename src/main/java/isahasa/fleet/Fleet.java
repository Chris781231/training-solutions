package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private int waitingPersons;
    private int waitingCargo;

    private final List<Ship> ships = new ArrayList<>();

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void loadShip(int passengers, int cargoWeight) {
        waitingCargo = cargoWeight;
        waitingPersons = passengers;

        for (Ship ship : ships) {
            if (ship instanceof CanCarryPassengers && waitingPersons > 0) {
                waitingPersons = ((CanCarryPassengers) ship).loadPassenger(waitingPersons);
            }
            if (ship instanceof CanCarryGoods && waitingCargo > 0) {
                waitingCargo = ((CanCarryGoods) ship).loadCargo(waitingCargo);
            }
        }
    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}
