import java.io.*;
import java.util.Scanner;

public class Program {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Какой длины должно быть слово, которое нужно заменить: ");
        int len = in.nextInt();
        System.out.print("На какое слово нужно заменять: ");
        String word = in.next();

        String value;
        StringBuffer text;
        try (BufferedReader reader = new BufferedReader(new FileReader("in.txt")))  {
            value = reader.readLine();
            while (value != null){
                //System.out.println(value);
                text = new StringBuffer(value);
                //Убираем лишние символы
                value = value.trim().replaceAll(" +", " ");

                //Заменяем слова на новые
                String[] ter = value.split(" ");
                value = "";
                for (int i =0; i < ter.length; i++){
                    if(ter[i].length() == len){
                        ter[i] = word;
                    }
                    value += ter[i];
                    value += " ";
                }

                //Записываем готовое в файл
                try(FileWriter writer = new FileWriter("out.txt", true))
                {
                    BufferedWriter bufferWriter = new BufferedWriter(writer);
                    bufferWriter.write(value + "\n");
                    bufferWriter.close();
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }

                value = reader.readLine();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
