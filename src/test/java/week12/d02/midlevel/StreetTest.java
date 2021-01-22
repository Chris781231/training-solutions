package week12.d02.midlevel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreetTest {

    Street street = new Street();

    @BeforeEach
    void setUp() {
        street.sellSite(new Site(0, 10, Fence.PERFECT));
        street.sellSite(new Site(0, 7, Fence.NEED_UPGRADE));
        street.sellSite(new Site(1, 12, Fence.NEED_UPGRADE));
        street.sellSite(new Site(0, 9, Fence.PERFECT));
        street.sellSite(new Site(0, 11, Fence.NO_FENCE));
        street.sellSite(new Site(1, 13, Fence.PERFECT));
    }

    @Test
    void sellSite() {
        street.sellSite(new Site(1, 8, Fence.PERFECT));
        assertEquals(7, street.getSites().size());
    }

    @Test
    void findLastSoldSite() {
        assertEquals(3, street.findLastSoldSite());
    }

    @Test
    void siteStatsByFenceStatus() {
        assertEquals(3, Fence.PERFECT.getSoldSiteWithThis());
        assertEquals(2, Fence.NEED_UPGRADE.getSoldSiteWithThis());
        assertEquals(1, Fence.NO_FENCE.getSoldSiteWithThis());
    }
}