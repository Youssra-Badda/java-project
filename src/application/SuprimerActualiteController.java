package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class SuprimerActualiteController implements Initializable
{
    @FXML
    private ComboBox<String> boxS;

    @FXML
    private Label valide;

    @FXML
    void suprimer(MouseEvent event) throws SQLException 
    {
       String titreS=boxS.getValue();
       Connection con =Connexion.connectDb();
       PreparedStatement ps=con.prepareStatement("delete from actualite where titre=?");
       ps.setString(1, titreS);
       if(!ps.execute())
       {
    	   valide.setVisible(true);
       }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		Connection con =Connexion.connectDb();
		try {
			int mx=0;
			PreparedStatement ps=con.prepareStatement("select max(idA) from actualite");
		ResultSet rsl=	ps.executeQuery();
		if (rsl.next())
		{
			mx=rsl.getInt(1);
		}
		 String [] items=new String[mx];
		 PreparedStatement ps2=con.prepareStatement("select titre from actualite");
			ResultSet rsl2=	ps2.executeQuery();
		 int i=0;
			while(rsl2.next())
			{
				items[i]=rsl2.getString(1);
				i++;
			}
			boxS.getItems().addAll(items);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
