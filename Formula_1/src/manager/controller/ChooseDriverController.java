package manager.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.model.formulaApplication;

public class ChooseDriverController extends Controller implements Initializable
{
	// Background
	@FXML
	private AnchorPane root;
	@FXML
	private ImageView background;
	
	// Scene elements
	@FXML
	private ImageView next;
	
	@FXML
	private Rectangle alonso, bottas, button, ericsson, grosjean, gutierrez, hamilton, haryanto, hulkenberg, kvyat, magnussen, massa, nasr, palmer, perez, raikkonnen, ricciardo, rosberg, sainz, verstappen, vettel, wehrlein;

	// Color variables
	Color teamSelectedColor = new Color(0, 0, 0, .26);
	Color teamNotSelectedColor = new Color(0, 0, 0, 0);
	
	Rectangle currentlySelected = null;
	Rectangle previouslySelected = null;
	
	String currentlySelectedString = "";
	String previouslySelectedString = "";
	ArrayList<String> drivers = new ArrayList<>();
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());
		currentlySelected = alonso;
		previouslySelected = massa;
		// Click
		
		
		next.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "Dashboard", (Stage) next.getScene().getWindow());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		// Hover on
		next.setOnMouseEntered(event -> {
			next.setImage(new Image("file:images/menu/NextHover.png"));
		});
		// Hover off
		next.setOnMouseExited(event -> {
			next.setImage(new Image("file:images/menu/Next.png"));
		});
		
		// Team Choices
		alonso.setOnMousePressed(event -> {
			selectDriver(alonso, "Fernando Alonso");
		});
		bottas.setOnMousePressed(event -> {
			selectDriver(bottas, "Valtteri Bottas");
		});
		button.setOnMousePressed(event -> {
			selectDriver(button, "Jensen Button");
		});
		ericsson.setOnMousePressed(event -> {
			selectDriver(ericsson, "Marcus Ericsson");
		});
		grosjean.setOnMousePressed(event -> {
			selectDriver(grosjean, "Romain Grosjean");
		});
		gutierrez.setOnMousePressed(event -> {
			selectDriver(gutierrez, "Esteban Gutierrez");
		});
		hamilton.setOnMousePressed(event -> {
			selectDriver(hamilton, "Lewis Hamilton");
		});
		haryanto.setOnMousePressed(event -> {
			selectDriver(haryanto, "Rio Haryanto");
		});
		hulkenberg.setOnMousePressed(event -> {
			selectDriver(hulkenberg, "Nicolas Hulkenberg");
		});
		kvyat.setOnMousePressed(event -> {
			selectDriver(kvyat, "Daniil Kvyat");
		});
		magnussen.setOnMousePressed(event -> {
			selectDriver(magnussen, "Kevin Magnussen");
		});	
		massa.setOnMousePressed(event -> {
			selectDriver(massa, "Felipe Massa");
		});	
		nasr.setOnMousePressed(event -> {
			selectDriver(nasr, "Felipe Nasr");
		});
		
		palmer.setOnMousePressed(event -> {
			selectDriver(palmer, "Jolyon Palmer");
		});	
		
		perez.setOnMousePressed(event -> {
			selectDriver(perez, "Sergio Perez");
		});	
		
		raikkonnen.setOnMousePressed(event -> {
			selectDriver(raikkonnen, "Kimi Raikkonnen");
		});	
		
		ricciardo.setOnMousePressed(event -> {
			selectDriver(ricciardo, "Daniel Ricciardo");
		});	
		
		rosberg.setOnMousePressed(event -> {
			selectDriver(rosberg, "Nico Rosberg");
		});	
		
		sainz.setOnMousePressed(event -> {
			selectDriver(sainz, "Carloz Sainz Jr.");
		});	
		
		verstappen.setOnMousePressed(event -> {
			selectDriver(verstappen, "Max Verstappen");
		});	
		
		vettel.setOnMousePressed(event -> {
			selectDriver(vettel, "Sebastian Vettel");
		});	
		
		wehrlein.setOnMousePressed(event -> {
			selectDriver(wehrlein, "Pascal Wehrlein");
		});	
	}
	
	private void selectDriver(Rectangle driverButton, String driverName){
		driverButton.setStyle("-fx-fill: rgba(0,0,0,0.26);");
		
		if (!(currentlySelected.equals(null)))
		{
			//currentlySelected.setFill(teamNotSelectedColor);
			currentlySelected.setStyle("-fx-fill: rgba(0,0,0,0);");
			previouslySelected.setStyle("-fx-fill: rgba(0,0,0,0);");
		}
		
		previouslySelected = currentlySelected;
		previouslySelectedString = currentlySelectedString;
		
		currentlySelected = driverButton;
		currentlySelectedString = driverName;
		
		if (drivers.size() == 0) {
			drivers.add(currentlySelectedString);
		}
		else if (drivers.size() == 1) {
			drivers.add(currentlySelectedString);	
		}
		
		else if (drivers.size() == 2) {
			drivers.set(0, drivers.get(1));
			drivers.set(1, currentlySelectedString);
		}
		
		if (!(currentlySelected.equals(null)))
		{
			//currentlySelected.setFill(teamNotSelectedColor);
			currentlySelected.setStyle("-fx-fill: rgba(0,0,0,0);");
			previouslySelected.setStyle("-fx-fill: rgba(0,0,0,0);");
		}
		//teamButton.setFill(teamSelectedColor);
		
		
		/*
		if (!(currentlySelected.equals(null)))
		{
			//currentlySelected.setFill(teamNotSelectedColor);
			currentlySelected.setStyle("-fx-fill: rgba(0,0,0,0);");
		}
		//teamButton.setFill(teamSelectedColor);
		driverButton.setStyle("-fx-fill: rgba(0,0,0,0.26);");
		currentlySelected = driverButton;
		currentlySelectedString = driverName;
		System.out.println(drivers.length);
		*/
	}
	
	public void setSelected(Rectangle driverButton)
	{
		driverButton.setStyle("-fx-fill: rgba(0,0,0,0.26);");
	}
	
	public void setUnSelected(Rectangle driver)
	{
		
	}
	
	
}
