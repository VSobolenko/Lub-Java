import DataAccess.Domain.Certification;
import DataAccess.IRepository;
import DataAccess.SqlCertificationRepository;

import javax.swing.*;
import java.sql.SQLException;

public class Runner {
    private static String connstring = "jdbc:sqlserver://LENOVO-L340:1433;databaseName=ManagementSystem.Database;integratedSecurity=true;";
    public static void main(String[] args) throws SQLException {
        IRepository cert = new SqlCertificationRepository(connstring);
        //cert.Create(null);
        JFrame jFrame = new JFrame("MainGui");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
        private static void createAndShowGUI() {
            //Create and set up the window.
            JFrame frame = new JFrame("HelloWorldSwing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Add the ubiquitous "Hello World" label.
            JLabel label = new JLabel("Hello World");
            frame.getContentPane().add(label);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
        }
}
