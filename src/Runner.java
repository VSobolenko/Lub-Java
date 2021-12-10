import DataAccess.Domain.Certification;
import DataAccess.IRepository;
import DataAccess.SqlCertificationRepository;

import java.sql.SQLException;

public class Runner {
    private static String connstring = "jdbc:sqlserver://LENOVO-L340:1433;databaseName=ManagementSystem.Database;integratedSecurity=true;";
    public static void main(String[] args) throws SQLException {
        IRepository cert = new SqlCertificationRepository(connstring);
        cert.Create(null);
    }
}
