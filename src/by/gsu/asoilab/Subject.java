
package by.gsu.asoilab;

public class Subject {
    public String name;
    public Material material = null;
    public float volume;

    public Subject() {
    }

    public Subject(String name, Material material, float volume) {
        this.name = name;
        this.material = material;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getMass(){
        return material.getDensity() * volume;
    }

    @Override
    public String toString() {
        return name + ";" + material.toString() + ";" + volume + ";" + this.getMass();
    }

}