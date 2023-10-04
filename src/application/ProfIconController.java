package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class ProfIconController implements Initializable{
	

	   @FXML
	    private Text Lname;

	   

	    @FXML
	    private Text Phone;

	    @FXML
	    private Text adrs;

	    @FXML
	    private Text cin;

	    @FXML
	    private Text city;

	    @FXML
	    private Text dB;

	    @FXML
	    private Text dEmp;

	    @FXML
	    private Text emailA;

	    @FXML
	    private Text emailP;

	    @FXML
	    private Text name;

	    @FXML
	    private Text ppr;

	    @FXML
	    private Text sexe;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void afficheData(int id) throws SQLException
	{
		try {
		ConnectToDataBase db=new ConnectToDataBase();
		Connection con=db.getConnection();
	    PreparedStatement p=con.prepareStatement("select * from personnel where idP="+id);
	    ResultSet res=p.executeQuery();
	    if(res.next())
	    {
	    	name.setText(res.getString("nom"));
	    	Lname.setText(res.getString("prenom"));
	    	cin.setText(res.getString("cin"));
	    	Phone.setText(res.getString("tele"));
	    	sexe.setText(res.getString("sexe"));
	    	emailP.setText(res.getString("emailPersonnel"));
	    	emailA.setText(res.getString("emailAcademique"));
	    	dB.setText(res.getString("dateNaissance"));
	    	ppr.setText(res.getString("PPR"));
	    	adrs.setText(res.getString("adresse"));
	    	city.setText(res.getString("ville"));
	    	dEmp.setText(res.getString("dateEmploye"));
	    	
	    }
	}
		catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
		catch(Exception e) {
    		e.printStackTrace();
    	}	
	}

}
