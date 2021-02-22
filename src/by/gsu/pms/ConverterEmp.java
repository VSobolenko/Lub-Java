package by.gsu.pms;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConverterEmp {

    //Метод меняющий денежную валюту на указанную у 1-го работника
    public static void convertExpenses(Employee emp, CurrencyEmp currency){
        BigDecimal oldExpenses = emp.getExpenses();
        switch (currency){
            case USD:
                emp.setExpenses(emp.getExpenses().multiply(BigDecimal.valueOf(0.00261)));
                printInfoChangeCurrency(emp, CurrencyEmp.USD, oldExpenses);
                break;
            case EUR:
                emp.setExpenses(emp.getExpenses().multiply(BigDecimal.valueOf(0.00031)));
                printInfoChangeCurrency(emp, CurrencyEmp.EUR, oldExpenses);
                break;
            case BYR:
                emp.setExpenses(emp.getExpenses().multiply(BigDecimal.valueOf(0.001)));
                printInfoChangeCurrency(emp, CurrencyEmp.BYR, oldExpenses);
                break;
            default:
                throw new NullPointerException("switch mode exception currency");
        }
    }

    //Поменять денежную валюту в всех работников, с указанием новой
    public static void convertExpenses(Employee[] emp, CurrencyEmp currency){
        for (Employee index: emp) {
            if(index!=null){
                convertExpenses(index, currency);
            }
        }
    }

    //Установить новую точность у 1-го работника
    public static void setScaleExpenses(Employee emp, int scale){
        BigDecimal oldExpenses = emp.getExpenses();
        emp.setExpenses(emp.getExpenses().setScale(scale, RoundingMode.HALF_EVEN ));
        System.out.println("Name " + emp.getAccount() + ":" +
                "\nWas expenses = " + oldExpenses + " Stay expenses = " + emp.getExpenses());
    }

    //Установить новую точность у всех работников с указаниме точности
    public static void setScaleExpenses(Employee[] emp, int scale){
        System.out.println("Changed scale to " + scale);
        for (Employee index: emp) {
            if(index != null){
                setScaleExpenses(index, scale);
            }
        }
    }

    //Вывод результатов конвертации денежных валют
    private static void printInfoChangeCurrency(Employee emp, CurrencyEmp nameCurrency, BigDecimal oldExpenses){
        System.out.println("Convert currency " + emp.getAccount() + " to " + nameCurrency  +
                "\nWas expenses = " + oldExpenses + " Stay expenses = " + emp.getExpenses());
    }

}