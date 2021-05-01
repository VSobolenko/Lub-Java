package by.gsu.pms;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;

public class Employee implements Comparable<Employee> {
    private static final int ALLOWANCE = 10;
    private String account;
    private BigDecimal expenses;
    private int day;

    public Employee() {
        this.account = "not name";
        this.expenses = new BigDecimal(0);
        this.day = 0;
    }

    public Employee(String account, BigDecimal expenses, int day) {
        this.account = account;
        this.expenses = expenses;
        this.day = day;
    }

    public static int getALLOWANCE() {
        return ALLOWANCE;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getExpenses() {
        return expenses;
    }

    public void setExpenses(BigDecimal expenses) {
        this.expenses = expenses;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTotal(){
        return day * ALLOWANCE + expenses.intValue();
    }

    public String show(){
        return "rate = " + ALLOWANCE + "\n" +
                "account = " + account + "\n" +
                "transport = " + expenses + "\n" +
                "days = " + day + "\n" +
                "total = " + getTotal() + "\n";
    }
    @Override
    public String toString() {
        return ALLOWANCE + ";" + account + ";" + expenses + ";" + day;
    }

    @Override
    public int compareTo(Employee o2) {
        Employee e2 = (Employee)o2;
        if(this.getTotal() > e2.getTotal()){
            return 1;
        }
        else if(this.getTotal()< e2.getTotal()){
            return -1;
        }
        else {
            return 0;
        }

    }
}
