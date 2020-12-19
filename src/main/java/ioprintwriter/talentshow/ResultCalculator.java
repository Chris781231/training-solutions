package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private final List<Production> productions = new ArrayList<>();
    private final List<Vote> votes = new ArrayList<>();

    public void readTalents(Path talentsFile) {
        try (BufferedReader reader = Files.newBufferedReader(talentsFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(" ");
                productions.add(new Production(Integer.parseInt(temp[0]), temp[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file", ioe);
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("Invalid data in first column of file", nfe);
        }
    }

    public void calculateVotes(Path votesFile) {
        try (BufferedReader reader = Files.newBufferedReader(votesFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                int id = Integer.parseInt(line);
                addVote(id);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file", ioe);
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("Invalid data in file", nfe);
        }
    }

    private void addVote(int id) {
        for (Vote vote : votes) {
            if (vote.getId() == id) {
                vote.incNum();
                return;
            }
        }
        votes.add(new Vote(id, 1));
    }

    public List<Vote> getVotes() {
        return new ArrayList<>(votes);
    }

    public List<Production> getProductions() {
        return new ArrayList<>(productions);
    }

    public void writeResultToFile(Path resultFile) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(resultFile))) {
            for (Vote vote : votes) {
                String productionName = findProductionById(vote.getId());
                writer.print(vote.getId() + " ");
                writer.print(productionName + " ");
                writer.println(vote.getNumber());
            }
            writer.printf("Winner: %s%n", findWinner(votes));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't reach file", ioe);
        }
    }

    private String findWinner(List<Vote> votes) {
        Vote maxVote = null;

        for (Vote vote : votes) {
            if (maxVote == null || vote.getNumber() > maxVote.getNumber()) {
                maxVote = vote;
            }
        }

        return maxVote != null ? findProductionById(maxVote.getId()) : "";
    }

    private String findProductionById(int id) {
        for (Production production : productions) {
            if (production.getId() == id) {
                return production.getName();
            }
        }
        return null;
    }
}
