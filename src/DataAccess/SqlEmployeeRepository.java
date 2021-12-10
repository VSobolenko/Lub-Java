package DataAccess;

import DataAccess.Domain.Certification;
import DataAccess.Domain.Employee;

import java.sql.*;
import java.util.ArrayList;

public class SqlEmployeeRepository implements IRepository<Employee> {
    private String connectingString;

    public SqlEmployeeRepository(String connectingString) throws SQLException {
        this.connectingString = connectingString;
    }

    @Override
    public int Create(Employee entity) {
        try (Connection connection = DriverManager.getConnection(connectingString);
             Statement statement = connection.createStatement();) {

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Employee(id, first_name, last_name) " +
                    "VALUES (" + entity.Id +", " + entity.FirstName + ", " + entity.LastName );

            stmt.setInt(1, entity.Id);
            stmt.setString(2, entity.FirstName);
            stmt.setString(3, entity.LastName);

            stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public Employee Read(int id) {
        Employee employee = null;

        try (Connection connection = DriverManager.getConnection(connectingString);
             Statement statement = connection.createStatement();) {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee WHERE id = " + id);

            employee = new Employee();
            employee.Id = id;
            employee.FirstName = rs.getString("first_name");
            employee.LastName = rs.getString("last_name");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public ArrayList<Employee> ReadAll() {
        //ResultSet resultSet = null;
        ArrayList<Employee> employees = null;

        try (Connection connection = DriverManager.getConnection(connectingString);
             Statement statement = connection.createStatement();) {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

            employees = new ArrayList<Employee>();
            while (rs.next()){
                Employee employee = new Employee();
                employee.Id = Integer.parseInt( rs.getString("id"));
                employee.FirstName = rs.getString("first_name");
                employee.LastName = rs.getString("last_name");

                employees.add(employee);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void Update(Employee entity) {
        try (Connection connection = DriverManager.getConnection(connectingString);
             Statement statement = connection.createStatement();) {

            PreparedStatement stmt = connection.prepareStatement("UPDATE Employee " +
                    "SET first_name = " + entity.FirstName  + ", last_name =" + entity.LastName +" WHERE id = " + entity.Id);

            stmt.setInt(1, entity.Id);
            stmt.setString(2, entity.FirstName);
            stmt.setString(3, entity.LastName);

            stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void Delete(Employee entity) {
        try (Connection connection = DriverManager.getConnection(connectingString);
             Statement statement = connection.createStatement();) {

            PreparedStatement stmt = connection.prepareStatement("DELETE FROM Employee WHERE id = " + entity.Id);

            stmt.setInt(1, entity.Id);
            stmt.setString(2, entity.FirstName);
            stmt.setString(3, entity.LastName);

            stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
