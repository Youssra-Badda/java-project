package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ProfileAdminController implements Initializable{
	public int idp=Session.ID;
@FXML
private Label DN;



@FXML
private Label PPR;

@FXML
private Label cin;

@FXML
private Label emailc;

@FXML
private Label emailp;

@FXML
private Label nom;

@FXML
private Label prenom;

@FXML
private Label sexe;

@FXML
private Label tel;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
public void afficheData(int id) throws SQLException
{
	
    Connection con=Connexion.connectDb();
    PreparedStatement p=con.prepareStatement("select* from personnel where idP="+id);
    ResultSet res=p.executeQuery();
    if(res.next())
    {
    	nom.setText(res.getString("nom"));
    	prenom.setText(res.getString("prenom"));
    	cin.setText(res.getString("cin"));
    	tel.setText(res.getString("tele"));
    	sexe.setText(res.getString("sexe"));
    	emailp.setText(res.getString("emailPersonnel"));
    	emailc.setText(res.getString("emailAcademique"));
    	DN.setText(res.getString("dateNaissance"));
    	//LN.setText(res.getString("lieuNaissanse"));
    	PPR.setText(res.getString("PPR"));
    }
}
}
