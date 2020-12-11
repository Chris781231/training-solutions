package isahasa.fleet;

public class FerryBoat implements Ship, CanCarryPassengers, CanCarryGoods {

    private final CanCarryPassengers canCarryPassengers;
    private final CanCarryGoods canCarryGoods;

    public FerryBoat(int maxCargoWeight, int maxPassenger) {
        canCarryPassengers = new CanCarryPassengersBehaviour(maxPassenger);
        canCarryGoods = new CanCarryGoodsBehaviour(maxCargoWeight);
    }

    @Override
    public int loadCargo(int cargoWeight) {
        return canCarryGoods.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return canCarryGoods.getCargoWeight();
    }

    @Override
    public int loadPassenger(int passengers) {
        return canCarryPassengers.loadPassenger(passengers);
    }

    @Override
    public int getPassengers() {
        return canCarryPassengers.getPassengers();
    }
}
