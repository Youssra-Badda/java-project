package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GererActualiteController 
{
	@FXML
    private AnchorPane centreActualite;

    @FXML
    void ajouterActualiter(MouseEvent event) throws IOException 
    {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("AjouterActualite.fxml"));
        Parent root=fxml.load(); 
        centreActualite.getChildren().removeAll();
        centreActualite.getChildren().setAll(root);
    }
    @FXML
    void suprimerActualite(MouseEvent event) throws IOException 
    {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("SuprimerActualite.fxml"));
        Parent root=fxml.load(); 
        centreActualite.getChildren().removeAll();
        centreActualite.getChildren().setAll(root); 
    }
    @FXML
    void modifierAct(MouseEvent event) throws IOException 
    {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("ModifierActualite.fxml"));
        Parent root=fxml.load(); 
        centreActualite.getChildren().removeAll();
        centreActualite.getChildren().setAll(root);    
    }
    @FXML
    void consulterAct(MouseEvent event) throws IOException {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("ActualiteView.fxml"));
        Parent root=fxml.load(); 
        centreActualite.getChildren().removeAll();
        centreActualite.getChildren().setAll(root);
    }
}
