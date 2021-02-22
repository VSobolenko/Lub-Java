import by.gsu.pms.ConverterEmp;
import by.gsu.pms.CurrencyEmp;
import by.gsu.pms.Employee;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Anton", BigDecimal.valueOf(1000.1111), 9),
                new Employee("Vladislav",  BigDecimal.valueOf(2000.2222), 20),
                null,
                new Employee("Viktor",  BigDecimal.valueOf(3000.3333), 9),
                new Employee("Svyatoslav",  BigDecimal.valueOf(4000.4444), 13),
                new Employee("Vladimir",  BigDecimal.valueOf(5000.555), 1),
                new Employee()
        };

        //Выводим информацию о работниках с помощью метода show()
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp.show());
            }
        }

        //Изменяем Expenses у последнего работника
        employees[employees.length - 1].setExpenses(BigDecimal.valueOf(1400.9511));

        System.out.println("Duration = " + employees[1].getDay() * 2);

        //Выводим информацию о работниках в переопределённом методе toString()
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp.toString());
            }
        }

        //Находим всю сумму Expenses
        int sum = 0;
        for (Employee emp : employees) {
            if (emp != null) {
                sum += emp.getExpenses().intValue();
            }
        }
        System.out.println("Sum of total expenses = " + sum);

        //Находим работника у котогорого максимальный Expenses
        int maxExpenses = 0;
        Employee employeeWithMaxExpenses = new Employee();
        for (Employee emp : employees) {
            if (emp != null && emp.getExpenses().intValue() > maxExpenses) {
                employeeWithMaxExpenses = emp;
                maxExpenses = emp.getExpenses().intValue();
            }
        }
        System.out.println("Name " + employeeWithMaxExpenses.getAccount());

        //Перевести в другую денежную валюту
        ConverterEmp.convertExpenses(employees, CurrencyEmp.USD);
        //Изменить точность
        ConverterEmp.setScaleExpenses(employees, 2);
    }
}
