package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    private final List<State> states = new ArrayList<>();

    public void readStatesFromFile(String filename) {
        Path file = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String row;
            while((row = reader.readLine()) != null) {
                String[] temp = row.split("-");
                states.add(new State(temp[0], temp[1]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }
    }

    public String findCapitalByStateName(String stateName) {
        for (State state : states) {
            if (state.getStateName().equals(stateName)) {
                return state.getCapital();
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }

    public List<State> getStates() {
        return new ArrayList<>(states);
    }
}
