package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class changeMotPassController
{
	public int idp=Session.ID;
	@FXML
    private Label BienValide;
	 @FXML
	    private PasswordField NvPassword;

	    @FXML
	    private PasswordField confermePassword;
	    @FXML
	    private PasswordField password;

	    @FXML
	    private Pane confirmerMP;

	    @FXML
	    private Label erreur;
	    @FXML
	    private Pane verifierMP;
	    

    @FXML
    void valider(MouseEvent event) throws SQLException 
    {
    	 confirmerMP.setVisible(false);
		 verifierMP.setVisible(false);
    	BienValide.setVisible(false);
         Connection con =Connexion.connectDb();
         PreparedStatement p=con.prepareStatement("select password from login where idP="+idp);
         ResultSet res=p.executeQuery();
         if(res.next())
         {
        	 String v1=res.getString("password");
        	 String v2=password.getText();
        	 if(v1.compareTo(v2)!=0)
        	 {
        		 verifierMP.setVisible(true);
        		
        	 }
        	 else if (NvPassword.getText().compareTo(confermePassword.getText())!=0)
        	 {
        		 confirmerMP.setVisible(true);
        		 
        	 }
        	 else {
        		
        		 confirmerMP.setVisible(false);
        		 verifierMP.setVisible(false);
        		 String query = "update login set password= ? where idP= ?";
        	        PreparedStatement preparedStmt = con.prepareStatement(query);
        	        preparedStmt.setString   (1, NvPassword.getText());
        	        preparedStmt.setInt(2, idp);

        	        // execute the java preparedstatement
        	        preparedStmt.executeUpdate();
        	        BienValide.setVisible(true);
        	        
        	 }
        	 
         }
    }
}
