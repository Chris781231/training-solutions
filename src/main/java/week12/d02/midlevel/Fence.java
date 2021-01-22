package week12.d02.midlevel;

public enum Fence {


    PERFECT(0),
    NEED_UPGRADE(0),
    NO_FENCE(0);

    private int soldSiteWithThis;

    Fence(int soldSiteWithThis) {
        this.soldSiteWithThis = soldSiteWithThis;
    }

    public int getSoldSiteWithThis() {
        return soldSiteWithThis;
    }

    public void add() {
        this.soldSiteWithThis++;
    }
}
