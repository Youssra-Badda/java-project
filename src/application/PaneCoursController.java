package application;

import javafx.scene.control.TextField;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
public class PaneCoursController implements Initializable {
	

    @FXML
    private Button Add;

    @FXML
    private Button submit;
	
    @FXML
    private TextField Path;
	
    @FXML
    private TextField titre;

    @FXML
    private TextField type;
    
    @FXML
    private ComboBox<String> filiere;

    @FXML
    private ComboBox<String> niveau;
    
    @FXML
    private ComboBox<String> Module;
    

    @FXML
    private Label valid;
    
    @FXML
    void submitBtn(ActionEvent event) {
    	try {
    		String tr=titre.getText();
    		String tp=type.getText();
    		String ph=Path.getText();
    		String f=filiere.getSelectionModel().getSelectedItem().toString();
    		String nv=niveau.getSelectionModel().getSelectedItem().toString();
    		String mod=Module.getSelectionModel().getSelectedItem().toString();
              System.out.println(f);
    		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/personelensah","root","root");
		PreparedStatement st =con.prepareStatement("insert into document (titre,type,path,idP,filiere,niveau,module) values (?,?,?,?,?,?,?)");
		st.setString(1, tr);
		st.setString(2, tp);
		st.setString(3, ph);
		st.setInt(4, 1);             //khas tkon dynamique 
		st.setString(5, f);
		st.setString(6, nv);
		st.setString(7, mod);

		int res =st.executeUpdate();
//		JOptionPane.showMessageDialog(null, "Enregistrement effectué avec succès");
        titre.setText("");
        type.setText("");
        Path.setText("");
        filiere.setValue("");
        niveau.setValue("");
        Module.setValue("");
        valid.setVisible(true);
		con.close();
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
		catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    @FXML
    void AddFile(ActionEvent event) {
    	 FileChooser fc=new FileChooser();
         
         fc.getExtensionFilters().add(new ExtensionFilter("PDF Files","+.pdf")); 
         File f=fc.showOpenDialog(null);
         if( f != null) {
        
        	   Path.setText(f.getAbsolutePath());
         }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		filiere.setItems(FXCollections.observableArrayList("Cycle Preparatoire Integre","Genie Informatique","Genie Civil","Genie de l'eau et de l'environement","Genie Energetique et Energie Renouvelable","Genie Mecanique","Ingenierie des Donnees"));
		
		niveau.setItems(FXCollections.observableArrayList("1","2","3"));
		Module.setItems(FXCollections.observableArrayList("Algèbre 1 : Algèbre de base ",
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
