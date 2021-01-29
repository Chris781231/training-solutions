package methoverloading.time;

import java.util.List;

public class ListOfGoodPubs {

    private final List<Pub> goodPubs;

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs == null || goodPubs.isEmpty()) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest() {
        Pub earliestOpenPub = null;

        for (Pub pub : goodPubs) {
            if (earliestOpenPub == null || pub.getOpenFrom().isEarlier(earliestOpenPub.getOpenFrom())) {
                earliestOpenPub = pub;
            }
        }
        return earliestOpenPub;
    }
}
