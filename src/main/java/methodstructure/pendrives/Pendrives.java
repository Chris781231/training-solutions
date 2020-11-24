package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendrives) {
        Pendrive bestPendrive = null;

        for (Pendrive pendrive : pendrives) {
            if (bestPendrive == null || pendrive.comparePricePerCapacity(bestPendrive) < 0) {
                bestPendrive = pendrive;
            }
        }

        return bestPendrive;
    }

    public Pendrive cheapest(List<Pendrive> pendrives) {
        Pendrive cheapestPendrive = null;

        for (Pendrive pendrive : pendrives) {
            if (cheapestPendrive == null || pendrive.cheaperThan(cheapestPendrive)) {
                cheapestPendrive = pendrive;
            }
        }

        return cheapestPendrive;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        for (Pendrive pendrive : pendrives) {
            if (pendrive.getCapacity() == capacity) {
                pendrive.risePrice(percent);
            }
        }
    }
}
