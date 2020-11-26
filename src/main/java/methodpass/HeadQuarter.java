package methodpass;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    private List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper) {
        if (trooper == null) {
            throw new IllegalArgumentException("Trooper must not be null!");
        }
        troopers.add(trooper);
    }

    public void moveTrooperByName(String trooperName, Position target) {
        Trooper trooper = findTrooperByName(trooperName);
        if (trooper != null) {
            moveTrooper(trooper, target);
        }
    }

    public void moveClosestTrooper(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("Target must not be null!");
        }
        Trooper trooper = findClosestTrooper(target);
        if (trooper != null) {
            moveTrooper(trooper, target);
        }
    }

    private Trooper findTrooperByName(String trooperName) {
        Trooper trooper = null;
        int i = 0;

        while (trooper == null && i < troopers.size()) {
            if (troopers.get(i).getName().equals(trooperName)) {
                trooper = troopers.get(i);
            }
            i++;
        }

        return trooper;
    }

    private Trooper findClosestTrooper(Position target) {
        if (troopers.isEmpty()) {
            return null;
        }

        Trooper closestTrooper = troopers.get(0);

        for (Trooper trooper : troopers) {
            if (trooper.distanceFrom(target) < closestTrooper.distanceFrom(target)) {
                closestTrooper = trooper;
            }
        }

        return closestTrooper;
    }

    private void moveTrooper(Trooper trooper, Position target) {
        trooper.changePosition(target);
    }
}
