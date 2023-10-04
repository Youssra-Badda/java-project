package application;

import java.awt.Desktop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.mysql.cj.result.Row;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class EtudiantController implements Initializable {
	  @FXML
	    private TableColumn<Etudiant, String> CNE;

	    @FXML
	    private TableColumn<Etudiant, String> emailA;

	    @FXML
	    private TableColumn<Etudiant, String> emailP;

	    @FXML
	    private TableColumn<Etudiant, String> nom;

	    @FXML
	    private TableColumn<Etudiant, String> prenom;

	    @FXML
	    private TableView<Etudiant> tableEtudiant;
	    
	   
	    
	    public ObservableList<Etudiant> data =FXCollections.observableArrayList();
		
	    public void openFile(String file) {
	    	try {
	    		File path=new File(file);
	    		Desktop.getDesktop().open(path);
	    	}catch(IOException ioe) {
	    		ioe.getMessage();
	    	}
	    }
	    

		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			try {
		    	
		    	
		    	ConnectToDataBase db=new ConnectToDataBase();
		    	Connection con=db.getConnection();
				PreparedStatement st =con.prepareStatement("select * from etudiant ");  //khasha tkon where idp=...
		        ResultSet res=st.executeQuery();
		        
		        while(res.next()) {//res.getInt(1),
		        	
		        	
		             data.add(new Etudiant(res.getString(6),res.getString(2), res.getString(3), res.getString(4),res.getString(5)));
		             tableEtudiant.setItems(data);
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
			emailA.setCellValueFactory(new PropertyValueFactory<>("emailA"));	
			emailP.setCellValueFactory(new PropertyValueFactory<>("emailP"));
			CNE.setCellValueFactory(new PropertyValueFactory<>("CNE"));
			tableEtudiant.setItems(data);
			
		}

}
