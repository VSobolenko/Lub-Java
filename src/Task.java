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

    public static void Externalizable(CityExtern[] cityExtern) throws IOException {
        //Серализация Externalizable
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\Learning\\JavaLearning\\Labs\\save.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(cityExtern);

        objectOutputStream.close();
        System.out.println("Externalizable - OK");
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

    public static CityExtern[] DeExternalizable() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("E:\\Learning\\JavaLearning\\Labs\\save.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        CityExtern[] cityExtern = (CityExtern[]) objectInputStream.readObject();

        objectInputStream.close();
        System.out.println("DeExternalizable - OK");
        return cityExtern;
    }
}
