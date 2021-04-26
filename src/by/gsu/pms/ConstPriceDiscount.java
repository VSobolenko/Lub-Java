package by.gsu.pms;

public class ConstPriceDiscount extends Commodity {
    public static float discount = 0.5f;
    public static int countDiscount = 10;
    private  float priceDiscount = 0.1f;

    public ConstPriceDiscount(String name, float price, int count) {
        super(name, price, count);
    }

    @Override
    public float getPrice() {

        if(super.getCount() >= countDiscount){
            return super.getPrice() * discount;
        }
        else{
            return super.getPrice();
        }
    }
}
