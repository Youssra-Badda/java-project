package application;

import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

//import application.LoginController.session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProfBienvenulController implements Initializable {

	
    public Label titre;
	@FXML
	    private ImageView personnel;
    @FXML
    private Text User;
    
    @FXML
    private Pane PaneAffichage;
    
    public int idp=Session.ID;
 
    @FXML
    private ImageView iconProfile;
    
    @FXML
    private ImageView home;
    
    @FXML
    private Button BtnAdd;
    
    @FXML
    private Text Management;
    

    @FXML
    private ImageView etd;
    
    @FXML
    private ImageView cour;
    

    @FXML
    private ImageView proIcon;
     
    @FXML
    private ImageView ActualiteIcon;

    
    
    
    
    Stage stage;
//    @FXML
//    private AnchorPane gererprof;
    
    @FXML
    void afficherProfile(MouseEvent event) throws Exception
    {
    	
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("ProfileProfs.fxml"));
        Parent root=fxml.load();
		
        PaneAffichage.getChildren().removeAll();
        ProfIconController ct=fxml.getController();
		ct.afficheData(idp);
		PaneAffichage.getChildren().setAll(root);
    }
	
    @FXML
    void GoHome(MouseEvent event) throws Exception{
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root=fxml.load(); 
        PaneAffichage.getChildren().removeAll();
        PaneAffichage.getChildren().setAll(root);
    }
    
	
	public void Myfunction(String nomPersonne) {
    	User.setText(nomPersonne);  
	}
	

    

    @FXML
    void coursMng(MouseEvent event) throws IOException {
   
 	    FXMLLoader fxml=new FXMLLoader(getClass().getResource("GererCours.fxml"));
 	    Parent root=fxml.load();
 	    
 	    PaneAffichage.getChildren().removeAll();
 		PaneAffichage.getChildren().setAll(root);
    }
    
    @FXML
    void Logout(MouseEvent event) throws IOException {
      stage =(Stage)  PaneAffichage.getScene().getWindow();
      stage.close();
        
      Parent root=FXMLLoader.load(getClass().getResource("Login.fxml"));
      Scene scene =new Scene(root);
      Stage stage =new Stage();
      stage.setTitle("Login");
      stage.setResizable(false);
      stage.setScene(scene);
      stage.show();
   }
    @FXML
    void CheckPersonnel(MouseEvent event) throws IOException {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("Personnel.fxml"));
 	    Parent root=fxml.load();
 	    
 	    PaneAffichage.getChildren().removeAll();
 		PaneAffichage.getChildren().setAll(root);
    }
	
    @FXML
    void Etudiant(MouseEvent event) throws IOException {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("ConsulterEtudiant.fxml"));
 	    Parent root=fxml.load();
 	    
 	    PaneAffichage.getChildren().removeAll();
 		PaneAffichage.getChildren().setAll(root);
    }
    
    

    @FXML
    void GoProfile(MouseEvent event) throws IOException {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("GererProfil.fxml"));
 	    Parent root=fxml.load();
 	    
 	    PaneAffichage.getChildren().removeAll();
 		PaneAffichage.getChildren().setAll(root);
    }
    
    @FXML
    void Actualite(MouseEvent event) throws IOException {
    	
    			FXMLLoader loader=new FXMLLoader(getClass().getResource("ActualiteView.fxml"));
		        Parent root= loader.load();
		        PaneAffichage.getChildren().removeAll();
		        PaneAffichage.getChildren().setAll(root);
    		
    	
			try {
				ConnectToDataBase db=new ConnectToDataBase();
		Connection	con=db.getConnection();
    		PreparedStatement st =con.prepareStatement("select * from actualite ");
    		ResultSet res =st.executeQuery(); 
           
    		while (res.next()) {
 
         
    			titre.setText("heloo");
    			 PaneAffichage.getChildren().removeAll();
    			 PaneAffichage.getChildren().add(titre);
    			
		        
    		}
    		con.close();
    		
    		
			}catch(SQLException e) {
	    		System.out.println(e.getMessage());
	    	}
			catch(Exception e) {
	    		e.printStackTrace();
	    	}	
    }
    
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = null;
		try {
			root = fxml.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        PaneAffichage.getChildren().removeAll();
        PaneAffichage.getChildren().setAll(root);
    	
	}
    
    
}
