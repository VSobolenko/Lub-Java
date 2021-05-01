import by.gsu.pms.ConverterEmp;
import by.gsu.pms.CurrencyEmp;
import by.gsu.pms.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Какую строку надо заменить?");
        String s1 = in.nextLine();
        System.out.println("На какую строку нужно заменить?");
        String s2 = in.nextLine();

        int i = 0, j = 0;
        String[] buffer = new String[3];

        Employee[] employees = new Employee[5];
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\in.txt")))  {
            String value = reader.readLine();
            while (value != null){
                while(buffer[2] == null){
                    buffer[i] = value;
                    i++;
                    value= reader.readLine();
                }

                if(buffer[0].equals(s1)){
                    buffer[0] = s2;
                }

                employees[j] = new Employee(buffer[0], BigDecimal.valueOf(Double.parseDouble(buffer[1])), Integer.parseInt(buffer[2]));
                buffer = new String[3];
                j++; i=0;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
