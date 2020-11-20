package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {
    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> salespersons) {
        Salesperson salespersonWithFurthestAboveTarget = null;

        for (Salesperson salesperson : salespersons) {
            if (salespersonWithFurthestAboveTarget == null
                    || salesperson.getDifferenceFromTarget() < salespersonWithFurthestAboveTarget.getDifferenceFromTarget()) {
                salespersonWithFurthestAboveTarget = salesperson;
            }
        }

        return salespersonWithFurthestAboveTarget;
    }
}
