package by.gsu.pms;

import java.util.Date;

public class Employee {
    private static final int ALLOWANCE = 10;
    private String account;
    private int expenses;
    private int day;

    public Employee() {
    }

    public Employee(String account, int expenses, int day) {
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

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTotal(){
        return day * ALLOWANCE + expenses;
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

}
