import by.gsu.pms.ConverterEmp;
import by.gsu.pms.Employee;

public class Runner {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Anton", 8, 9),
                new Employee("Vladislav", 10, 20),
                null,
                new Employee("Viktor", 12, 9),
                new Employee("Svyatoslav", 7, 13),
                new Employee("Vladimir", 4, 1),
                new Employee()
        };
        for (Employee emp: employees) {
            if(emp != null){
                System.out.println(emp.show());
            }
        }
        employees[employees.length - 1].setExpenses(5);

        System.out.println("Duration = " + employees[1].getDay() * 2);

        for (Employee emp: employees) {
            if(emp != null){
                System.out.println(emp.toString());
            }
        }

        int summ = 0;
        for (Employee emp: employees) {
            if(emp != null){
                summ += emp.getExpenses();
            }
        }
        System.out.println("Sum of total expenses = " + summ);

        int maxExpenses = 0;
        Employee employeeWithMaxExpenses = new Employee();
        for (Employee emp: employees) {
            if(emp != null){
                if(emp.getExpenses() > maxExpenses){
                    employeeWithMaxExpenses = emp;
                    maxExpenses = emp.getExpenses();
                }
            }
        }
        System.out.println("Name " + employeeWithMaxExpenses.getAccount());

    }

}
