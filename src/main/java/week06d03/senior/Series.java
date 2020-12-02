package week06d03.senior;

import java.util.List;

public class Series {

    private boolean ascending = false;
    private boolean descending = false;

    public SeriesType calculateSeriesType(List<Integer> numbers) {
        if (numbers == null || numbers.size() <= 1) {
            throw new IllegalArgumentException("The number list contains too few items!");
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) < numbers.get(i + 1)) {
                ascending = true;
            } else if (numbers.get(i) > numbers.get(i + 1)) {
                descending = true;
            }
        }

        return checkOrderliness();
    }

    private SeriesType checkOrderliness() {
        SeriesType seriesType;
        if (ascending && !descending) {
            seriesType = SeriesType.ASCENDING;
        } else if (descending && !ascending) {
            seriesType = SeriesType.DESCENDING;
        } else {
            seriesType = SeriesType.UNORDERED;
        }
        initSeries();
        return seriesType;
    }

    private void initSeries() {
        ascending = false;
        descending = false;
    }
}
