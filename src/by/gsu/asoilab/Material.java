package by.gsu.asoilab;

public class Material {
    private String name;
    private float density;

    public Material() {
    }

    public Material(String name, float density) {
        this.name = name;
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ";" + density;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }
}
