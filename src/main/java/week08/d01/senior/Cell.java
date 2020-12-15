package week08.d01.senior;

public class Cell {

    private boolean open;

    public void switchOpen() {
        if (open) {
            open = false;
        } else {
            open = true;
        }
    }

    public boolean isOpen() {
        return open;
    }
}
