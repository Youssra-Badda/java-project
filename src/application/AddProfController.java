package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class AddProfController {
	@FXML
	private TextField nom;
	@FXML
	private TextField prenom;
	@FXML
	private TextField cin;
	@FXML
	private TextField ppr;
	@FXML
	private TextField ville;
	@FXML
	private TextField adresse;
	@FXML
	private TextField tel;
	@FXML
	private TextField DN;
	@FXML
	private TextField DE;
	@FXML
	private TextField EP;
	@FXML
	private Label valide;
	@FXML
    private TextField sexe;
	 //Event Listener on Label.onMouseClicked
	@FXML
	public void ajouterProf(MouseEvent event) throws SQLException {
		
		valide.setVisible(false);
		Connection con =Connexion.connectDb();
		PreparedStatement ps=con.prepareStatement("select max(idP) from personnel");
		ResultSet rsl=ps.executeQuery();
		int maxIdP=0;
		if(rsl.next())
		{
			maxIdP=rsl.getInt(1);
		}
		ps.close();
		rsl.close();
		 ps=con.prepareStatement("insert into personnel values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		ps.setInt(1, maxIdP+1);
		ps.setString(2, nom.getText());
		ps.setString(3,prenom.getText());
		ps.setString(4, cin.getText());
		ps.setString(5, prenom.getText()+"."+nom.getText()+"@etu.uae.ac.ma");
		ps.setString(6, EP.getText());
		ps.setString(7, ville.getText());
		ps.setString(8, tel.getText());
		ps.setString(9,DN.getText());
		ps.setString(10, DE.getText());
		ps.setString(11,adresse.getText());
		ps.setString(12,sexe.getText());
		ps.setString(13, ppr.getText());
		ps.setInt(14, 1);
		ps.execute();
		//System.out.println(maxIdP);
		
		Random mp=new Random();
		int pw=mp.nextInt(20)+2000;
				ps.close();
		rsl.close();
		 ps=con.prepareStatement("insert into login values(?,?,?,?)");
		 ps.setInt(1, maxIdP+1);
			ps.setString(2,prenom.getText()+"."+nom.getText()+"@etu.uae.ac.ma");
			ps.setInt(3,pw);
			ps.setInt(4,  maxIdP+1);
		 ps.execute();
		 valide.setVisible(true);
		
	}
}
