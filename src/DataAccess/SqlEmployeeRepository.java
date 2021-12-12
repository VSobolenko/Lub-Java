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
        try (Connection connection = DriverManager.getConnection(connectingString)) {

            String request = "INSERT INTO Employee VALUES (? , ? , ?)";
            PreparedStatement st = connection.prepareStatement(request);

            //st.executeUpdate(request);

            st.setInt(1, entity.Id);
            st.setString(2, entity.FirstName);
            st.setString(3, entity.LastName);

            st.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public Employee Read(int id) throws ClassNotFoundException {
        Employee employee = null;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        try (Connection connection = DriverManager.getConnection(connectingString)) {


            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee WHERE id = " + id);

            employee = new Employee();
            employee.Id = id;
            employee.FirstName = rs.getString("first_name");
            employee.LastName = rs.getString("last_name");
        }
        catch (SQLException  e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public ArrayList<Employee> ReadAll() {
        //ResultSet resultSet = null;
        ArrayList<Employee> employees = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try (Connection connection = DriverManager.getConnection(connectingString)) {

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
        try (Connection connection = DriverManager.getConnection(connectingString)) {

            PreparedStatement stmt = connection.prepareStatement("UPDATE Employee " +
                    "SET first_name = ? , last_name = ? WHERE id = ?");

            stmt.setString(1, entity.FirstName);
            stmt.setString(2, entity.LastName);
            stmt.setInt(3, entity.Id);

            stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void Delete(Employee entity) {
        try (Connection connection = DriverManager.getConnection(connectingString)) {

            PreparedStatement stmt = connection.prepareStatement("DELETE FROM Employee WHERE id = ?");

            stmt.setInt(1, entity.Id);

            stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
