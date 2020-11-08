package week2;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        for (int i = 0; i < meetingRooms.size(); i++) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printNamesReverse() {
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEvenNames() {
        for (int i = 1; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {
        for (int i = 0; i < meetingRooms.size(); i++) {
            System.out.println(meetingRooms.get(i));
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (int i = 0; i < meetingRooms.size(); i++) {
            if (meetingRooms.get(i).getName().equals(name)) {
                System.out.println(meetingRooms.get(i).getWidth() + " * " + meetingRooms.get(i).getLength() +
                                   " (" + meetingRooms.get(i).getArea() + ")");
            }
        }
    }

    public void printMeetingRoomContains(String part) {
        for (int i = 0; i < meetingRooms.size(); i++) {
            if (meetingRooms.get(i).getName().toLowerCase().contains(part.toLowerCase())) {
                System.out.println(meetingRooms.get(i));
            }
        }
    }

    public void printAreasLargerThan(int area) {
        for (int i = 0; i < meetingRooms.size(); i++) {
            if (meetingRooms.get(i).getArea() > area) {
                System.out.println(meetingRooms.get(i));
            }
        }
    }
}
