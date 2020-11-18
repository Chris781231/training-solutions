package week04.modul2_projectwork;

import java.util.*;

public class SchoolRecordsController {

    Scanner scanner = new Scanner(System.in);
    private final ClassRecords classRecord = new ClassRecords("Fifth Grade A", new Random());
    private final List<Subject> subjects = new ArrayList<>();
    private final List<Tutor> tutors = new ArrayList<>();

    public static void main(String[] args) {

        SchoolRecordsController schoolRecordsController = new SchoolRecordsController();

        schoolRecordsController.initSchool();
        schoolRecordsController.printMenu();
        schoolRecordsController.runMenu();

    }


    private void initSchool() {
        Subject geography = new Subject("Földrajz");
        Subject math = new Subject("Mathematika");
        Subject biology = new Subject("Biológia");
        Subject music = new Subject("Zene");
        Subject physics = new Subject("Fizika");
        Subject chemistry = new Subject("Kémia");
        subjects.add(geography);
        subjects.add(math);
        subjects.add(biology);
        subjects.add(music);
        subjects.add(physics);
        subjects.add(chemistry);

        Tutor firstTutor = new Tutor("Nagy Csilla", Arrays.asList(
                subjects.get(subjects.indexOf(math)),
                subjects.get(subjects.indexOf(physics)),
                subjects.get(subjects.indexOf(chemistry))
        ));
        Tutor secondTutor = new Tutor("Kiss Alexandra", Arrays.asList(
                subjects.get(subjects.indexOf(geography)),
                subjects.get(subjects.indexOf(biology)),
                subjects.get(subjects.indexOf(music))
        ));
        tutors.add(firstTutor);
        tutors.add(secondTutor);
    }

    private void printMenu() {
        System.out.println("""
                0. Feltöltés mintaadatokkal
                1. Diákok nevének listázása
                2. Diák név alapján keresése
                3. Diák létrehozása
                4. Diák név alapján törlése
                5. Diák feleltetése
                6. Osztályátlag kiszámolása
                7. Tantárgyi átlag kiszámolása
                8. Diákok átlagának megjelenítése
                9. Diák átlagának kiírása
                10. Diák tantárgyhoz tartozó átlagának kiírása
                11. Kilépés""");
        System.out.print(">> ");
    }

    private void runMenu() {
        String menuItem = scanner.nextLine();

        while (!menuItem.equals("11")) {

            switch (menuItem) {
                case "0":
                    loadSamples();
                    break;
                case "1":
                    listStudentNames();
                    break;
                case "2":

                    findStudentByName();
                    break;
                case "3":
                    addStudent();
                    break;
                case "4":
                    removeStudentByName();
                    break;
                case "5":
                    repetition();
                    break;
                case "6":
                    calculateClassAverage();
                    break;
                case "7":
                    calculateClassAverageBySubject();
                    break;
                case "8":
                    listStudyResults();
                    break;
                case "9":
                    calculateAverage();
                    break;
                case "10":
                    calculateSubjectAverage();
                    break;
                default:

            }
            printMenu();
            menuItem = scanner.nextLine();
        }
    }

    private void listStudentNames() {
        try {
            System.out.println(classRecord.listStudentNames());
        } catch (IllegalStateException ise) {
            System.out.println("\nNincs diák az osztályban! Listázás megszakadt!\n");
        }
    }

    private void findStudentByName() {
        System.out.print("\nNév: ");
        String name = scanner.nextLine();

        try {
            System.out.println(classRecord.findStudentByName(name));
        } catch (IllegalStateException ise) {
            System.out.println("\nNincs diák az osztályban!\n");
        } catch (IllegalArgumentException iae) {
            System.out.println("\nNincs ilyen diák az osztályban!\n");
        }
    }

    private void addStudent() {
        System.out.print("\nDiák neve: ");
        String name = scanner.nextLine();
        System.out.println(classRecord.addStudent(new Student(name)) ? "Diák hozzáadva." : "\nIlyen nevű diák már szerepel.\n");
    }

    private void removeStudentByName() {
        System.out.print("\nDiák neve: ");
        String name = scanner.nextLine();
        System.out.println(classRecord.removeStudent(new Student(name)) ? "Diák törölve." : "\nNem szerepel ilyen nevű diák.\n");
    }

    private void repetition() {
        MarkType randomMarkType = MarkType.values()[new Random().nextInt(MarkType.values().length)];
        Subject randomSubject = subjects.get(new Random().nextInt(subjects.size()));
        Tutor randomTutor = tutors.get(new Random().nextInt(tutors.size()));

        try {
            String randomStudent = classRecord.repetition().getName();

            classRecord.findStudentByName(randomStudent).grading(new Mark(randomMarkType, randomSubject, randomTutor));
            System.out.println("\n" + randomStudent + " feleltetve.\n" +
                    "Tárgy: " + randomSubject.getSubjectName() + "\n" +
                    "Érdemjegy: " + randomMarkType + "\n");
        } catch (IllegalStateException ise) {
            System.out.println("\nNincs diák az osztályban!\n");
        }
    }

    public void calculateClassAverage() {
        try {
            System.out.println("\nOsztályátlag: " + classRecord.calculateClassAverage() + "\n");
        } catch(ArithmeticException ae) {
            System.out.println("\nNincs diák az osztályban! Az átlagszámítás megszakadt!\n");
        }
    }

    private void calculateClassAverageBySubject() {
        System.out.print("\nTantárgy: ");
        String s = scanner.nextLine();
        for (Subject subject : subjects) {
            if (subject.getSubjectName().equals(s)) {
                try {
                    System.out.println("\n" + classRecord.calculateClassAverageBySubject(subjects.get(subjects.indexOf(subject))) + "\n");
                } catch (ArithmeticException ai) {
                    System.out.println("\nNincs diák az osztályban! Az átlagszámítás megszakadt!\n");
                }
            }
        }
    }


    public void listStudyResults() {
        try {
            for (StudyResultByName studyResults : classRecord.listStudyResults()) {
                System.out.println(studyResults.getStudentName() + ": " + studyResults.getStudyAverage());
            }
        } catch (IllegalStateException ise) {
            System.out.println("\nNincs diák az osztályban! Az átlagszámítás megszakadt!\n");
        }
    }

    public void calculateAverage() {
        System.out.print("Név: ");
        String name = scanner.nextLine();

        try {
            Student student = classRecord.findStudentByName(name);
            System.out.println(student.calculateAverage() + "\n");
        } catch (IllegalStateException ise) {
            System.out.println("\nNincs diák az osztályban! Az átlagszámítás megszakadt!\n");
        }
    }

    public void calculateSubjectAverage() {
        System.out.print("Név: ");
        String name = scanner.nextLine();
        System.out.print("Tantárgy: ");
        String subject = scanner.nextLine();

        try {
            Student student = classRecord.findStudentByName(name);
            for (Subject s : subjects) {
                if (subject.equals(s.getSubjectName())) {
                    System.out.println(student.calculateSubjectAverage(s));
                }
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("\nNincs diák az osztályban! Az átlagszámítás megszakadt!\n");
        }
    }

    private void loadSamples() {
        String[] studentNames = {"Kiss Gábor", "Kovács Réka", "Szalai Szabolcs"};
        classRecord.addStudent(new Student(studentNames[0]));
        classRecord.addStudent(new Student(studentNames[1]));
        classRecord.addStudent(new Student(studentNames[2]));

        for (int i = 0; i < 20; i++) {
            repetition();
        }
    }
}
