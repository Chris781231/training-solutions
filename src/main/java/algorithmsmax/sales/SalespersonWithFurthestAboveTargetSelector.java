package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {
    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersons) {
        Salesperson salespersonWithFurthestAboveTarget = null;

        for (Salesperson salesperson : salespersons) {
            if (salespersonWithFurthestAboveTarget == null
                    || salesperson.getDifferenceFromTarget() > salespersonWithFurthestAboveTarget.getDifferenceFromTarget()) {
                salespersonWithFurthestAboveTarget = salesperson;
            }
        }

        return salespersonWithFurthestAboveTarget;
    }
}
