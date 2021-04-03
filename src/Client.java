import Bank.Account;
import java.util.*;

public class Client {
    public Client(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    private String fullName;
    private int age;
    private List<Account> account = new ArrayList<Account>();

    public Account FindAccount(int findNumer){
        return account.stream().filter(x -> x.getNumber() == findNumer).findFirst().get();
    }
    public void AddAccount(int number, int money){
        account.add(new Account(number, money));
    }
    public void SortAccount(Comparator<Account> srt){
        Collections.sort(account, srt);
    }

    public int TotalSum(){
        int sum = 0;
        for (Account index: account) {
            sum += index.getMoney();
        }
        return sum;
    }
    public int TotalSumPositiveBalance(){
        int sum = 0;
        for (Account index: account) {
            if(index.getMoney() > 0){
                sum += index.getMoney();
            }
        }
        return sum;
    }
    public int TotalSumNegativeBalance(){
        int sum = 0;
        for (Account index: account) {
            if(index.getMoney() < 0){
                sum += index.getMoney();
            }
        }
        return sum;
    }
}
