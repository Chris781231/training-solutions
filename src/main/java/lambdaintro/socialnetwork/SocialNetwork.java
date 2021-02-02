package lambdaintro.socialnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SocialNetwork {

    private final List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public List<Member> findMembersBy(Predicate<Member> condition) {
        List<Member> result = new ArrayList<>();

        for (Member member : members) {
            if (condition.test(member)) {
                result.add(member);
            }
        }

        return result;
    }

    public void applyToSelectedMembers(Predicate<Member> condition, Consumer<Member> memberConsumer) {
        for (Member member : members) {
            if (condition.test(member)) {
                memberConsumer.accept(member);
            }
        }
    }

    public List<String> transformMembers(Function<Member, String> function) {
        List<String> result = new ArrayList<>();

        for (Member member : members) {
            result.add(function.apply(member));
        }

        return result;
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }
}
