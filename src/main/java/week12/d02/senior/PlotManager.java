package week12.d02.senior;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlotManager implements Comparator<Plot> {

    List<Plot> plots = new ArrayList<>();

    public void readFromFile(Path file) {
        try(BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public int getHouseNumberOfLastPlot() {
        Plot lastPlot = plots.get(plots.size() - 1);
        int lastPlotSide = lastPlot.getSide();
        int houseNumber = (lastPlotSide %2 == 0 ? 0 : -1);
        for (Plot plot : plots) {
            if (plot.getSide() == lastPlotSide) {
                houseNumber += 2;
            }
        }
        return houseNumber;
    }

    public List<Plot> sortPlots() {
        List<Plot> sortedPlotsByFenceLength = new ArrayList<>(plots);
        for (int i = 0; i < sortedPlotsByFenceLength.size() - 1; i++) {
            for (int j = 0; j < sortedPlotsByFenceLength.size() - i - 1; j++) {
                if (compare(sortedPlotsByFenceLength.get(j), sortedPlotsByFenceLength.get(j + 1)) > 0) {
                    Plot temp = sortedPlotsByFenceLength.get(j);
                    sortedPlotsByFenceLength.set(j, sortedPlotsByFenceLength.get(j + 1));
                    sortedPlotsByFenceLength.set(j + 1, temp);
                }
            }
        }
        return sortedPlotsByFenceLength;
    }

    public void writeOddSideToFile(Path file) {
        int houseNumber = -1;
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (Plot plot : plots) {
                if (plot.getSide() == 1) {
                    houseNumber += 2;
                    writeString(writer, plot, houseNumber);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("cannot write file", ioe);
        }
    }

    private void writeString(BufferedWriter writer, Plot plot, int houseNumber) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(houseNumber).append(")");
        sb.append(String.valueOf(plot.getFenceColor()).repeat(Math.max(0, plot.getFenceLength())));
        writer.write(sb.toString());
    }

    private void processLine(String line) {
        String[] parts = line.split(" ");
        try {
            int side = Integer.parseInt(parts[0]);
            int fenceLength = Integer.parseInt(parts[1]);
            char fenceColor = parts[2].charAt(0);
            plots.add(new Plot(side, fenceLength, fenceColor));
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("wrong color", nfe);
        }
    }

    @Override
    public int compare(Plot o1, Plot o2) {
        return Integer.compare(o1.getFenceLength(), o2.getFenceLength());
    }
}
