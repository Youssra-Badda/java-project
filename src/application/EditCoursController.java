package application;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class EditCoursController implements Initializable {
	    @FXML
	    private ComboBox<String> Mod;

	    @FXML
	    private TextField Path;


	    @FXML
	    private ComboBox<String> f;

	    @FXML
	    private ImageView filiere;

	    @FXML
	    private ImageView module;

	    @FXML
	    private ImageView niveau;

	    @FXML
	    private ComboBox<String> nv;



	    @FXML
	    private ImageView lien;


	    @FXML
	    private TextField t;


	    @FXML
	    private ImageView Tit;

	    @FXML
	    private TextField tp;

	    @FXML
	    private ImageView type;
     

	    @FXML
	    private Button Add;
	    
        @FXML
        private Text aff;
        ConnectToDataBase db=new ConnectToDataBase();
        Connection con=db.getConnection();
    
    @FXML
    void upFliere(MouseEvent event) throws SQLException, ClassNotFoundException {
    	aff.setText("");
    	String fil=f.getSelectionModel().getSelectedItem();
    	
		PreparedStatement st =con.prepareStatement("UPDATE document SET filiere = '"+fil+"' WHERE idDoc = '1'");  //dynamique
        st.executeUpdate();
        aff.setText("la Modification se fait avec Succes !");
    }
      
    @FXML
    void upModule(MouseEvent event) throws ClassNotFoundException, SQLException {
    	aff.setText("");
    	String M=Mod.getSelectionModel().getSelectedItem().toString();
    	
		PreparedStatement st =con.prepareStatement("UPDATE document SET module = '"+M+"' WHERE idDoc = '1'");
        st.executeUpdate();
        aff.setText("la Modification se fait avec Succes !");
    }

    @FXML
    void upNiveau(MouseEvent event) throws ClassNotFoundException, SQLException {
    	aff.setText("");
    	String NV=nv.getSelectionModel().getSelectedItem().toString();
    	
		PreparedStatement st =con.prepareStatement("UPDATE document SET niveau = '"+NV+"' WHERE idDoc = '1'");
        st.executeUpdate();
        aff.setText("la Modification se fait avec Succes !");
    }

    @FXML
    void upPath(MouseEvent event) throws SQLException, ClassNotFoundException {
    	aff.setText("");
    	String Ph=Path.getText();
    	
		PreparedStatement st =con.prepareStatement("UPDATE document SET path = '"+Ph+"' WHERE idDoc = '1'");
        st.executeUpdate();
        aff.setText("la Modification se fait avec Succes !");
    }

    @FXML
    void upTitre(MouseEvent event) throws ClassNotFoundException, SQLException {
    	aff.setText("");
    	String Titre=t.getText();
    	
		PreparedStatement st =con.prepareStatement("UPDATE document SET titre = '"+Titre+"' WHERE idDoc = '1'");
        st.executeUpdate();
        aff.setText("la Modification se fait avec Succes !");
    }

    @FXML
    void upType(MouseEvent event) throws ClassNotFoundException, SQLException {
    	
    	String Type=tp.getText();
    	
		PreparedStatement st =con.prepareStatement("UPDATE document SET type = '"+Type+"' WHERE idDoc = '1'");
        st.executeUpdate();
        aff.setText("la Modification se fait avec Succes !");
    }
    
    @FXML
    void upFile(ActionEvent event) {
    	 FileChooser fc=new FileChooser();
         
         fc.getExtensionFilters().add(new ExtensionFilter("PDF Files","+.pdf")); 
         File f=fc.showOpenDialog(null);
         if( f != null) {
        
        	 Path.setText(f.getAbsolutePath());
         }
    }
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
        f.setItems(FXCollections.observableArrayList("Cycle Preparatoire Integre","Genie Informatique","Genie Civil","Genie de l'eau et de l'environement","Genie Energetique et Energie Renouvelable","Genie Mecanique","Ingenierie des Donnees"));
		
		nv.setItems(FXCollections.observableArrayList("1","2","3"));
		Mod.setItems(FXCollections.observableArrayList("Algèbre 1 : Algèbre de base ",
				"Analyse 1 : Analyse réelle",
				"Physique 1 : Electrostatique et magnétostatique",
				"Mécanique 1 : Mécanique du point",
				"Informatique 1 : Initiation à l’informatique",
				"Langues et communications 1 : TEC Français & TEC Anglais",
				"Algèbre 2 : Algèbre linéaire",
				"Analyse 2 : Equations différentielles et séries",
				"Physique 2 : Optique",
				"Chimie 1 : Atomistique & Liaisons chimiques",
				"Géologie : Géologie générale",
				"Langues et communications 2 : TEC Français & TEC Anglais",
				"Algèbre 3 : Algèbre quadratique",
				"Analyse 3 : Fonctions de plusieurs variables",
				"Physique 3 : Electrocinétique et Electromagnétisme",
				"Mécanique 2 : Mécanique du solide",
				"Informatique 2 : Programmation C",
				"Langues et communications 3 : TEC Français & TEC Anglais",
				"GI1-S1-Langage C avancé et structures de données",
				"GI1-S1-Architecture des ordinateurs",
				"GI1-S1-Recherche opérationnelle et théorie des graphes",
				"GI1-S1-Systèmes d’Information et Bases de Données Relationnelles",
				"GI1-S1-Réseaux informatiques",
				"GI1-S1-Langues et Communication Professionnelles 1",
				"GI1-S1-Architecture Logicielle et UML",
				"GI1-S2-Web1 : Technologies de Web et PHP5",
				"GI1-S2-Programmation Orientée Objet C++",
				"GI1-S2-Théorie des langages et compilation",
				"GI1-S2-Algorithmique Avancée et complexité",
				"GI1-S2-Entreprenariat 1 & Atelier Start up",
				"GI2-S3-Python pour les sciences de données",
				"GI2-S3-Programmation Java Avancée",
				"GI2-S3-Langues et Communication Professionnelle 2 & Soft Skils",
				"GI2-S3-Linux et programmation système",
				"GI2-S3-Administration des Bases de données Avancées",
				"GI2-S3-Administration réseaux et systèmes",
				"GI2-S4-Entreprenariat 2",
				"GI2-S4-Machine Learning",
				"GI2-S4-Gestion de projet et Génie logiciel",
				"GI2-S4-Crypto-systèmes et sécurité Informatique",
				"GI2-S4-Frameworks Java EE avancés et .Net",
				"GI2-S4-Web 2 : Applications Web modernes",
				"GI3-GL-Développement des applications mobiles",
				"GI3-GL-Virtualisation et Cloud Computing",
				"GI3-GL-Enterprise Resource Planning ERP",
				"GI3-GL-Ingénierie logicielle, Qualité, Test et Intégration",
				"GI3-GL-Entreprenariat 3",
				"GI3-GL-Système embarqué et temps réel",
				"GI3-BI-Entreprenariat 3",
				"GI3-BI-Analyse et conception des systèmes décisionnels",
				"GI3-BI-nterprise Resource Planning ERP",
				"GI3-BI-Ingénierie de l’information et des connaissances",
				"GI3-BI-Business Intelligence et Veille Stratégique",
				"GI3-BI-Data Mining"
				));
		
	}
}
