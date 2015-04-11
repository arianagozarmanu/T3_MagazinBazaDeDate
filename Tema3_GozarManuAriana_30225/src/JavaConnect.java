/*
 * Metoda ConnectDB face conectarea cu baza de date
 */

/**
 *
 * @author Ariana
 */
import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;
public class JavaConnect {
    Connection conn=null;
    
    public static Connection ConnectDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn=DriverManager.getConnection("jdbc:sqlite:D:\\AN II - sem II\\TP\\NetBeans\\Tema3\\Shop.sqlite");
          //   JOptionPane.showMessageDialog(null,"Connection established");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
