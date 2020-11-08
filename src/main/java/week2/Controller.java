package week2;

import java.util.Scanner;

public class Controller {

    private Office office;
    private Scanner scanner = new Scanner(System.in);

    public void readOffice() {
        office = new Office();

        System.out.print("How many meeting rooms do you want to record? ");
        int countOfMeetingRooms = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= countOfMeetingRooms; i++) {
            System.out.println(i + ". MEETING ROOM");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Width: ");
            int width = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Length: ");
            int length = scanner.nextInt();
            scanner.nextLine();
            office.addMeetingRoom(new MeetingRoom(name, length, width));
        }
        System.out.println();
    }

    public void printOffice() {
        System.out.println("1. Meeting rooms in order");
        System.out.println("2. Meeting rooms in reverse order");
        System.out.println("3. Every second meeting rooms");
        System.out.println("4. Areas");
        System.out.println("5. Find by exact name");
        System.out.println("6. Find by name fragment");
        System.out.println("7. Find by area");
    }

    public void runOffice() {
        System.out.print(">>> ");
        int menuItem = scanner.nextInt();
        scanner.nextLine();
        if (menuItem == 1) {
            office.printNames();
        } else if (menuItem == 2) {
            office.printNamesReverse();
        } else if (menuItem == 3) {
            office.printEvenNames();
        } else if (menuItem == 4) {
            office.printAreas();
        } else if (menuItem == 5) {
            System.out.print("Exact name: ");
            String exactName = scanner.nextLine();
            office.printMeetingRoomsWithName(exactName);
        } else if (menuItem == 6) {
            System.out.print("Name fragment: ");
            String partOfName = scanner.nextLine();
            office.printMeetingRoomContains(partOfName);
        } else if (menuItem == 7) {
            System.out.print("Minimum area: ");
            int minArea = scanner.nextInt();
            scanner.nextLine();
            office.printAreasLargerThan(minArea);
        }
    }


    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.readOffice();
        controller.printOffice();
        controller.runOffice();
    }
}
