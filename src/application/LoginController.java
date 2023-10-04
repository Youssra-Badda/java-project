package application;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.font.OpenType;
import java.io.IOException;
import java.lang.module.ModuleDescriptor.Exports;
import java.lang.module.ModuleDescriptor.Requires;
import java.sql.*;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;


public class LoginController {
	@FXML
	private   TextField usern;

	@FXML
	private  Button login;

	@FXML
	private   PasswordField passw;
	
	
    
	@FXML
	private  TextField Password;
   
    @FXML
    private CheckBox check;
	
    public  int idp;
    
	String nomPersonne;
	public  Connection con;
	public  ConnectToDataBase db;
	
	@FXML
	public void LoginSystem(ActionEvent event) {

		try{
			db=new ConnectToDataBase();
			con=db.getConnection();

    		PreparedStatement st =con.prepareStatement("select * from login where userName=? and password=? ");
    		st.setString(1,usern.getText());
    		st.setString(2,passw.getText());
    		
    		ResultSet res =st.executeQuery(); 
           
    		if (res.next()) { 
    			idp=res.getInt("idP");
 			   PreparedStatement st2 =con.prepareStatement("select * from personnel where idP="+idp);
 			   ResultSet res2 =st2.executeQuery();
 			  Session.ID=idp;
 			  if (res2.next()) {
    			  if(res2.getInt("status")==0) {

    				    nomPersonne=res2.getString("prenom");
    				  
    		       FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminBienvenue.fxml"));
    		       Parent root= loader.load();
    		       //AdminBienvenueController ctr= loader.getController();
    		      
    		       
//    		       ProfBienvenulController controller=loader.getController();
//    		       controller.Myfunction(nomPersonne);
    		       Scene scene =new Scene(root);
                   Stage stage =new Stage();
                   stage.setScene(scene);
                   stage.show();
    			}else {

     				    nomPersonne=res2.getString("nom").toUpperCase();


     			   FXMLLoader loader=new FXMLLoader(getClass().getResource("Profs.fxml"));
   		           Parent root= loader.load();
   		            ProfBienvenulController controller = loader.getController();
   		            controller.Myfunction(nomPersonne); 
     			    Scene scene =new Scene(root);
                    Stage stage =new Stage();
                    stage.setTitle("Prof page");
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.show();
    			}
 			  }
    		}else {
    			JOptionPane.showMessageDialog(null, "username or password are not  Matched");
    			usern.setText("");
    			passw.setText("");
    		}
    		con.close();
    
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
		catch(Exception e) {
    		e.printStackTrace();
    	}	
		
		 
	}

	
	 @FXML
	    void ShowPassword(ActionEvent event) {
             if(check.isSelected()) {
            	 Password.setText(passw.getText());
            	 Password.setVisible(true);
            	 passw.setVisible(false);
            	 return ;
             }
             passw.setText(Password.getText());
             passw.setVisible(true);
             Password.setVisible(false);
	    }
	 
	 
}

	







