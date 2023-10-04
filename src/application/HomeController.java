package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable
{
	
    @FXML
    private AnchorPane centre;

    @FXML
    private LineChart<?, ?> corps;

    @FXML
    private Label nomprenom1;

    @FXML
    private Label nomprenom12;

   
    @FXML
    void GoogleEnsah(MouseEvent event) throws IOException
 {
	Desktop ds=Desktop.getDesktop();
	ds.browse(java.net.URI.create("https://ensah.ma/#"));
    }

    @FXML
    void FbEnsah(MouseEvent event) throws IOException 
    {
    	Desktop ds=Desktop.getDesktop();
		ds.browse(java.net.URI.create("https://www.facebook.com/ensaalhoceima/"));  
    }

    @FXML
    void LinkdinEnsah(MouseEvent event) throws IOException 
    {
    	Desktop ds=Desktop.getDesktop();
		ds.browse(java.net.URI.create("https://www.linkedin.com/school/ecole-nationale-des-sciences-appliquees-dal-hoceima/"));
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		XYChart.Series s=new XYChart.Series();
		s.setName("color0");
		s.getData().add(new XYChart.Data("2008",0));
		s.getData().add(new XYChart.Data("2010",200));
		s.getData().add(new XYChart.Data("2012",300));
		s.getData().add(new XYChart.Data("2014",500));
		s.getData().add(new XYChart.Data("2016",900));
		s.getData().add(new XYChart.Data("2018",1200));
		s.getData().add(new XYChart.Data("2020",1600));
		s.getData().add(new XYChart.Data("2022",2200));
		
		corps.getData().addAll(s);
		corps.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent;");
		s.getNode().setStyle("-fx-stroke: #ffffff");

		
	}
}

