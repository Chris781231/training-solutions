package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersons) {
        Salesperson salespersonWithMaxSalesAmount = null;

        for (Salesperson salesperson : salespersons) {
            if (salespersonWithMaxSalesAmount == null || salesperson.getAmount() > salespersonWithMaxSalesAmount.getAmount()) {
                salespersonWithMaxSalesAmount = salesperson;
            }
        }
        return salespersonWithMaxSalesAmount;
    }
}
