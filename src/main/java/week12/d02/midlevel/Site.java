package week12.d02.midlevel;

public class Site {

    private final int side;
    private final int length;
    private final Fence status;

    public Site(int side, int length, Fence status) {
        this.side = side;
        this.length = length;
        this.status = status;
    }

    public int getSide() {
        return side;
    }

    public int getLength() {
        return length;
    }

    public Fence getStatus() {
        return status;
    }
}
