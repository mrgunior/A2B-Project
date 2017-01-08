package manager.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.junit.experimental.theories.Theories;

import manager.model.DriverResult;
import manager.model.Results;
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
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());

		//fillResults();
		
		setNames(resultsResult);
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

	public void fillResults()
	{
		resultsResult = new Results();

		DriverResult result1 = new DriverResult(1, "Result 1", 10000);
		DriverResult result2 = new DriverResult(2, "Resut 2", 6500);
		DriverResult result3 = new DriverResult(3, "Reslt 3", 6488);
		DriverResult result4 = new DriverResult(4, "Reult 4", 3522);
		DriverResult result5 = new DriverResult(5, "Rsult 5", 3900);
		DriverResult result6 = new DriverResult(6, "ut 6", 9400);
		DriverResult result7 = new DriverResult(7, "Result 7", 5300);
		DriverResult result8 = new DriverResult(8, "Rsult 8", 4533);
		DriverResult result9 = new DriverResult(9, "Reult 9", 6574);
		DriverResult result10 = new DriverResult(10, "Rsult 10", 6252);
		DriverResult result11 = new DriverResult(11, "Reult 11", 7744);
		DriverResult result12 = new DriverResult(12, "Reslt 12", 7366);
		DriverResult result13 = new DriverResult(13, "Resut 13", 7335);
		DriverResult result14 = new DriverResult(14, "Resul 14", 8477);
		DriverResult result15 = new DriverResult(15, "Resul 15", 9933);
		DriverResult result16 = new DriverResult(16, "Resu 16", 9399);
		DriverResult result17 = new DriverResult(17, "Resut 17", 6374);
		DriverResult result18 = new DriverResult(18, "Reslt 18", 6477);
		DriverResult result19 = new DriverResult(19, "Reslt 19", 8833);
		DriverResult result20 = new DriverResult(20, "Reult 20", 9922);
		DriverResult result21 = new DriverResult(21, "Reult 21", 7744);
		DriverResult result22 = new DriverResult(22, "Reult 22", 7263);
		resultsResult.addResult(result1);
		resultsResult.addResult(result2);
		resultsResult.addResult(result3);
		resultsResult.addResult(result4);
		resultsResult.addResult(result5);
		resultsResult.addResult(result6);
		resultsResult.addResult(result7);
		resultsResult.addResult(result8);
		resultsResult.addResult(result9);
		resultsResult.addResult(result10);
		resultsResult.addResult(result11);
		resultsResult.addResult(result12);
		resultsResult.addResult(result13);
		resultsResult.addResult(result14);
		resultsResult.addResult(result15);
		resultsResult.addResult(result16);
		resultsResult.addResult(result17);
		resultsResult.addResult(result18);
		resultsResult.addResult(result19);
		resultsResult.addResult(result20);
		resultsResult.addResult(result21);
		resultsResult.addResult(result22);
	}

	public void setNames(Results results)
	{
		resultsResult.sortResultsByTime();
		
		Text[] top10 = {name1, name2, name3, name4, name5, name6, name7, name8, name9, name10};
		
		for (int i = 0; i < 10; i++)
		{
			top10[i].setText(resultsResult.getResult(i).getName() + " Time: " + resultsResult.getResult(i).getTime());
		}
	}

	public void setPoints()
	{
		Text[] pointsText = { points1, points2, points3, points4, points5, points6, points7, points8, points9,
				points10 };
		int[] points = { 25, 18, 15, 12, 10, 8, 6, 4, 2, 1 };
		for (int i = 0; i < 10; i++)
		{
			pointsText[i].setText("+" + points[i]);
		}
	}
}
