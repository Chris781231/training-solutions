package lambdaintro.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private final String name;
    private final List<String> skills;
    private final Sex sex;
    private final List<String> messages = new ArrayList<>();

    public Member(String name, List<String> skills, Sex sex) {
        this.name = name;
        this.skills = skills;
        this.sex = sex;
    }

    public void sendMessage(String message) {
        messages.add(message);
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }

    public Sex getGender() {
        return sex;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }
}
