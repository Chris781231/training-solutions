package week08.d02.senior;

public class Country {

    private final String name;
    private final int population;
    private final int numberOfBadgeColors;
    private final int numberOfNeighbours;

    public Country(String name, int population, int numberOfBadgeColors, int numberOfNeighbours) {
        this.name = name;
        this.population = population;
        this.numberOfBadgeColors = numberOfBadgeColors;
        this.numberOfNeighbours = numberOfNeighbours;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getColorsOfBadge() {
        return numberOfBadgeColors;
    }

    public int getNumberOfNeighbours() {
        return numberOfNeighbours;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", numberOfBadgeColors=" + numberOfBadgeColors +
                ", numberOfNeighbours=" + numberOfNeighbours +
                '}';
    }
}
