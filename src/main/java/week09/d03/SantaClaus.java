package week09.d03;

import java.util.ArrayList;
import java.util.List;

public class SantaClaus {

    private final List<Person> persons;

    public SantaClaus(List<Person> persons) {
        this.persons = persons;
    }

    public void getThroughChimneys() {
        for (Person person : persons) {
            person.setPresent();
        }
    }

    public List<Person> getPersons() {
        return new ArrayList<>(persons);
    }
}
