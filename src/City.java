import java.util.Comparator;

public class City implements Comparable<City> {
    private  String name;
    private  int population;
    private  int square;

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

    public static Comparator<City> NameComparator = new Comparator<City>() {
        @Override
        public int compare(City o1, City o2) {
            if(o1 == null || o2 == null){
                return 0;
            }
            return o1.name.compareTo(o2.name);
        }
    };
    public static Comparator<City> PopulationComparator = new Comparator<City>() {
        @Override
        public int compare(City o1, City o2) {
            if(o1 == null || o2 == null){
                return 0;
            }
            return o1.population - o2.population;
        }
    };
    public static Comparator<City> SquareComparator = new Comparator<City>() {
        @Override
        public int compare(City o1, City o2) {
            if(o1 == null || o2 == null){
                return 0;
            }
            return o1.square - o2.square;
        }
    };

    @Override
    public String toString() {
        return name + ";" + population + ";" + square;
    }

    @Override
    public int compareTo(City o) {
        return 0;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setSquare(int square) {
        this.square = square;
    }
}