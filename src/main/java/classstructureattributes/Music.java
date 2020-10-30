package classstructureattributes;

import java.util.Scanner;

public class Music {

    public static void main(String[] args) {

        Song song = new Song();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Song App\n");

        System.out.println("Tell me your favorite song's band...");
        song.band = scanner.nextLine();

        System.out.println("Tell me your favorite song's title...");
        song.title = scanner.nextLine();

        System.out.println("Tell me your favorite song's length...");
        song.length = scanner.nextInt();

        String output = song.band + " - " + song.title + " (" + song.length + "m)";
        System.out.println(output);

    }

}
