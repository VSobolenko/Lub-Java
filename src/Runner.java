import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Runner {
    public static <Commodity> void main(String args[]){
        int i = 0;
        String value;
        City[] city = new City[10];

        try (BufferedReader reader = new BufferedReader(new FileReader("src\\in.txt")))  {
            value = reader.readLine();
            while (value != null){
                city[i] = GetCity(value);
                value = reader.readLine();
                i++;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        for (City index: city) {
            if(index != null){
                System.out.println(index.toString());
            }
        }
    }

    public static City GetCity(String csvCity){

        if (csvCity.equals("null")){
            return new City();
        }

        String[] city = csvCity.split(";");
        return new City(city[0], Integer.parseInt(city[1]), Integer.parseInt(city[2]));
    }
}
