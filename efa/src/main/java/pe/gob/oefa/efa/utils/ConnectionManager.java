package pe.gob.oefa.efa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ConnectionManager {

//    private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";    
//    private static String driverName = "oracle.jdbc.OracleDriver";   
//    private static String username = "oracle_dba";   
//    private static String password = "password$1";
    private static Connection con;

    private Properties prop = null;
    
    public ConnectionManager(){
         
        InputStream is = null;
        try {
            this.prop = new Properties();
            is = this.getClass().getResourceAsStream("/database.properties");
            prop.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getPropertyValue(String key){
        return this.prop.getProperty(key);
    }
         
    
    
    public static Connection getConnection() {
    	ConnectionManager mpc = new ConnectionManager();
    	
        try {
        	
        	String vUserName = AESCrypt.decrypt(mpc.getPropertyValue("jdbc.username"));
        	String vPassword = AESCrypt.decrypt(mpc.getPropertyValue("jdbc.password"));
        	String vUrl = AESCrypt.decrypt(mpc.getPropertyValue("jdbc.url"));
//            Class.forName(driverName);
            Class.forName(mpc.getPropertyValue("jdbc.driverClassName"));
            try {
            	
//                con = DriverManager.getConnection(url, username, password);
                con = DriverManager.getConnection(vUrl, vUserName, vPassword);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        } catch(Exception e) {
        	System.out.println("bug"+e.getMessage());
        }
        return con;
    }
    
    
}