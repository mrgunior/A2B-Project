package manager.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Templates.DriverResult;
import Templates.Results;
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
	Results results;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());

		fillResults();
		
		setNames(results);
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
		results = new Results();

		DriverResult result1 = new DriverResult(1, "Result 1", 10000);
		DriverResult result2 = new DriverResult(2, "Result 2", 6500);
		DriverResult result3 = new DriverResult(3, "Result 3", 6488);
		DriverResult result4 = new DriverResult(4, "Result 4", 3522);
		DriverResult result5 = new DriverResult(5, "Result 5", 3000);
		DriverResult result6 = new DriverResult(6, "Result 6", 9400);
		DriverResult result7 = new DriverResult(7, "Result 7", 1100);
		DriverResult result8 = new DriverResult(8, "Result 8", 4533);
		DriverResult result9 = new DriverResult(9, "Result 9", 6574);
		DriverResult result10 = new DriverResult(10, "Result 10", 6252);
		DriverResult result11 = new DriverResult(11, "Result 11", 7744);
		DriverResult result12 = new DriverResult(12, "Result 12", 7366);
		DriverResult result13 = new DriverResult(13, "Result 13", 7335);
		DriverResult result14 = new DriverResult(14, "Result 14", 8477);
		DriverResult result15 = new DriverResult(15, "Result 15", 9933);
		DriverResult result16 = new DriverResult(16, "Result 16", 9399);
		DriverResult result17 = new DriverResult(17, "Result 17", 6374);
		DriverResult result18 = new DriverResult(18, "Result 18", 6477);
		DriverResult result19 = new DriverResult(19, "Result 19", 8833);
		DriverResult result20 = new DriverResult(20, "Result 20", 9922);
		DriverResult result21 = new DriverResult(21, "Result 21", 7744);
		DriverResult result22 = new DriverResult(22, "Result 22", 7263);
		results.addResult(result1);
		results.addResult(result2);
		results.addResult(result3);
		results.addResult(result4);
		results.addResult(result5);
		results.addResult(result6);
		results.addResult(result7);
		results.addResult(result8);
		results.addResult(result9);
		results.addResult(result10);
		results.addResult(result11);
		results.addResult(result12);
		results.addResult(result13);
		results.addResult(result14);
		results.addResult(result15);
		results.addResult(result16);
		results.addResult(result17);
		results.addResult(result18);
		results.addResult(result19);
		results.addResult(result20);
		results.addResult(result21);
		results.addResult(result22);
	}

	public void setNames(Results results)
	{
		results.sortResultsByTime();
		
		Text[] top10 = {name1, name2, name3, name4, name5, name6, name7, name8, name9, name10};
		
		for (int i = 0; i < 10; i++)
		{
			top10[i].setText(results.getResult(i).getName() + " Time: " + results.getResult(i).getTime());
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
