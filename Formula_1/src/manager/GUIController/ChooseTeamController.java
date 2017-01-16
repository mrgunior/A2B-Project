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
import manager.model.Profile;
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
	private Pane mercedes, redBull, ferrari, forceIndia, williams, mcLaren, toroRosso, haas, renault, sauber, manor;

	// Color variables
	Color	teamSelectedColor		= new Color(0, 0, 0, .26);
	Color	teamNotSelectedColor	= new Color(0, 0, 0, 0);

	// Selector variable
	Pane	currentlySelected		= null;
	String	currentlySelectedString	= "";
	int currentlySelectedTeamID = 6;

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
					Profile.setTeamID(currentlySelectedTeamID);
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
			teamClicked(mercedes, "Mercedes AMG Petronas", 6);
		});
		redBull.setOnMousePressed(event -> {
			teamClicked(redBull, "Red Bull Racing", 7);
		});
		ferrari.setOnMousePressed(event -> {
			teamClicked(ferrari, "Scuderia Ferrari", 1);
		});
		forceIndia.setOnMousePressed(event -> {
			teamClicked(forceIndia, "Sahara Force India F1", 2);
		});
		williams.setOnMousePressed(event -> {
			teamClicked(williams, "Williams Martini Racing", 11);
		});
		mcLaren.setOnMousePressed(event -> {
			teamClicked(mcLaren, "McLaren Honda", 5);
		});
		toroRosso.setOnMousePressed(event -> {
			teamClicked(toroRosso, "Scuderia Toro Rosso", 10);
		});
		haas.setOnMousePressed(event -> {
			teamClicked(haas, "Haas F1 Team", 3);
		});
		renault.setOnMousePressed(event -> {
			teamClicked(renault, "Renault", 8);
		});
		sauber.setOnMousePressed(event -> {
			teamClicked(sauber, "Sauber F1 Team", 9);
		});
		manor.setOnMousePressed(event -> {
			teamClicked(manor, "Manor Racing", 4);
		});
	}

	private void teamClicked(Pane teamButton, String teamName, int teamId)
	{
		setUnSelected(currentlySelected);
		setSelected(teamButton);

		currentlySelected = teamButton;
		currentlySelectedString = teamName;
		currentlySelectedTeamID = teamId;
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
