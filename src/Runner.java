import Bank.Account;

public class Runner {
    //IDZ 2 - variant 16 - Bank account
    public static void main(String args[]){
        Client Vladislav = new Client("Vladislav", 18);

        Vladislav.AddAccount(123456, 90);
        Vladislav.AddAccount(654321, 90);
        Vladislav.SortAccount(Account.NumberComparator);

        Vladislav.CloseAccount(Vladislav.FindAccount(123456));
        Vladislav.OpecAccount(Vladislav.FindAccount(123456));

        System.out.println(Vladislav.TotalSum());
        System.out.println(Vladislav.TotalSumNegativeBalance());
        System.out.println(Vladislav.TotalSumPositiveBalance());
    }
}
