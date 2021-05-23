import java.io.Serializable;

public class CitySer extends City implements Serializable {
    public CitySer(String name, int population, int square) {
        super(name, population, square);
    }

    public CitySer() {
    }
}
