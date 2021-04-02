import java.util.Comparator;

public class City {
    private final String name;
    private final int population;
    private final int square;

    public City(String name, int population){
        this.name = name;
        this.population = population;
        square = 10000;
    }
    public City(String name, int population, int square){
        this.name = name;
        this.population = population;
        this.square = square;
    }

    public City() {
        name = "default";
        population = 0;
        square = 0;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getSquare() {
        return square;
    }
}
