import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String args[]){
        String value;
        ArrayList<int[]> collection = new ArrayList<int[]>();

        try (BufferedReader reader = new BufferedReader(new FileReader("in.txt")))  {
            value = reader.readLine();
            while (value != null){
                collection.add(GetArr(value.split(" ")));
                value = reader.readLine();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static int[] GetArr(String[] str){
        int[] rez = new int[str.length];
        for(int i = 0; i < str.length; i++){
            rez[i] = Integer.parseInt(str[i]);
        }
        return rez;
    }
}
