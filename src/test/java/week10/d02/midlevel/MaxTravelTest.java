package week10.d02.midlevel;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxTravelTest {

    @Test
    void getMaxIndexTest() {
        List<Integer> boardingPeoples = List.of(12,12,0,3,4,4);

        assertEquals(2, new MaxTravel().getMaxIndex(boardingPeoples));
    }
}