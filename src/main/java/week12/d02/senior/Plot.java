package week12.d02.senior;

public class Plot {

    private final int side;
    private final int fenceLength;
    private final char fenceColor;

    public Plot(int side, int fenceLength, char fenceColor) {
        if (side < 0 || side > 1) {
            throw new IllegalArgumentException("invalid side param");
        }
        if (fenceLength < 8 || fenceLength > 20) {
            throw new IllegalArgumentException("invalid fence length param");
        }
        this.side = side;
        this.fenceLength = fenceLength;
        this.fenceColor = fenceColor;
    }

    public int getSide() {
        return side;
    }

    public int getFenceLength() {
        return fenceLength;
    }

    public char getFenceColor() {
        return fenceColor;
    }

    @Override
    public String toString() {
        return "Plot{" +
                "side=" + side +
                ", fenceLength=" + fenceLength +
                ", fenceColor=" + fenceColor +
                '}';
    }
}
