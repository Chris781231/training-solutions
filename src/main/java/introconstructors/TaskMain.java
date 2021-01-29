package introconstructors;

public class TaskMain {

    public static void main(String[] args) {
        Task task = new Task("Feladatok", "Hozz létre egy Task osztályt, mely az elvégzendő feladatokról tartalmaz információkat. A feladatnak van címe (title), leírása (description), elkezdésének időpontja (startDateTime), időtartama (duration).\n" +
                "\n" +
                "Fordítsd le az osztályt, és nyisd meg az editorban a Task.class fájlt! Van benne konstruktor? Ha van, mi a tartalma?\n" +
                "\n" +
                "Task példányt a feladat címének és leírásának megadásával lehet létrehozni. Ennek megfelelően készítsd el az osztály konstruktorát! Fordítás után újra nézd meg a a Task.class fájl tartalmát! Milyen és hány konstruktor van benne?\n" +
                "\n" +
                "Készíts minden attribútumhoz gettert, a duration attribútumhoz settert, és egy start() metódust, mely a startDateTime attribútumot az aktuális dátumra és időpontra állítja be!\n" +
                "\n" +
                "A main() metódusban teszteld az osztályt!");

        task.start();
        task.setDuration(45);
        System.out.println(task.getTitle());
        System.out.println(task.getDescription());
        System.out.println(task.getStartDateTime());
        System.out.println(task.getDuration() + "min");
    }
}
