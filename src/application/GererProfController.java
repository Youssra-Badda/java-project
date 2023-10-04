package application;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GererProfController {

	
	   @FXML
	    private AnchorPane profA;
	@FXML
	public void ajouterProf(MouseEvent event) throws IOException 
	{
		FXMLLoader fxml=new FXMLLoader(getClass().getResource("AddProf.fxml"));
        Parent root=fxml.load(); 
        profA.getChildren().removeAll();
        profA.getChildren().setAll(root);
           
	}
	   @FXML
	    void suprimeProf(MouseEvent event) throws IOException 
	   {
		   FXMLLoader fxml=new FXMLLoader(getClass().getResource("SuprimerProf.fxml"));
	        Parent root=fxml.load(); 
	        profA.getChildren().removeAll();
	        profA.getChildren().setAll(root);
	           
	    }
	   @FXML
	    void modifierProf(MouseEvent event) throws IOException, SQLException 
	   {

		   FXMLLoader fxml=new FXMLLoader(getClass().getResource("ModifierProf.fxml"));
	        Parent root=fxml.load(); 
	        ModifierProfController c = fxml.getController();
	        c.PleinerCombox();
	        profA.getChildren().removeAll();
	        profA.getChildren().setAll(root);
	    }
}
