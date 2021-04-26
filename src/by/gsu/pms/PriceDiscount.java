package by.gsu.pms;

public class PriceDiscount extends Commodity {
    public static float discount = 0.5f;

    public PriceDiscount(String name, float price, int count) {
        super(name, price * discount, count);
    }
}
