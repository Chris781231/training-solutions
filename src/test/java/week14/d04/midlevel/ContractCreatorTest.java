package week14.d04.midlevel;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ContractCreatorTest {

    ContractCreator creator = new ContractCreator("John Doe", List.of(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));

    @Test
    void create() {

        Contract contract = creator.create("Konkrét Gréta");
        contract.getMonthlyPrices().set(11, 20);
        assertArrayEquals(List.of(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 20).toArray(),
                contract.getMonthlyPrices().toArray());
    }
}