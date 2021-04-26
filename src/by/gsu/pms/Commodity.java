package by.gsu.pms;

import java.util.Objects;

public class Commodity {
    private String name;
    private float price;
    private int count;

    public Commodity() {
    }

    public Commodity(String name, float price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getCost(){
        return price * count;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return Float.compare(commodity.price, price) == 0 && Objects.equals(name, commodity.name);
    }

}
