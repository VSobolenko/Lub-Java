package by.gsu.pms;

public class PercentDiscount extends PriceDiscount {
    private  float discount = 1;
    @Override
    public float getCost() {
        return super.getCost() * discount;
    }

    public PercentDiscount(Commodity commodity, int count) {
        super(commodity, count);
    }
}
