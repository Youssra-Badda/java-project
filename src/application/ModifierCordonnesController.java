package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ModifierCordonnesController {
	public int idp=Session.ID;
	@FXML
    private TextField champEmail;
	@FXML
    private Label valide;

    @FXML
    void ChangerMP(MouseEvent event) throws SQLException 
    {
    	String nvEmail=champEmail.getText();
    	Connection conn=Connexion.connectDb();
    	// create the java mysql update preparedstatement
        String query = "update personnel set emailPersonnel = ? where idP= ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString   (1, nvEmail);
        preparedStmt.setInt(2, idp);

        // execute the java preparedstatement
        preparedStmt.executeUpdate();
        valide.setVisible(true);
        conn.close();
    }
   

}
