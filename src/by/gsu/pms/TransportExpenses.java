package by.gsu.pms;

public class TransportExpenses extends AbstaractPurchase{
    private float expenses = 0;

    @Override
    public float getCost() {
        return super.getCost() + expenses;
    }

    public TransportExpenses(Commodity commodity, int count) {
        super(commodity, count);
    }
}
