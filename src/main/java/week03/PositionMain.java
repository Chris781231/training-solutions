package week03;

import java.util.ArrayList;
import java.util.List;

public class PositionMain {

    public static void main(String[] args) {

        List<Position> positions = new ArrayList<>();
        positions.add(new Position("CEO", 300000));
        positions.add(new Position("Manager", 220000));
        positions.add(new Position("Employee", 80000));

        List<Position> bonusLargerThan150000 = new ArrayList<>();

        for (Position position : positions) {
            if(position.getBonus() > 150000) {
                bonusLargerThan150000.add(position);
            }
        }

        System.out.println(bonusLargerThan150000);
    }
}
