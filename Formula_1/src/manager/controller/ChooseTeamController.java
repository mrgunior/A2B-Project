package manager.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.model.formulaApplication;

public class ChooseTeamController extends Controller implements Initializable
{
	// Background
	@FXML
	private AnchorPane root;
	@FXML
	private ImageView background;
	
	// Scene elements
	@FXML
	private ImageView back;
	@FXML
	private Text next;
	
	// Team buttons
	@FXML
	private Rectangle mercedes, redBull, ferrari, forceIndia, williams, mcLaren, toroRosso, haas, renault, sauber, manor;

	// Color variables
	Color teamSelectedColor = new Color(0, 0, 0, .26);
	Color teamNotSelectedColor = new Color(0, 0, 0, 0);
	
	// Selector variable
	Rectangle currentlySelected;
	String currentlySelectedString;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());
		currentlySelected = mercedes;
		
		// Click
		next.setOnMousePressed(event -> {
			try
			{
				System.out.println(currentlySelectedString);
				formulaApplication.setTeamName(currentlySelectedString);
				gotoFxmlScene(event, "ChooseDriver", (Stage) next.getScene().getWindow());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		// Hover on
		next.setOnMouseEntered(event -> {
			//next.setImage(new Image("file:images/menu/NextHover.png"));
		});
		// Hover off
		next.setOnMouseExited(event -> {
			//next.setImage(new Image("file:images/menu/Next.png"));
		});
		
		// Team Choices
		mercedes.setOnMousePressed(event -> {
			currentlySelected.setFill(teamNotSelectedColor);
			mercedes.setFill(teamSelectedColor);
			currentlySelected = mercedes;
			currentlySelectedString = "Mercedes AMG Petronas";
		});
		redBull.setOnMousePressed(event -> {
			currentlySelected.setFill(teamNotSelectedColor);
			redBull.setFill(teamSelectedColor);
			currentlySelected = redBull;	
			currentlySelectedString = "Red Bull Racing";
		});
		ferrari.setOnMousePressed(event -> {
			currentlySelected.setFill(teamNotSelectedColor);
			ferrari.setFill(teamSelectedColor);
			currentlySelected = ferrari;
			currentlySelectedString = "Scuderia Ferrari";
		});
		forceIndia.setOnMousePressed(event -> {
			currentlySelected.setFill(teamNotSelectedColor);
			forceIndia.setFill(teamSelectedColor);
			currentlySelected = forceIndia;
			currentlySelectedString = "Sahara Force India F1";
		});
		williams.setOnMousePressed(event -> {
			currentlySelected.setFill(teamNotSelectedColor);
			williams.setFill(teamSelectedColor);
			currentlySelected = williams;
			currentlySelectedString = "Williams Martini Racing";
		});
		mcLaren.setOnMousePressed(event -> {
			currentlySelected.setFill(teamNotSelectedColor);
			mcLaren.setFill(teamSelectedColor);
			currentlySelected = mcLaren;
			currentlySelectedString = "McLaren Honda";
		});
		toroRosso.setOnMousePressed(event -> {
			currentlySelected.setFill(teamNotSelectedColor);
			toroRosso.setFill(teamSelectedColor);
			currentlySelected = toroRosso;
			currentlySelectedString = "Scuderia Toro Rosso";
		});
		haas.setOnMousePressed(event -> {
			currentlySelected.setFill(teamNotSelectedColor);
			haas.setFill(teamSelectedColor);
			currentlySelected = haas;
			currentlySelectedString = "Haas F1 Team";
		});
		renault.setOnMousePressed(event -> {
			currentlySelected.setFill(teamNotSelectedColor);
			renault.setFill(teamSelectedColor);
			currentlySelected = renault;
			currentlySelectedString = "Renault";
		});
		sauber.setOnMousePressed(event -> {
			currentlySelected.setFill(teamNotSelectedColor);
			sauber.setFill(teamSelectedColor);
			currentlySelected = sauber;
			currentlySelectedString = "Sauber F1 Team";
		});
		manor.setOnMousePressed(event -> {
			currentlySelected.setFill(teamNotSelectedColor);
			manor.setFill(teamSelectedColor);
			currentlySelected = manor;
			currentlySelectedString = "Manor Racing";
		});	
	}
}
