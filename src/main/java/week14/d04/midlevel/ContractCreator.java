package week14.d04.midlevel;

import java.util.ArrayList;
import java.util.List;

public class ContractCreator {

    private final Contract template;

    public ContractCreator(String client, List<Integer> monthlyPrices) {
        template = new Contract(client, monthlyPrices);
    }

    public Contract create(String name) {
        return new Contract(name, new ArrayList<>(template.getMonthlyPrices()));
    }

    public Contract getTemplate() {
        return template;
    }
}
