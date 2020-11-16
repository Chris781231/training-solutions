package stringbasic.pets;

import java.util.ArrayList;
import java.util.List;

public class Vet {

    List<Pet> pets = new ArrayList<>();

    public List<Pet> getPets() {
        return pets;
    }

    public void add(Pet pet) {
        boolean found = false;
        for (Pet anotherPet : pets) {
            if (areEquals(pet, anotherPet)) {
                found = true;
            }
        }
        if (!found) {
            pets.add(pet);
        }
    }

    private boolean areEquals(Pet pet, Pet anotherPet) {
        return pet.getRegNumber().equals(anotherPet.getRegNumber());
    }
}
