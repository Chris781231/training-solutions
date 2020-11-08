package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {

        Person person1;
        Person person2;

        person1 = new Person("John Doe", 30);
        person2 = person1;

        person2.setName("Jack Doe");

        System.out.println(person1.getName());
        System.out.println(person2.getName());

        int a, b;
        a = 24;
        b = a;
        b++;

        System.out.println(a);
        System.out.println(b);

        person1 = new Person("James Doe", 25);

        System.out.println(person1);
        System.out.println(person2);

    }
}
