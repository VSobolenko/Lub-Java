package DataAccess;

import DataAccess.Domain.Certification;

import java.sql.*;
import java.util.ArrayList;

public class SqlCertificationRepository implements IRepository<Certification> {
    private String connectingString;

    public SqlCertificationRepository(String connectingString) throws SQLException {
        this.connectingString = connectingString;
    }

    @Override
    public int Create(Certification entity) {
        try (Connection connection = DriverManager.getConnection(connectingString);
             Statement statement = connection.createStatement();) {

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Certification(id, employee_id, information) " +
                    "VALUES (" + entity.Id +", " + entity.EmployeeId + ", " + entity.Information );

            stmt.setInt(1, entity.Id);
            stmt.setInt(2, entity.EmployeeId);
            stmt.setString(3, entity.Information);

            stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public Certification Read(int id) {
        //ResultSet resultSet = null;
        Certification certification = null;

        try (Connection connection = DriverManager.getConnection(connectingString);
             Statement statement = connection.createStatement();) {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Certification WHERE id = " + id);

            certification = new Certification();
            certification.Id = id;
            certification.EmployeeId = Integer.parseInt( rs.getString("employee_id"));
            certification.Information = rs.getString("information");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return certification;
    }

    @Override
    public ArrayList<Certification> ReadAll() {
        //ResultSet resultSet = null;
        ArrayList<Certification> certifications = null;

        try (Connection connection = DriverManager.getConnection(connectingString);
             Statement statement = connection.createStatement();) {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Certification");

            certifications = new ArrayList<Certification>();
            while (rs.next()){
                Certification certification = new Certification();
                certification.Id = Integer.parseInt( rs.getString("id"));
                certification.EmployeeId = Integer.parseInt( rs.getString("employee_id"));
                certification.Information = rs.getString("information");

                certifications.add(certification);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return certifications;
    }

    @Override
    public void Update(Certification entity) {
        try (Connection connection = DriverManager.getConnection(connectingString);
             Statement statement = connection.createStatement();) {

            PreparedStatement stmt = connection.prepareStatement("UPDATE Certification " +
                    "SET employee_id = " + entity.EmployeeId  + ", information =" + entity.Information +" WHERE id = " + entity.Id);

            stmt.setInt(1, entity.Id);
            stmt.setInt(2, entity.EmployeeId);
            stmt.setString(3, entity.Information);

            stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void Delete(Certification entity) {
        try (Connection connection = DriverManager.getConnection(connectingString);
             Statement statement = connection.createStatement();) {

            PreparedStatement stmt = connection.prepareStatement("DELETE FROM Certification WHERE id = " + entity.Id);

            stmt.setInt(1, entity.Id);
            stmt.setInt(2, entity.EmployeeId);
            stmt.setString(3, entity.Information);

            stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
