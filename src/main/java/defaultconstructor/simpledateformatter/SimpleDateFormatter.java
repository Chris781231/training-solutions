package defaultconstructor.simpledateformatter;

import defaultconstructor.simpledate.SimpleDate;

public class SimpleDateFormatter {

    private CountryCode countryCode;

    public SimpleDateFormatter() {
        countryCode = CountryCode.HU;
    }

    public String formatDateString(SimpleDate date) {
        return formatDateStringByCountryCode(countryCode, date);
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate date) {
        switch (countryCode) {
            case US:
                return String.format("%d-%d-%d", date.getMonth(), date.getDay(), date.getYear());
            case EN:
                return String.format("%d-%d-%d", date.getDay(), date.getMonth(), date.getYear());
            default:
                return String.format("%d-%d-%d", date.getYear(), date.getMonth(), date.getDay());
        }
    }
}
