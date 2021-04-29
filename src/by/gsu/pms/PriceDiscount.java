package by.gsu.pms;

public class PriceDiscount extends AbstaractPurchase{
    private float discount = 1f;
    @Override
    public float getCost() {
        return super.getCost() * discount;
    }

    public PriceDiscount(Commodity commodity, int count) {
        super(commodity, count);
    }
}
