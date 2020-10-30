package classstructuremethods;

public class NoteMain {

    public static void main(String[] args) {

        Note note = new Note();
        note.setName("Charlie Parker");
        note.setTopic("Test topic");
        note.setText("This is a test topic's body...");

        System.out.println(note.getNoteText());

    }

}
