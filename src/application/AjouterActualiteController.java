package application;

import java.awt.TextArea;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AjouterActualiteController
{
	public int idp=Session.ID;
       @FXML
        private TextField newAct;
	   @FXML
	    private TextArea t;
	    @FXML
	    private TextField titre;

	    @FXML
	    private Label valide;
	  @FXML
	    void valider(MouseEvent event) throws SQLException 
	  {
		  int mx=0;
		  SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	        Date dateJ = new Date();
	        String  d =s.format(dateJ);
		  
           Connection con =Connexion.connectDb(); 
           PreparedStatement ps=con.prepareStatement("select max(idA) from actualite");
          ResultSet rs= ps.executeQuery();
          if(rs.next())
          {
        	  mx=rs.getInt(1);
          }
           PreparedStatement ps2=con.prepareStatement("insert into actualite values(?,?,?,?,?)");
           ps2.setInt(1, mx+1);
           ps2.setString(2,titre.getText());
           ps2.setString(3, newAct.getText());
           ps2.setInt(4, idp);
           ps2.setString(5,d);
           //ps2.execute();
           boolean g=ps2.execute();
           if(g==false)
           {
        	   valide.setVisible(true);
           }
          
	    }
}
