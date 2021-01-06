package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private final String name;
    private final List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }
//    programming (5)
    public void addSkills(String... skills) {
        for (String skill : skills) {
            int lastIndexOfSpace = skill.lastIndexOf(" ");
            String name = skill.substring(0, lastIndexOfSpace);
            int level = Integer.parseInt(skill.substring(lastIndexOfSpace + 2, skill.length() - 1));
            this.skills.add(new Skill(name, level));
        }
    }

    public int findSkillLevelByName(String skillName) {
        if (skills.isEmpty()) {
            throw new SkillNotFoundException();
        }
        for (Skill skill : skills) {
            if (skillName.equals(skill.getName())) {
                return skill.getLevel();
            }
        }
        return -1;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return new ArrayList<>(skills);
    }
}
