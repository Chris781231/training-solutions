package lambdaoptional.socialnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SocialNetwork {

    List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public Optional<Member> findFirst(Predicate<Member> condition) {
        for (Member member : members) {
            if (condition.test(member)) {
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    public Optional<Member> findFirstByStream(Predicate<Member> condition) {
        return members.stream().filter(condition).findFirst();
    }

    public Optional<Double> averageNumberOfSkills() {
        if (members.isEmpty()) return Optional.empty();

        double sum = 0;
        for (Member member : members) {
            sum += member.getSkills().size();
        }
        return Optional.of(sum / members.size());
    }

    public Optional<Double> averageNumberOfSkillsByStream() {
        if (members.isEmpty()) return Optional.empty();

        Integer countOfSkills = members.stream().reduce(0, (i, m) -> i + m.getSkills().size(), Integer::sum);
        return Optional.of(countOfSkills.doubleValue() / members.size());
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }
}
