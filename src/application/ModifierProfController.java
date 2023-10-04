package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ModifierProfController implements Initializable {
	   @FXML
	    private ComboBox<String> box;

	    @FXML
	    private TextField newValue;
	    @FXML
	    private ComboBox<String> ppr;
        
	    @FXML
	    private Label valide;
	    @FXML
	    void modifier(MouseEvent event) throws SQLException 
	    {
	    String dt=box.getValue();	
    	String pr=ppr.getValue();
    	String newvl=newValue.getText();
    	Connection con=Connexion.connectDb();
    	if (dt=="nom")
    	{
    		PreparedStatement ps=con.prepareStatement("update personnel set nom=? where emailAcademique= ?");
	    	ps.setString(1,newvl);
	    	//ps.setString(1,dt);
	    	ps.setString(2,pr);
	        ps.executeUpdate();
	        valide.setVisible(true);	
    	}
    	if (dt=="prenom")
    	{
    		PreparedStatement ps=con.prepareStatement("update personnel set prenom=? where emailAcademique= ?");
	    	ps.setString(1,newvl);
	    	//ps.setString(1,dt);
	    	ps.setString(2,pr);
	        ps.executeUpdate();
	        valide.setVisible(true);	
    	}
    	if (dt=="cin")
    	{
    		PreparedStatement ps=con.prepareStatement("update personnel set cin=? where emailAcademique= ?");
	    	ps.setString(1,newvl);
	    	//ps.setString(1,dt);
	    	ps.setString(2,pr);
	        ps.executeUpdate();
	        valide.setVisible(true);	
    	}
    	if (dt=="emailPersonnel")
    	{
    		PreparedStatement ps=con.prepareStatement("update personnel set emailPersonnel=? where emailAcademique= ?");
	    	ps.setString(1,newvl);
	    	//ps.setString(1,dt);
	    	ps.setString(2,pr);
	        ps.executeUpdate();
	        valide.setVisible(true);	
    	}
    	if (dt=="PPR")
    	{
    		PreparedStatement ps=con.prepareStatement("update personnel set PPR=? where emailAcademique= ?");
	    	ps.setString(1,newvl);
	    	//ps.setString(1,dt);
	    	ps.setString(2,pr);
	        ps.executeUpdate();
	        valide.setVisible(true);	
    	}
    	if (dt=="dateNaissance")
    	{
    		PreparedStatement ps=con.prepareStatement("update personnel set dateNaissance=? where emailAcademique= ?");
	    	ps.setString(1,newvl);
	    	//ps.setString(1,dt);
	    	ps.setString(2,pr);
	        ps.executeUpdate();
	        valide.setVisible(true);	
    	}
    	if (dt=="dateEmploye")
    	{
    		PreparedStatement ps=con.prepareStatement("update personnel set dateEmploye=? where emailAcademique= ?");
	    	ps.setString(1,newvl);
	    	//ps.setString(1,dt);
	    	ps.setString(2,pr);
	        ps.executeUpdate();
	        valide.setVisible(true);	
    	}
    	if (dt=="tele")
    	{
    		PreparedStatement ps=con.prepareStatement("update personnel set tele=? where emailAcademique= ?");
	    	ps.setString(1,newvl);
	    	//ps.setString(1,dt);
	    	ps.setString(2,pr);
	        ps.executeUpdate();
	        valide.setVisible(true);	
    	}
    	if (dt=="adresse")
    	{
    		PreparedStatement ps=con.prepareStatement("update personnel set adresse=? where emailAcademique= ?");
	    	ps.setString(1,newvl);
	    	//ps.setString(1,dt);
	    	ps.setString(2,pr);
	        ps.executeUpdate();
	        valide.setVisible(true);	
    	}
    	if (dt=="ville")
    	{
    		PreparedStatement ps=con.prepareStatement("update personnel set ville=? where emailAcademique= ?");
	    	ps.setString(1,newvl);
	    	//ps.setString(1,dt);
	    	ps.setString(2,pr);
	        ps.executeUpdate();
	        valide.setVisible(true);	
    	}
	    	
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
		public void PleinerCombox() throws SQLException
		{
			int mx=0;
			String items[]= {"nom","prenom","cin","emailPersonnel","PPR","dateNaissance","dateEmploye","tele","adresse","ville"};
		    box.getItems().addAll(items);
		    Connection con =Connexion.connectDb();
		    PreparedStatement ps=con.prepareStatement("select count(idP) from personnel where Status=1");
		    ResultSet rsl=ps.executeQuery();
		    if(rsl.next())
		    {
		    	mx=rsl.getInt(1);
		    }
		    ps.close();
		    rsl.close();
		    System.out.println(mx);
		    String [] items2=new String[mx];
		    ps=con.prepareStatement("select emailAcademique from personnel where Status=1");
		    rsl=ps.executeQuery();
		    int i=0;
		    while(rsl.next())
		    {
		    	items2[i]=rsl.getString(1);
		    	i++;
		    }
		    ppr.getItems().addAll(items2);
		    con.close();
		    ps.close();
	}
}
