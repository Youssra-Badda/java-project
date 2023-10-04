package application;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConnectToDataBase {
	protected Connection connection;
        public  Connection getConnection() {
        	final String connectionString = "jdbc:mysql://localhost/personelensah";
        	try{
        		Class.forName("com.mysql.cj.jdbc.Driver");  
        		
        	}catch(ClassNotFoundException e) {
        		Logger.getLogger(ConnectToDataBase.class.getName()).log(Level.SEVERE,null,e);
        	}
        	try {
        		connection=DriverManager.getConnection(connectionString,"root","root");
        	}catch(SQLException e) {
        		Logger.getLogger(ConnectToDataBase.class.getName()).log(Level.SEVERE,null,e);
        	}
         return connection;
        }
       
        
}
