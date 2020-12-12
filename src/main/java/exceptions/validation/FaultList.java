package exceptions.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FaultList {

    public List<String> processLines(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("lines is null");
        }

        List<String> faultLines = new ArrayList<>();

        for (String line : lines) {
            String[] values = line.split(",");
            int lineNumber = scanLineNumber(values[0]);
            if (lineNumber != -1) {
                ProcessingResult result = validateLine(values);
                if (result != ProcessingResult.NO_ERROR) {
                    faultLines.add(lineNumber + "," + result.getCode());
                }
            }
        }

        return faultLines;
    }

    private int scanLineNumber(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private ProcessingResult validateLine(String[] values) {
        if (values.length != 3) {
            return ProcessingResult.WORD_COUNT_ERROR;
        }

        boolean validValue = isValidValue(values[1]);
        boolean validDate = isValidDate(values[2]);

        if (!validValue && !validDate) {
            return ProcessingResult.VALUE_AND_DATE_ERROR;
        }
        if (!validValue) {
            return ProcessingResult.VALUE_ERROR;
        }
        if (!validDate) {
            return ProcessingResult.DATE_ERROR;
        }
        return ProcessingResult.NO_ERROR;
    }

    private boolean isValidValue(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidDate(String value) {
        try {
            new SimpleDateFormat("yyyy.MM.dd.").parse(value);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
