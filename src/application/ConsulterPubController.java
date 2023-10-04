package application;

import java.io.IOException;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.print.DocFlavor.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class ConsulterPubController  implements Initializable  {
	public int idp=Session.ID;
    @FXML
    private TableColumn ColEdit;

    @FXML
    private TableView<Cours> TableCours;

    @FXML
    private TableColumn<Cours, String> date;

    @FXML
    private TableColumn<Cours, Integer> idDoc;

    @FXML
    private TableColumn<Cours, String> mod;

    @FXML
    private TableColumn<Cours, String> niv;

    @FXML
    private TableColumn<Cours, String> profs;

    @FXML
    private AnchorPane tablePane;

    @FXML
    private TableColumn<Cours, String> titre;

    @FXML
    private TableColumn<Cours, String> type;

    @FXML
    private TableColumn<Cours, String> file;
    

    @FXML
    private ImageView refresh;
    
    public String  profLname;
    public String  profname;
    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date dateJ = new Date();
    String  d =s.format(dateJ);

    public ObservableList<Cours> data =FXCollections.observableArrayList(); 
   

    @FXML
    private void refreshTable(MouseEvent event) {
        try {
            data.clear();
            ConnectToDataBase db=new ConnectToDataBase();
            Connection con=db.getConnection();
            PreparedStatement st= con.prepareStatement("SELECT * FROM document ");
            ResultSet res = st.executeQuery();
            
            while (res.next()){
				data.add(new Cours(
						res.getString(2),
						res.getString(3),
						profLname + " " + profname,
						res.getInt(1),
						res.getString(4),
						res.getString(6) + "-" + res.getString(7), 
						res.getString(8),
						d));
                TableCours.setItems(data);
                
            }
            
            
        } catch (SQLException ex) {
//        	Logger.getLogger(ConsulterPubController.class.getName()).log(Level.SEVERE,null,ex);
        	ex.getMessage();
        }
    }
    

	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) { 
           try {
	    	
	    	
			ConnectToDataBase db=new ConnectToDataBase();
	    	Connection con=db.getConnection();
			PreparedStatement st =con.prepareStatement("select * from document where idP="+idp);  //khasha tkon where idp=...
	        ResultSet res=st.executeQuery();
	        PreparedStatement st1 =con.prepareStatement("select nom , prenom from personnel where idP="+idp); 
	        ResultSet res1=st1.executeQuery();
	        if(res1.next()) {
	        	  profLname=res1.getString("nom");
	        	   profname=res1.getString("prenom");
	        }
	        while(res.next()) {//res.getInt(1),
	        	//System.out.println(res.getInt(1));
	        	data.add(new Cours(res.getString(2),res.getString(3),profLname+" "+profname,res.getInt(1),res.getString(4),res.getString(6)+"-"+res.getString(7),res.getString(8),d));
	        	 TableCours.setItems(data);
	        }
	        con.close();
	    }catch(SQLException E) {
    		System.out.println(E.getMessage());
    	}
		catch(Exception e) {
    		e.printStackTrace();
    	}
	    
		idDoc.setCellValueFactory(new PropertyValueFactory<>("id"));
		titre.setCellValueFactory(new PropertyValueFactory<Cours,String>("titre"));
		type.setCellValueFactory(new PropertyValueFactory<Cours,String>("type"));	
		profs.setCellValueFactory(new PropertyValueFactory<Cours,String>("profs"));
		niv.setCellValueFactory(new PropertyValueFactory<Cours,String>("niveau"));
		mod.setCellValueFactory(new PropertyValueFactory<Cours,String>("module"));
		file.setCellValueFactory(new PropertyValueFactory<Cours,String>("file"));
		date.setCellValueFactory(new PropertyValueFactory<Cours,String>("date"));
		
		//lets create  a cell factory to insert a button in every row
		Callback<TableColumn<Cours,String>,TableCell<Cours,String>> cellFactory =(param)->{
			final TableCell<Cours,String>cell=new TableCell<Cours,String>(){
				
				@Override
				public void updateItem(String item,boolean empty) {
					super.updateItem(item, empty);
					//ensure that cell is created only on non-empty rows
					if(empty) {
						setGraphic(null);
						setText(null);
					}else {
						//now we can create the action button
						final Button editButton=new Button("Edit");
						final Button deleteButton=new Button("Del"); //zzz
						//attach listner on button what to do when clicked
						editButton.setOnAction(event ->{
				//		editButton.setOnMouseClicked((MouseEvent event) -> {
							//Extract the clicked cours object
							Cours c=getTableView().getItems().get(getIndex());
							
							    try {
							    FXMLLoader fxml=new FXMLLoader(getClass().getResource("EditCours.fxml"));
							    Parent root=fxml.load();
							    
							    tablePane.getChildren().removeAll();
							    tablePane.getChildren().setAll(root);
							    }catch(IOException e) {
							    	e.getMessage();
							    }
							
							
							
						});
						
						deleteButton.setOnAction(event ->{
				//		deleteButton.setOnMouseClicked((MouseEvent event) -> {
	                            
	                            try {
	                                Cours c = getTableView().getItems().get(getIndex());
	                                int id= c.getId();
	                                ConnectToDataBase db=new  ConnectToDataBase();
	                                Connection con=db.getConnection();
	                                PreparedStatement st= con.prepareStatement("DELETE FROM document WHERE idDoc  ='"+id+"'"); //"+c.getId()+"
	                                st.executeUpdate();
//	                                refreshTable();
	                                
	                            } catch (SQLException ex) {
	                               
//	                                Logger.getLogger(ConsulterPubController.class.getName()).log(Level.SEVERE,null,ex);
	                           ex.getMessage();
	                            }
						});
						HBox managebtn = new HBox(editButton, deleteButton);
						 managebtn.setStyle("-fx-alignment:center");
	                        HBox.setMargin(deleteButton, new Insets(2, 2, 0, 3));
	                        HBox.setMargin(editButton, new Insets(2, 3, 0, 2));
	                       
						setGraphic(managebtn);
						setText(null);
					}
				
				}
				
			};
			return cell;
		};
		
		
		
		ColEdit.setCellFactory(cellFactory);
	
		
		
		TableCours.setItems(data);
		
	}
    

}
