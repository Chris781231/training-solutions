package week08.d01.midlevel;

public class Robot {

    public Point move(String moveString) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < moveString.length(); i++) {
            switch (moveString.charAt(i)) {
                case 'F' -> y++;
                case 'L' -> y--;
                case 'B' -> x--;
                case 'J' -> x++;
                default -> throw new IllegalArgumentException("invalid parameter: '" + moveString.charAt(i) + "' character at " + i + ". index");
            }
        }

        return new Point(x, y);
    }
}
