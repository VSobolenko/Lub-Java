import by.gsu.pms.*;

import java.util.Arrays;

public class Runner {
    public static void main(String args[]){

        AbstaractPurchase[] product = new AbstaractPurchase[]{
                new PriceDiscount(new Commodity("Milk", 2500),3),
                new PriceDiscount(new Commodity("Meat", 2700),4),
                new PercentDiscount(new Commodity("Fish", 2300),5),
                new PercentDiscount(new Commodity("Apple", 1100),10),
                new TransportExpenses(new Commodity("Bread", 1900),3),
                new TransportExpenses(new Commodity("Pasta", 3020),7)
        };
        Print(product);
        Arrays.sort(product);
        Print(product);
        System.out.println(Max(product));
    }
    public static void Print(AbstaractPurchase[] pr){
        System.out.println();
        for (AbstaractPurchase index : pr){
            System.out.println(index.toString());
        }
    }
    public static AbstaractPurchase Max(AbstaractPurchase[] pr){
        float max = pr[0].getCost();
        AbstaractPurchase rez = null;
        for (AbstaractPurchase index : pr){
            if(index.getCost() > max){
                max = index.getCost();
                rez = index;
            }
        }
        return rez;
    }
}
