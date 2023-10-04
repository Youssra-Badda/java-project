package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class GererProfilController {
	@FXML
	private Button profile;
	@FXML
	private Button Editpro;
	@FXML
	private Button ChgPass;

    @FXML
    private AnchorPane paneMod;

    public int idp=Session.ID;
    
    @FXML
    void ChangePass(ActionEvent event) throws IOException {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("ChangePassword.fxml"));
        Parent root=fxml.load();
		
        paneMod.getChildren().removeAll();
		paneMod.getChildren().setAll(root);
    }
    
    
    @FXML
    void CheckInform(ActionEvent event) throws Exception {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("ProfileProfs.fxml"));
        Parent root=fxml.load();
		
        paneMod.getChildren().removeAll();
        ProfIconController ct=fxml.getController();
		ct.afficheData(idp); //dynamique
		paneMod.getChildren().setAll(root);
    }

    @FXML
    void EditProfil(ActionEvent event) throws IOException {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("ModifierCoordn.fxml"));
        Parent root=fxml.load();
		
        paneMod.getChildren().removeAll();
		paneMod.getChildren().setAll(root);
    }
	
	
}
