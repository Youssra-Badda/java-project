package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
 Connection con=null;
 public static Connection connectDb()
 {
	 try
	 {
		Class.forName("com.mysql.jdbc.Driver");
      Connection con=  DriverManager.getConnection("jdbc:mysql://localhost/personelensah","root","root");
        return con;

	 }
	 catch(Exception e)
	 {
		//JOptionPane.showMessageDialog(null, e);
		 System.out.println("prb rn connexion");
		return null;
	 }
 }
}
