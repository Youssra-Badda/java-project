package application;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class AdminBienvenueController  implements Initializable {
	    @FXML
	    private AnchorPane centre;
	    @FXML
	    private Label label;
	    @FXML
	    private Label nomprenom;
//	    @FXML
//	    private LineChart<?, ?> corps;
public int idp=Session.ID;


	    @FXML
	    void afficherProfile(MouseEvent event) throws Exception
	    {
	    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("ProfileAdmin.fxml"));
            Parent root=fxml.load();
			
			centre.getChildren().removeAll();
			ProfileAdminController ct=fxml.getController();
			ct.afficheData(idp);
			centre.getChildren().setAll(root);
	    }

	    @FXML
	    void gererCompte(MouseEvent event) throws IOException 
	    {
	    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("GererProfile.fxml"));
            Parent root=fxml.load(); 
            centre.getChildren().removeAll();
            centre.getChildren().setAll(root);
	    }
	    
	    @FXML
	    void consulterProf(MouseEvent event) throws IOException, SQLException {
	    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("DataProf.fxml"));
            Parent root=fxml.load();
			
			centre.getChildren().removeAll();
			DataProfController ct=fxml.getController();
			ct.DtaProf();
			centre.getChildren().setAll(root);
	    } 
	    @FXML
	    void gererProf(MouseEvent event) throws IOException 
	    {
	    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("GererProf.fxml"));
            Parent root=fxml.load(); 
            centre.getChildren().removeAll();
            centre.getChildren().setAll(root);
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) 
		{
			
			Connection con=Connexion.connectDb();
			try {
				PreparedStatement ps=con.prepareStatement("select nom,prenom from personnel where idP=?");
				ps.setInt(1, idp);
				ResultSet rsl=ps.executeQuery();
				if(rsl.next())
				{
					String nom=rsl.getString(1);
					//String prenom=rsl.getString(2);
					//String nb=nom+" "+prenom;
					nomprenom.setText(nom.toUpperCase());
					System.out.println(idp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FXMLLoader fxml=new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = null;
			try {
				root = fxml.load();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
            centre.getChildren().removeAll();
            centre.getChildren().setAll(root);
	
		}

		    @FXML
		    void gererActualiter(MouseEvent event) throws IOException 
		    {
		    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("GererActualite.fxml"));
	            Parent root=fxml.load(); 
	            centre.getChildren().removeAll();
	            centre.getChildren().setAll(root);
		    }
		    
		    @FXML
		    void gohome(MouseEvent event) throws IOException {
		    	FXMLLoader fxml=new FXMLLoader(getClass().getResource("Home.fxml"));
	            Parent root=fxml.load(); 
	            centre.getChildren().removeAll();
	            centre.getChildren().setAll(root);
		    }

		    @FXML
		    void deconecter(MouseEvent event) throws IOException
		    {
		    	Stage	stage =(Stage)  centre.getScene().getWindow();
		        stage.close();
		          
		        Parent root=FXMLLoader.load(getClass().getResource("Login.fxml"));
		        Scene scene =new Scene(root);
		        Stage stage2 =new Stage();
		        stage2.setTitle("Login");
		        stage2.setResizable(false);
		        stage2.setScene(scene);
		        stage2.show();
		    }
	}

