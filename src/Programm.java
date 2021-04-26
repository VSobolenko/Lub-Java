import by.gsu.pms.Commodity;
import by.gsu.pms.ConstPriceDiscount;
import by.gsu.pms.PriceDiscount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Programm {
    public static void main(String[] args) {
        int i = 0;
        float maxPrice = 0, totalPrice = 0;

        Commodity[] commodity = new Commodity[6];
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\in.txt")))  {
            String value = reader.readLine();
            while (value != null){
                commodity[i] = GetCommodity(value);
                value = reader.readLine();
                i++;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        for (Commodity index: commodity) {
            if(index != null){
                System.out.println(index.toString());
                totalPrice += index.getPrice();
                if (index.getPrice() > maxPrice){
                    maxPrice = index.getPrice();
                }
            }
        }
        System.out.println("Максимальная стоимость: " + maxPrice);
        System.out.println("Общая стоимость: " + totalPrice);
    }
    public static Commodity GetCommodity(String comm){
        String[] commodity = comm.split(" ");
        switch (commodity[0]){
            case "GENERAL_PURCHASE":
                return new Commodity(commodity[1], Float.parseFloat(commodity[2]), Integer.parseInt(commodity[3]));
            case "DISCOUNT_PURCHASE":
                return new PriceDiscount(commodity[1], Float.parseFloat(commodity[2]), Integer.parseInt(commodity[3]));
            case "CONST_DISCOUNT":
                return new ConstPriceDiscount(commodity[1], Float.parseFloat(commodity[2]), Integer.parseInt(commodity[3]));
            default:
                return null;
        }
    }
}
