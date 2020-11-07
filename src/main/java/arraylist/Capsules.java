package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Capsules {

    private List<String> caps = new ArrayList<>();

    public void addLast(String capsule) {
        caps.add(capsule);
    }

    public void addFirst(String capsule) {
        caps.add(0, capsule);
    }

    public String removeLast() {
        return caps.remove(caps.size()-1);
    }

    public String removeFirst() {
        return caps.remove(0);
    }

    public List<String> getColors() {
        return caps;
    }


    public static void main(String[] args) {
        Capsules capsules = new Capsules();
        capsules.addFirst("blue");
        capsules.addFirst("brown");
        capsules.addLast("blue");
        System.out.println(capsules.getColors());
        System.out.println(capsules.removeFirst());
        System.out.println(capsules.removeLast());
        System.out.println(capsules.getColors());
    }
}
