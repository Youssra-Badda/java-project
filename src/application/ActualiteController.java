package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ActualiteController  implements Initializable {
  
String titre2 ;
    @FXML
    private Text contenu;

    @FXML
    private Label date;

    @FXML
    private Label titre;
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
		        
    		}
		public void aficher(String t,String c,String d)
		{
			titre.setText(t);
			contenu.setText(c);
			date.setText("publiée le : "+d);
		}
		
    
 
	
	}



		


