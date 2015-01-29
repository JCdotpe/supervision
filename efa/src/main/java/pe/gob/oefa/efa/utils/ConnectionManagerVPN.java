package pe.gob.oefa.efa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManagerVPN {

//    private static String url = "jdbc:oracle:thin:@10.0.0.15:1521:DESARROLLO";   
	 private static String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
    private static String driverName = "oracle.jdbc.OracleDriver";   
    private static String username = "SUPERVISION";   
    private static String password = "desa3dev";
    private static Connection con;

    
    private Properties prop = null;
    
//    public ConnectionManager(){
//         
//        InputStream is = null;
//        try {
//            this.prop = new Properties();
//            is = this.getClass().getResourceAsStream("/database.properties");
//            prop.load(is);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    
    public String getPropertyValue(String key){
        return this.prop.getProperty(key);
    }
         
    
    
    public static Connection getConnection() {
    	ConnectionManager mpc = new ConnectionManager();
    	
        try {
            Class.forName(driverName);
//            Class.forName(mpc.getPropertyValue("jdbc.driverClassName"));
            try {
                con = DriverManager.getConnection(url, username, password);
//                con = DriverManager.getConnection(mpc.getPropertyValue("jdbc.url"), mpc.getPropertyValue("jdbc.username"), mpc.getPropertyValue("jdbc.password"));
            } catch (SQLException ex) {
//                 log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
}