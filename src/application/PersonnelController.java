package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



public class PersonnelController implements Initializable{

	

	    @FXML
	    private TableColumn<Personnel, String> email;

	    @FXML
	    private TableColumn<Personnel, String> nom;

	    @FXML
	    private TableColumn<Personnel, String> prenom;

	    @FXML
	    private TableView<Personnel> tablepersonnel;

	    public ObservableList<Personnel> data =FXCollections.observableArrayList();
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
	    	
	    	
	    	ConnectToDataBase db=new ConnectToDataBase();
	    	Connection con=db.getConnection();
			PreparedStatement st =con.prepareStatement("select * from personnel ");  //khasha tkon where idp=...
	        ResultSet res=st.executeQuery();
	        
	        while(res.next()) {//res.getInt(1),
	        	System.out.println(res.getInt(1));
	             data.add(new Personnel(res.getString(2), res.getString(3), res.getString(6)));
	        	tablepersonnel.setItems(data);
	        }
	        con.close();
	    }catch(SQLException E) {
    		System.out.println(E.getMessage());
    	}
		catch(Exception e) {
    		e.printStackTrace();
    	}
	    
		nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		email.setCellValueFactory(new PropertyValueFactory<>("email"));	
		tablepersonnel.setItems(data);
		
	}

}
