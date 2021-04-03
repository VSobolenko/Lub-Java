package Bank;
import java.util.Comparator;

public class Account implements Comparable {
    private int number;
    private int money;
    private boolean availableAccount = true;

    public Account(int number, int money) {
        this.number = number;
        this.money = money;
    }

    public void Put(int sum){
        if(!availableAccount)
            return;
        money += sum;
    }
    public  void Take(int sum){
        if(!availableAccount)
            return;
        money -= sum;
    }
    public void OpecAccount(){
        availableAccount = true;
    }
    public void CloseAccount(){
        availableAccount = false;
    }

    public int getNumber() {
        return number;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    public static Comparator<Account> NumberComparator = new Comparator<Account>() {
        @Override
        public int compare(Account a1, Account a2) {
            if(a1 == null || a2 == null){
                return 0;
            }
            return a1.number - a2.number;
        }
    };
    public static Comparator<Account> MoneyComparator = new Comparator<Account>() {
        @Override
        public int compare(Account a1, Account a2) {
            if(a1 == null || a2 == null){
                return 0;
            }
            return a1.money - a2.money;
        }
    };
}
