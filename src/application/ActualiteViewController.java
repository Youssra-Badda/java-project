package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ActualiteViewController implements Initializable{
	String t;
	String c;
	String d;

	
    @FXML
    private AnchorPane centre;
	@FXML
	private ListView myList;
    List Titre =new ArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			ConnectToDataBase db=new ConnectToDataBase();
			Connection con=db.getConnection();
    		PreparedStatement st =con.prepareStatement("select * from actualite ");
    		ResultSet res =st.executeQuery(); 
    		while(res.next()) {
    			Titre.add(res.getString(2));
    			
    		}
    		myList.getItems().addAll(Titre);
    		
		}catch(Exception e) {
			e.getMessage();
		}
	}
    @FXML
    void click(MouseEvent event) throws SQLException, IOException {
    	String item=(String) myList.getSelectionModel().getSelectedItem();
    	ConnectToDataBase db=new ConnectToDataBase();
		Connection con=db.getConnection();
		PreparedStatement st =con.prepareStatement("select * from actualite where titre =? ");
		st.setString(1, item);
		ResultSet res =st.executeQuery(); 
		if(res.next())
		{
			t=res.getString(2);
			c=res.getString(3);
			d=res.getString(5);
		}
		FXMLLoader loader=new FXMLLoader(getClass().getResource("Actualite.fxml"));
        Parent root= loader.load();
        ActualiteController d2=loader.getController();
        d2.aficher(t,c,d);
        centre.getChildren().removeAll();
       centre.getChildren().setAll(root);

    }
   
}
