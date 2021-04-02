import java.util.Arrays;

public class Runner {
    //IDZ 1 - variant 16 - class name City
    public static void main(String args[]){
        City[] citys = {
                new City("Gomel", 1000, 1100),
                new City("Mink", 2000, 2200),
                new City("Vitebck", 3000, 3300),
                new City("Grodno", 4000, 4400),
                new City("Brest", 5000, 5500),
                new City("Minskaya oblact", 6000, 6600),
                new City("Mogilev", 7000, 7700),
                new City(),
                null
        };

        //Сортировка по имени
        Arrays.sort(citys, City.NameComparator);
        System.out.println("Сортировка по имени:\n");
        for (City index: citys) {
            if(index != null){
                System.out.println(index.toString());
            }
        }

        //Сортировка по количеству жителей
        Arrays.sort(citys, City.PopulationComparator);
        System.out.println("\nСортировка по численности населения:\n");
        for (City index: citys) {
            if(index != null){
                System.out.println(index.toString());
            }
        }

        //Сортировка по площади города
        Arrays.sort(citys, City.PopulationComparator);
        System.out.println("\nСортировка по площади:\n");
        for (City index: citys) {
            if(index != null){
                System.out.println(index.toString());
            }
        }
    }
}
