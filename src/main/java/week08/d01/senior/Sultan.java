package week08.d01.senior;

import java.util.ArrayList;
import java.util.List;

public class Sultan {

    private final List<Cell> cells = new ArrayList<>();

    public Sultan(int cellNumber) {
        for (int i = 0; i < cellNumber; i++) {
            cells.add(new Cell());
        }
    }

    public List<Cell> openDoors(int day) {
        for (int i = 0; i < day; i++) {
            for (int j = i; j < cells.size(); j += i + 1) {
                cells.get(j).switchOpen();
            }
        }

        return new ArrayList<>(cells);
    }

    public List<Cell> getCells() {
        return new ArrayList<>(cells);
    }

    public static void main(String[] args) {
        Sultan sultan = new Sultan(100);
        List<Cell> cells = sultan.openDoors(100);
        for (Cell cell : cells) {
            System.out.println(cell.isOpen());
        }
    }
}
