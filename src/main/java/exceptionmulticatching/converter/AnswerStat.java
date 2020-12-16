package exceptionmulticatching.converter;

public class AnswerStat {

    BinaryStringConverter converter;

    public AnswerStat(BinaryStringConverter converter) {
        this.converter = converter;
    }

    public boolean[] convert(String s) {
        try {
            return converter.binaryStringToBooleanArray(s);
        } catch (NullPointerException | IllegalArgumentException e) {
            e.printStackTrace();
            throw new InvalidBinaryStringException(e);
        }
    }

    public int answerTruePercent(String answers) {
        boolean[] booleans = convert(answers);
        int trueCounter = 0;
        for (boolean b : booleans) {
            if (b) {
                trueCounter++;
            }
        }
        return (int) Math.round((double) trueCounter / booleans.length * 100);
    }
}
