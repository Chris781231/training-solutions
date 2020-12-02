package week06d03.senior;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SeriesTest {

    private final Series series = new Series();
    private final List<Integer> ascendingNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    private final List<Integer> descendingNumbers = new ArrayList<>(List.of(5, 4, 3, 2, 1));
    private final List<Integer> unorderedNumbers = new ArrayList<>(List.of(1, 3, 5, 2, 4));

    @Test
    void calculateSeriesTypeTest() {
        assertEquals(SeriesType.ASCENDING, series.calculateSeriesType(ascendingNumbers));
        assertEquals(SeriesType.DESCENDING, series.calculateSeriesType(descendingNumbers));
        assertEquals(SeriesType.UNORDERED, series.calculateSeriesType(unorderedNumbers));
    }

    @Test
    void invalidParamCheckTest() {
        assertThrows(IllegalArgumentException.class, () -> series.calculateSeriesType(null));
        assertThrows(IllegalArgumentException.class, () -> series.calculateSeriesType(List.of()));
        assertThrows(IllegalArgumentException.class, () -> series.calculateSeriesType(List.of(1)));
    }
}