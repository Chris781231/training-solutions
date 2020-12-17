package ioreadwritebytes;

public class Temperatures {

    private final byte[] data;

    public Temperatures(byte[] data) {
        checkData(data);
        this.data = data;
    }

    private void checkData(byte[] data) {
        if (data == null) {
            throw new IllegalArgumentException("data is null");
        }
        if (data.length != 365) {
            throw new IllegalArgumentException("data must contains datas for last 365 days");
        }
    }

    public double getYearAverage() {
        int sum = 0;

        for (byte temp : data) {
            sum += temp;
        }

        return (double) sum / 365;
    }

    public double getMonthAverage() {
        int sum = 0;

        for (int i = data.length - 30; i < data.length; i++) {
            sum += data[i];
        }

        return (double) sum / 30;
    }

    public byte[] getData() {
        return data;
    }

    public static void main(String[] args) {
        byte[] bytes = new byte[365];
        for (int i = 0; i < 365; i++) {
            bytes[i] = 1;
        }
        Temperatures temperatures = new Temperatures(bytes);
        temperatures.getMonthAverage();
    }
}
