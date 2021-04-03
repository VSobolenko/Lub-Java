package Bank;

public class Account {
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

}
