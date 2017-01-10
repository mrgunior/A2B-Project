package manager.GUIController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import manager.controller.GameController;
import manager.controller.SceneLoadController;
import manager.model.Driver;
import manager.model.Results;
import manager.model.Stopwatch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResultController extends SceneLoadController implements Initializable
{
	// Background
	@FXML
	private AnchorPane	root;
	@FXML
	private ImageView	background;

	// Basic Scene elements
	@FXML
	private ImageView next;

	// Team Logos
	@FXML
	private ImageView logo1, logo2, logo3, logo4, logo5, logo6, logo7, logo8, logo9, logo10;
	// Standings Names
	@FXML
	private Text name1, name2, name3, name4, name5, name6, name7, name8, name9, name10;
	// Points earned Text
	@FXML
	private Text points1, points2, points3, points4, points5, points6, points7, points8, points9, points10;
	// Total points text
	@FXML
	private Text totalPoints1, totalPoints2, totalPoints3, totalPoints4, totalPoints5, totalPoints6, totalPoints7, totalPoints8,
			totalPoints9, totalPoints10;

	// Results to be given to the controller
	private static Results resultsResult;

	int[] points = { 25, 18, 15, 12, 10, 8, 6, 4, 2, 1 };

	public static void setResults(Results newResults)
	{
		resultsResult = newResults;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// Fix background
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());

		// Set textboxes, names + points
		setNamesFromResults(resultsResult);
		setPoints();

		// Click
		next.setOnMousePressed(event -> {
			try
			{
				transferResultsToProfileDrivers();
				GameController.writeDriversToJSON();
				gotoFxmlScene(event, "Dashboard", (Stage) next.getScene().getWindow());
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

	}

	public void setNamesFromResults(Results results)
	{
		resultsResult.sortResultsByTime();

		Text[] top10 = { name1, name2, name3, name4, name5, name6, name7, name8, name9, name10 };

		for (int i = 0; i < 10; i++)
		{
			resultsResult.getResult(i).getDriver().addPoints(points[i]);
			top10[i].setText(resultsResult.getResult(i).getName() + " - " + Stopwatch.formatMilli(resultsResult.getResult(i).getTime()));
		}
	}

	public void setPoints()
	{
		// Set points earned text boxes
		Text[] pointsEarnedText = { points1, points2, points3, points4, points5, points6, points7, points8, points9, points10 };
		for (int i = 0; i < 10; i++)
		{
			pointsEarnedText[i].setText("+" + points[i]);
		}

		// Set total points text boxes
		Text[] totalPointsText = { totalPoints1, totalPoints2, totalPoints3, totalPoints4, totalPoints5, totalPoints6, totalPoints7,
				totalPoints8, totalPoints9, totalPoints10 };
		
		for (int i = 0; i < 10; i++)
		{
			totalPointsText[i].setText(resultsResult.getResult(i).getDriver().getPoints() + "");
		}
	}
	
	public void transferResultsToProfileDrivers()
	{
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		
		for (int i = 0; i < resultsResult.getResults().size(); i++)
		{
			drivers.add(resultsResult.getResult(i).getDriver());
		}
		
		GameController.getProfile().setAllDrivers(drivers);
	}
}
