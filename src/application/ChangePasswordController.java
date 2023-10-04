package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;

public class ChangePasswordController {
	@FXML
	private Button btnchange;
	@FXML
	private TextField user;
	@FXML
	private TextField oldpass;
	@FXML
	private TextField newpass;
	@FXML
	private TextField conpass;
	@FXML
	    private Label msgsuc;
	public int idp=Session.ID;
	
	
	ConnectToDataBase db;
	Connection con;
	// Event Listener on Button[#btnchange].onAction
	@FXML
	public void changer(ActionEvent event) throws SQLException {
		db=new ConnectToDataBase();
		con=db.getConnection();
		PreparedStatement st =con.prepareStatement("select * from login where userName=? and password=? ");
		st.setString(1,user.getText());
		st.setString(2,oldpass.getText());
		ResultSet res =st.executeQuery();
		if(res.next()) {
			
			if(newpass.getText().equals(conpass.getText())) {
				
				String newpss=newpass.getText();
				PreparedStatement st1 =con.prepareStatement("update login set password='"+newpss+"' where idP="+idp);//dynamique
				st1.executeUpdate();
				msgsuc.setText("L'opération est bien effectué");
				user.setText("");
				oldpass.setText("");
				newpass.setText("");
				conpass.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "Confirmation is incorrect");
				user.setText("");
				oldpass.setText("");
				newpass.setText("");
				conpass.setText("");
			}
		}else {
			JOptionPane.showMessageDialog(null, "username or password are not  Matched");
			user.setText("");
			oldpass.setText("");
			newpass.setText("");
			conpass.setText("");
		}
		con.close();
	}
}
