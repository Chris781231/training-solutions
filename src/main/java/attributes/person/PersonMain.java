package attributes.person;

public class PersonMain {

    public static void main(String[] args) {

        Person person1 = new Person("Charlie Parker", "CP781231");
        person1.moveTo(new Address("Hungary", "Nézsa", "Szondy út 45.", "2618"));
        System.out.println(person1.personToString());
        person1.getAddress().correctData("Hungary", "Vác", "Piarista u. 6.", "2600");
        person1.correctData("Ligeti Károly", "LK781231");
        System.out.println(person1.personToString());
    }
}
