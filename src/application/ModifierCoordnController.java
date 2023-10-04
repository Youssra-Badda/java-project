package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ModifierCoordnController implements Initializable{
	public int idp=Session.ID;
	@FXML
	private TextField Gmail;
	@FXML
	private TextField tele;
	
	@FXML
	private Button btnmod;
	
    @FXML
    private Label msgSucce;
	
    ConnectToDataBase db;
    Connection con;
	
    @FXML
    void Modifier(ActionEvent event) throws SQLException {
        String gmail=Gmail.getText();
        int tel=Integer.parseInt(tele.getText());
    	db=new ConnectToDataBase();
		con=db.getConnection(); 
		PreparedStatement st =con.prepareStatement("update personnel set emailPersonnel=? , tele= ?  where idP="+idp);
		st.setString(1,gmail);
		st.setInt(2,tel);
		st.executeUpdate();
//		JOptionPane.showMessageDialog(null, "la modification se fait avec succee");
		msgSucce.setText("la modification se fait avec succès");
	    Gmail.setText("");
		tele.setText("");
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
		db=new ConnectToDataBase();
		con=db.getConnection();
		PreparedStatement st =con.prepareStatement("select * from personnel where idP="+idp);
		ResultSet res =st.executeQuery();
		if(res.next()) {
			String gmail =res.getString(6);
			String tell=String.valueOf(res.getInt(8));
			Gmail.setText(gmail);
			tele.setText(tell);
		}
		con.close();
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
		catch(Exception e) {
    		e.printStackTrace();
    	}
	}
}
