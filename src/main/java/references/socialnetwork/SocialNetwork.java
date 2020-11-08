package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    
    private List<Member> members = new ArrayList<>();

    public void addMember(String name) {
        members.add(new Member(name));
    }
    
    public void connect(String name, String otherName) {
        Member nameFirstHit = findByName(name);
        Member otherNameFirstHit = findByName(otherName);

        if (nameFirstHit != null && otherNameFirstHit != null) {
            nameFirstHit.connectMember(otherNameFirstHit);
        } else {
            System.out.println("One or more people are not in the database! Try again other people!");
        }
    }

    private Member findByName(String name) {
        for (Member member: members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<String> bidirectionalConnections() {
        List<String> connections = new ArrayList<>();
        for (Member member: members) {
            for (Member connectedMember: member.getConnections()) {
                if (connectedMember.getConnections().contains(member)) {
                    connections.add(member.getName() + " - " + connectedMember.getName());
                }
            }
        }
        return connections;
    }

    @Override
    public String toString() {
        return members.toString();
    }
}
