import java.io.*;

public class Task {

    public static void Serializable(CitySer[] citySer){
        //Сериальзация Serializable
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("out.dat")))
        {
            oos.writeObject(citySer);
            System.out.println("Serializable - OK");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public static CitySer[] DeSerializable() throws IOException, ClassNotFoundException {
        CitySer[] citySer = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("out.dat")))
        {
            citySer =(CitySer[])ois.readObject();
            System.out.println("DeSerializable - OK");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return citySer;
    }

}
