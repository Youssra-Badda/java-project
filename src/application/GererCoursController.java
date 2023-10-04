package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class GererCoursController {
	 @FXML
	    private Button BtnAdd;
	 @FXML
	    private AnchorPane gererprof;
	
	  @FXML
	    private Button btnEdit;
	 
	  @FXML
	    private Button btnCheck;
	  
	@FXML
	public void PassToAdd(ActionEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("PaneCours.fxml"));
	    Parent root=fxml.load();
	    
	    gererprof.getChildren().removeAll();
	    gererprof.getChildren().setAll(root);
		
	   //System.out.println(Session.idP);
	}
	
	  @FXML
	    void EditFile(ActionEvent event) throws IOException {
		    FXMLLoader fxml=new FXMLLoader(getClass().getResource("EditCours.fxml"));
		    Parent root=fxml.load();
		    
		    gererprof.getChildren().removeAll();
		    gererprof.getChildren().setAll(root);
		    
	    }
	  
	  @FXML
	    void checkPub(ActionEvent event) throws IOException {
		    FXMLLoader fxml=new FXMLLoader(getClass().getResource("ConsulterPub.fxml"));
		    Parent root=fxml.load();
		    
		    gererprof.getChildren().removeAll();
		    gererprof.getChildren().setAll(root);
	    }
	  
}
