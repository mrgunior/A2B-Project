package manager.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import manager.model.Results;
import manager.model.Stopwatch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResultController extends Controller implements Initializable
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
	// Next Level Text
	@FXML
	private Text points1, points2, points3, points4, points5, points6, points7, points8, points9, points10;

	// Results to be given to the controller
	private static Results resultsResult;
	
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
		
		Text[] top10 = {name1, name2, name3, name4, name5, name6, name7, name8, name9, name10};
		
		for (int i = 0; i < 10; i++)
		{
			top10[i].setText(resultsResult.getResult(i).getName() + " - " + Stopwatch.formatMilli(resultsResult.getResult(i).getTime()));
		}
	}

	public void setPoints()
	{
		Text[] pointsText = { points1, points2, points3, points4, points5, points6, points7, points8, points9,
				points10 };
		int[] points = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
		for (int i = 0; i < 10; i++)
		{
			pointsText[i].setText("+" + points[i]);
		}
	}
}
