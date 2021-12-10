import Core.IGUIFactory;
import Core.WindowsGUI;
import DataAccess.IRepository;
import DataAccess.SqlCertificationRepository;
import GUI.MainGui;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Runner {
    private static String connstring = "jdbc:sqlserver://LENOVO-L340:1433;databaseName=ManagementSystem.Database;integratedSecurity=true;";
    public static void main(String[] args) throws SQLException {
        IRepository crudCert = new SqlCertificationRepository(connstring);
        IRepository crudEmp = new SqlCertificationRepository(connstring);

        JFrame frame = new JFrame("MainGui");
        MainGui mainGui = new MainGui(crudEmp, crudCert);

        frame.setContentPane(mainGui.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
