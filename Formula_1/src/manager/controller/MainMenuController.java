package manager.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.model.formulaApplication;

public class MainMenuController extends Controller implements Initializable
{
	// Background
	@FXML
	private AnchorPane root;
	@FXML
	private ImageView background;
	
	// Buttons
	@FXML
	private ImageView startGame;
	@FXML
	private ImageView resume;
	@FXML
	private ImageView settings;
	@FXML
	private ImageView highscores;
	@FXML
	private ImageView exit;
	@FXML
	private Text race;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());
		
		/// START GAME
		startGame.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "ChooseTeam", (Stage) startGame.getScene().getWindow());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		startGame.setOnMouseEntered(event -> {
			startGame.setImage(new Image("file:images/menu/StartGameHover.png"));
		});
		startGame.setOnMouseExited(event -> {
			startGame.setImage(new Image("file:images/menu/StartGame.png"));
		});
		
		
		/// RESUME
		resume.setOnMousePressed(event -> {
			try
			{
				if (!(formulaApplication.getTeamName().equals("")))
				{
					gotoFxmlScene(event, "Dashboard", (Stage) resume.getScene().getWindow());
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		resume.setOnMouseEntered(event -> {
			resume.setImage(new Image("file:images/menu/ResumeHover.png"));
		});
		resume.setOnMouseExited(event -> {
			resume.setImage(new Image("file:images/menu/Resume.png"));
		});

		
		/// HIGHSCORES
		highscores.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "HighScores", (Stage) highscores.getScene().getWindow());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});		
		highscores.setOnMouseEntered(event -> {
			highscores.setImage(new Image("file:images/menu/HighScoresHover.png"));
		});
		highscores.setOnMouseExited(event -> {
			highscores.setImage(new Image("file:images/menu/HighScores.png"));
		});
		
		
		/// EXIT
		exit.setOnMousePressed(event -> {
			System.exit(0);
		});		
		exit.setOnMouseEntered(event -> {
			exit.setImage(new Image("file:images/menu/ExitIconHover.png"));
		});
		exit.setOnMouseExited(event -> {
			exit.setImage(new Image("file:images/menu/ExitIcon.png"));
		});
		
		
		/// SETTINGS
		settings.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "Settings", (Stage) settings.getScene().getWindow());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});		
		settings.setOnMouseEntered(event -> {
			settings.setImage(new Image("file:images/menu/SettingsHover.png"));
		});
		settings.setOnMouseExited(event -> {
			settings.setImage(new Image("file:images/menu/Settings.png"));
		});
		
		
		// RACE
		race.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "inRace", (Stage) race.getScene().getWindow());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});	
	}	
}
