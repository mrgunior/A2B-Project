package manager.GUIController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import manager.controller.SceneLoadController;
import manager.model.Driver;
import manager.model.GameController;
import manager.model.Profile;
import manager.model.Results;
import manager.model.Standings;
import manager.model.Stopwatch;
import manager.model.formulaApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResultController extends SceneLoadController implements Initializable {
	// Background
	@FXML
	private AnchorPane root;
	@FXML
	private ImageView background;

	// Basic Scene elements
	@FXML
	private ImageView next;
	@FXML
	private Text resultsText;

	@FXML
	private Pane popup;
	// Team Logos
	@FXML
	private ImageView logo1, logo2, logo3, logo4, logo5, logo6, logo7, logo8, logo9, logo10;
	// Standings Names
	@FXML
	private Text name1, name2, name3, name4, name5, name6, name7, name8, name9, name10;
	@FXML
	// Timings
	private Text time1, time2, time3, time4, time5, time6, time7, time8, time9, time10;
	// Points earned Text
	@FXML
	private Text points1, points2, points3, points4, points5, points6, points7, points8, points9, points10;
	// Total points text
	@FXML
	private Text totalPoints1, totalPoints2, totalPoints3, totalPoints4, totalPoints5, totalPoints6, totalPoints7,
			totalPoints8, totalPoints9, totalPoints10;
	@FXML
	private Button popupNext;

	// Results to be given to the controller
	private static Results resultsResult;

	int[] points = { 25, 18, 15, 12, 10, 8, 6, 4, 2, 1 };

	private double winBonus = 0;

	public static void setResults(Results newResults) {
		resultsResult = newResults;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Fix background
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());

		// Set textboxes, names + points
		resultsText.setText("Results - Race " + Profile.getCurrentRace());
		setNamesFromResults(resultsResult);
		setPoints();
		setLogos();

		Standings standings = new Standings();
		resultsResult.sortResultsByTime();
		// Handle amount of races and seasons
		if (resultsResult.getResult(0).getDriver().getTeamId() == Profile.getTeamID()) {
			popup.setVisible(true);
			playAudio("victory.wav", 0.8);
		}

		for (int i = 0; i < points.length; i++) {
			if (resultsResult.getResult(i).getDriver().getTeamId() == Profile.getTeamID()) {
				winBonus += points[i] * 2000000;
				System.out.println(winBonus);
			}
		}

		// Click
		next.setOnMousePressed(event -> {
			try {
				playAudio("click.wav", 1.0);
				// Handle salaries
				double currentBudget = Profile.getBudget();
				double salaries = 0;

				for (int i = 0; i < resultsResult.getResults().size(); i++) {
					int teamId = resultsResult.getResult(i).getDriver().getTeamId();

					if (teamId == Profile.getTeamID()) {
						salaries += resultsResult.getResult(i).getDriver().getSalary();
					}
				}

				Profile.setBudget(Profile.getBudget() - salaries + winBonus);

				// Set all drivers in profile and write to JSON
				transferResultsToProfileDrivers();
				GameController.writeDriversToJSON("./data/drivers.json");

				// Handle amount of races and seasons
				Profile.setCurrentRace(Profile.getCurrentRace() + 1);
				System.out.println(Profile.getCurrentRace() + " > " + Profile.getRacesPerSeason());
				if (Profile.getCurrentRace() > Profile.getRacesPerSeason()) {

					gotoFxmlScene("Standings", (Stage) next.getScene().getWindow());

					Profile.setCurrentRace(1);
					GameController.getProfile().resetDriverPoints();
					Profile.setCurrentSeason(Profile.getCurrentSeason() + 1);
					GameController.writeJsonObjectToFile();
					GameController.writeDriversToJSON("./data/drivers.json");
				} else {
					gotoFxmlScene("Dashboard", (Stage) next.getScene().getWindow());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		popupNext.setOnMousePressed(event -> {
			popup.setVisible(false);
			playAudio("click.wav", 1.0);
		});

		popupNext.setOnMouseEntered(event -> {
			playAudio("hover.wav", 1.0);
		});
		// Hover on
		next.setOnMouseEntered(event -> {
			next.setImage(new Image("file:images/menu/NextHover.png"));
			playAudio("hover.wav", 1.0);
		});
		// Hover off
		next.setOnMouseExited(event -> {
			next.setImage(new Image("file:images/menu/Next.png"));
		});

	}

	public void setNamesFromResults(Results results) {
		resultsResult.sortResultsByTime();

		Text[] top10Drivers = { name1, name2, name3, name4, name5, name6, name7, name8, name9, name10 };
		Text[] top10Timings = { time1, time2, time3, time4, time5, time6, time7, time8, time9, time10 };

		for (int i = 0; i < 10; i++) {
			resultsResult.getResult(i).getDriver().addPoints(points[i]);
			top10Drivers[i].setText(resultsResult.getResult(i).getName());
			top10Timings[i].setText(
					Stopwatch.formatMilli(resultsResult.getResult(i).getTime() * RaceController.getTimeFactor()));
			if (resultsResult.getResult(i).getDriver().getTeamId() == Profile.getTeamID()) {
				top10Drivers[i].setStyle("-fx-fill: green");
				top10Timings[i].setStyle("-fx-fill: green");
			}

		}
	}

	public void setPoints() {
		// Set points earned text boxes
		Text[] pointsEarnedText = { points1, points2, points3, points4, points5, points6, points7, points8, points9,
				points10 };


		// Set total points text boxes
		Text[] totalPointsText = { totalPoints1, totalPoints2, totalPoints3, totalPoints4, totalPoints5, totalPoints6,
				totalPoints7, totalPoints8, totalPoints9, totalPoints10 };

		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				resultsResult.getResult(i).getDriver().salaryPercentageBonus(10);
			}
			totalPointsText[i].setText(resultsResult.getResult(i).getDriver().getPoints() + "");
			pointsEarnedText[i].setText("+" + points[i]);
			
			if (resultsResult.getResult(i).getDriver().getTeamId() == Profile.getTeamID()) {
				totalPointsText[i].setStyle("-fx-fill: green");
				pointsEarnedText[i].setStyle("-fx-fill: green");
			}
			
		}
	}

	private void setLogos() {
		ImageView[] logos = new ImageView[] { logo1, logo2, logo3, logo4, logo5, logo6, logo7, logo8, logo9, logo10 };
		resultsResult.sortResultsByTime();

		for (int i = 0; i < logos.length; i++) {
			logos[i].setImage(
					new Image("file:images/Logos/" + resultsResult.getResult(i).getDriver().getTeamId() + ".png"));
		}
	}

	public void transferResultsToProfileDrivers() {
		ArrayList<Driver> drivers = new ArrayList<Driver>();

		for (int i = 0; i < resultsResult.getResults().size(); i++) {
			drivers.add(resultsResult.getResult(i).getDriver());
		}

		GameController.getProfile().setAllDrivers(drivers);
	}
}
