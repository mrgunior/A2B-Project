package manager.GUIController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.controller.SceneLoadController;
import manager.model.formulaApplication;

public class ChooseTeamController extends SceneLoadController implements Initializable
{
	// Background
	@FXML
	private AnchorPane	root;
	@FXML
	private ImageView	background;

	// Scene elements
	@FXML
	private ImageView	back;
	@FXML
	private ImageView	next;

	// Team buttons
	@FXML
	private Pane mercedes, redBull, ferrari, forceIndia, williams, mcLaren, toroRosso, haas, renault, sauber,
			manor;

	// Color variables
	Color	teamSelectedColor		= new Color(0, 0, 0, .26);
	Color	teamNotSelectedColor	= new Color(0, 0, 0, 0);

	// Selector variable
	Pane	currentlySelected		= null;
	String		currentlySelectedString	= "";

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());
		
		currentlySelected = mercedes;
		currentlySelectedString = "Mercedes AMG Petronas";
		setSelected(mercedes);

		// Click
		next.setOnMousePressed(event -> {
			try
			{
				if (!(currentlySelectedString.equals("")))
				{
					// where team is being set in the Profile object
					formulaApplication.setTeamName(currentlySelectedString);
					gotoFxmlScene("ChooseDriver", (Stage) next.getScene().getWindow());
				}
			}

			catch (IOException e)
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
		mercedes.setOnMousePressed(event -> {
			teamClicked(mercedes, "Mercedes AMG Petronas");
		});
		redBull.setOnMousePressed(event -> {
			teamClicked(redBull, "Red Bull Racing");
		});
		ferrari.setOnMousePressed(event -> {
			teamClicked(ferrari, "Scuderia Ferrari");
		});
		forceIndia.setOnMousePressed(event -> {
			teamClicked(forceIndia, "Sahara Force India F1");
		});
		williams.setOnMousePressed(event -> {
			teamClicked(williams, "Williams Martini Racing");
		});
		mcLaren.setOnMousePressed(event -> {
			teamClicked(mcLaren, "McLaren Honda");
		});
		toroRosso.setOnMousePressed(event -> {
			teamClicked(toroRosso, "Scuderia Toro Rosso");
		});
		haas.setOnMousePressed(event -> {
			teamClicked(haas, "Haas F1 Team");
		});
		renault.setOnMousePressed(event -> {
			teamClicked(renault, "Renault");
		});
		sauber.setOnMousePressed(event -> {
			teamClicked(sauber, "Sauber F1 Team");
		});
		manor.setOnMousePressed(event -> {
			teamClicked(manor, "Manor Racing");
		});
	}

	private void teamClicked(Pane teamButton, String teamName)
	{
		setUnSelected(currentlySelected);
		setSelected(teamButton);

		currentlySelected = teamButton;
		currentlySelectedString = teamName;
	}

	public void setSelected(Pane driverButton)
	{
		driverButton.setStyle("-fx-background-color: rgba(0,0,0,0.26);");
	}

	public void setUnSelected(Pane driverButton)
	{
		driverButton.setStyle("-fx-background-color: rgba(0,0,0,0);");
	}
}
