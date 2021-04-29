package by.gsu.pms;

public class AbstaractPurchase implements Comparable<AbstaractPurchase>, IProduct{
    private Commodity commodity;
    private int count;

    public AbstaractPurchase() {
    }

    public AbstaractPurchase(Commodity commodity, int count) {
        this.commodity = commodity;
        this.count = count;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getCost(){
        return commodity.getPrice() * count;
    }

    @Override
    public String toString() {
        return commodity.toString() + ";" + count;
    }

    @Override
    public int compareTo(AbstaractPurchase o) {
        if(this.getCost() > o.getCost()){
            return 1;
        }
        else if(this.getCost() < o.getCost()){
            return -1;
        }
        return 0;
    }
}
