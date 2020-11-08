package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;
    private List<Member> connections = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Member> getConnections() {
        return connections;
    }

    public void connectMember(Member member) {
        connections.add(member);
    }

    public List<String> connectedMembers() {
        List<String> connectedMembers = new ArrayList<>();
        for (Member connection: connections) {
            connectedMembers.add(connection.name);
        }
        return connectedMembers;
    }

    @Override
    public String toString() {
        return name + " " + connectedMembers();
    }
}
