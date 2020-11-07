package array;

public class arrayMain {

    public static void main(String[] args) {

        // 1. exercise
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "sunday"};

        System.out.println(weekdays[1]);
        System.out.println(weekdays.length);

        // 2. exercise
        int[] expOfTwo = new int[5];

        for (int i = 0; i < expOfTwo.length; i++) {
            expOfTwo[i] = (int) Math.pow(2, i);
        }

        for (int item: expOfTwo) {
            System.out.println(item);
        }

        // 3. exercise
        boolean[] bool = {false, true, false, true, false, true};

        for (boolean item : bool) {
            System.out.println(item);
        }
    }
}
