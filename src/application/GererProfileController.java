package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GererProfileController {
	public int idp=Session.ID;
    @FXML
    private AnchorPane centre3;

    @FXML
    void ConsulterFiche(MouseEvent event) throws IOException, SQLException 
    {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("ProfileAdmin.fxml"));
        Parent root=fxml.load();
		
		centre3.getChildren().removeAll();
		ProfileAdminController ct=fxml.getController();
		ct.afficheData(idp);
		centre3.getChildren().setAll(root);
    }
    @FXML
    void modifierCor(MouseEvent event) throws IOException, SQLException {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("ModifierCordonnes.fxml"));
        Parent root=fxml.load();		
		centre3.getChildren().removeAll();
		centre3.getChildren().setAll(root);
    }
    @FXML
    void changeMP(MouseEvent event) throws IOException
    {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("changeMotPass.fxml"));
        Parent root=fxml.load();		
		centre3.getChildren().removeAll();
		centre3.getChildren().setAll(root);
    }
}