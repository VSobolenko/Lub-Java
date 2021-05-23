import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CityExtern extends City implements Externalizable {
    public CityExtern(String name, int population, int square) {
        super(name, population, square);
    }

    public CityExtern() {
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.setName((String) objectInput.readObject());
        this.setPopulation((Integer) objectInput.readObject());
        this.setSquare((Integer) objectInput.readObject());
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.getName());
        objectOutput.writeObject(this.getPopulation());
        objectOutput.writeObject(this.getSquare());
    }
}
