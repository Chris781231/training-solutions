package week12.d02.midlevel;

import java.util.ArrayList;
import java.util.List;

public class Street {

    List<Site> sites = new ArrayList<>();

    public static void main(String[] args) {
        Street street = new Street();
        street.sellSite(new Site(0, 10, Fence.PERFECT));
        street.sellSite(new Site(0, 7, Fence.NEED_UPGRADE));
        street.sellSite(new Site(1, 12, Fence.NEED_UPGRADE));

        for (Fence fence : street.siteStatsByFenceStatus()) {
            System.out.println(fence.getSoldSiteWithThis());
        }

        System.out.println(street.findLastSoldSite());
    }

    public void sellSite(Site site) {
        site.getStatus().add();
        sites.add(site);
    }

    public int findLastSoldSite() {
        if (sites.isEmpty()) {
            return -1;
        }
        int sideOfLastSide = sites.get(sites.size() - 1).getSide();
        int houseNumber = sideOfLastSide == 0 ? 0 : -1;
        for (Site site : sites) {
            if (site.getSide() == sideOfLastSide) {
                houseNumber += 2;
            }
        }
        return houseNumber;
    }

    public Fence[] siteStatsByFenceStatus() {
        return Fence.values();
    }

    public List<Site> getSites() {
        return new ArrayList<>(sites);
    }
}
