package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SuprimerProfController {
	@FXML
	private Label valide;
	  @FXML
	    private TextField ec;

	
	@FXML
	public void valider(MouseEvent event) throws SQLException {
		
		Connection con=Connexion.connectDb();
		PreparedStatement ps2=con.prepareStatement("delete from login where userName=?");
		ps2.setString(1,ec.getText());
		ps2.execute();

		PreparedStatement ps=con.prepareStatement("delete from personnel where emailAcademique=?");
		ps.setString(1,ec.getText());
		ps.execute();
				valide.setVisible(true);
	}
}













