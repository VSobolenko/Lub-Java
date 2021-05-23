import java.io.*;

public class Program {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        int i = 0;
        String value;
        CitySer[] citySer = new CitySer[10];
        CityExtern[] cityExtern =  new CityExtern[10];

        //Читать данные с файла и записать их в массив
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\in.txt")))  {
            value = reader.readLine();
            while (value != null){
                citySer[i] = GetCitySer(value);
                cityExtern[i] = GetCityExtern(value);
                value = reader.readLine();
                i++;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        Task.Serializable(citySer);

        Task.Externalizable(cityExtern);

        cityExtern = null;
        citySer = null;

        citySer = Task.DeSerializable();
        cityExtern = Task.DeExternalizable();
    }

    public static CitySer GetCitySer(String csvCity){

        if (csvCity.equals("null")){
            return new CitySer();
        }

        String[] city = csvCity.split(";");
        return new CitySer(city[0], Integer.parseInt(city[1]), Integer.parseInt(city[2]));
    }

    public static CityExtern GetCityExtern(String csvCity){

        if (csvCity.equals("null")){
            return new CityExtern();
        }

        String[] city = csvCity.split(";");
        return new CityExtern(city[0], Integer.parseInt(city[1]), Integer.parseInt(city[2]));
    }
}