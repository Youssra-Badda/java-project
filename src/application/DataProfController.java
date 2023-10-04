package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DataProfController implements Initializable
{
	  @FXML
	    private TableColumn<Prof, String> addresse;

	    @FXML
	    private TableColumn<Prof, String> date;

	    @FXML
	    private TableColumn<Prof, String> emailc;

	    @FXML
	    private TableColumn<Prof, String>emailp;

	    @FXML
	    private TableColumn <Prof, String> nom;

	    @FXML
	    private TableColumn <Prof, String> ppr;

	    @FXML
	    private TableColumn <Prof, String> prenom;

	    @FXML
	    private TableView<Prof> table;

	    @FXML
	    private TableColumn<Prof, String> tel;
	
	public ObservableList<Prof> data=FXCollections.observableArrayList();
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
}
	public void DtaProf() throws SQLException
	{
		System.out.println("fct");
		Connection con =Connexion.connectDb();
		PreparedStatement ps=con.prepareStatement("select * from personnel where Status=1");
		 ResultSet rsl= ps.executeQuery();
		 while(rsl.next())
		 {
			
			 data.add(new Prof(rsl.getString("nom"),rsl.getString("prenom"),rsl.getString("emailAcademique"),rsl.getString("emailPersonnel"),rsl.getString("adresse"),rsl.getString("tele"),rsl.getString("dateEmploye"),rsl.getString("PPR")));
		     System.out.println("while");
		 }
			nom.setCellValueFactory(new PropertyValueFactory<Prof,String>("nom"));
		    prenom.setCellValueFactory(new PropertyValueFactory<Prof,String>("prenom"));
		    addresse.setCellValueFactory(new PropertyValueFactory<Prof,String>("adresse"));
		   tel.setCellValueFactory(new PropertyValueFactory<Prof,String>("tel"));
		   ppr.setCellValueFactory(new PropertyValueFactory<Prof,String>("ppr"));
		   date.setCellValueFactory(new PropertyValueFactory<Prof,String>("date"));
		   emailp.setCellValueFactory(new PropertyValueFactory<Prof,String>("emailp"));
		   emailc.setCellValueFactory(new PropertyValueFactory<Prof,String>("emailc"));
		   table.setItems(data);

	}

}
