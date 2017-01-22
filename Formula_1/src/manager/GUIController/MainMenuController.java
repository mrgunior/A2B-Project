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
import javafx.stage.Stage;
import manager.controller.SceneLoadController;
import manager.model.GameController;
import manager.model.Profile;
import manager.model.Standings;
import manager.model.formulaApplication;

public class MainMenuController extends SceneLoadController implements Initializable
{
	// Background
	@FXML
	private AnchorPane	root;
	@FXML
	private ImageView	background;

	// Buttons
	@FXML
	private ImageView	startGame;
	@FXML
	private ImageView	resume;
	@FXML
	private ImageView	settings;
	@FXML
	private ImageView	highscores;
	@FXML
	private ImageView	exit;
	
	//needs to stop the auto-save. It keeps running even when game closed. 'Temporary solution'
	GameController gamecontroller = formulaApplication.getGameController();

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		/*String musicFile = "audio/maintheme.mp3";

		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		*/
		
		//String musicFile = "audio/maintheme.mp3";
		//Media sound = new Media(new File(musicFile).toURI().toString());
		//musicPlayer = new MediaPlayer(sound);
		
		//if(musicPlayer.getStatus() != null){
		//System.out.println("%$%#$%#$%#$%#$%" + musicPlayer.getStatus());
		//musicPlayer.stop();
		//}
		
		//musicPlayer = new MediaPlayer(sound);
		//musicPlayer.play();
		startMaintheme();
		
		//playAudio("maintheme.mp3", 0.3);
		
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());

		AnimationTimer animationTimer = new AnimationTimer()
		{
			@Override
			public void handle(long now)
			{
				/// START GAME
				startGame.setOnMousePressed(event -> {
					try
					{
						Profile profile = GameController.getProfile();
						
						//since we are starting a new game let's make ids of drivers in data.json equal to 0
						//and update cars.json with standard values
						profile.resetProfile();
						Profile.setBudget(200000000);
						
						gotoFxmlScene("ChooseTeam", (Stage) startGame.getScene().getWindow());
						playAudio("click.wav", 1.0);
					}
					
					catch (IOException e)
					{
						e.printStackTrace();
					}
				});
				startGame.setOnMouseEntered(event -> {
					startGame.setImage(new Image("file:images/menu/StartGameHover.png"));
					playAudio("hover.wav", 1.0);
				});
				startGame.setOnMouseExited(event -> {
					startGame.setImage(new Image("file:images/menu/StartGame.png"));
				});

				/// RESUME
				resume.setOnMousePressed(event -> {
					Standings standings = new Standings();
					System.out.println(standings.toString());
					try
					{
						// if the json object that is asked is not equal to
						// empty
						if (!(formulaApplication.getTeamName().equals("")))
						{
							/*
							 *start the auto save 
							 *and read the drivers.json file and initialize 
							 */
							GameController.autoSave(); 
							GameController.getProfile().setAllDrivers(GameController.getDrivers("./data/drivers.json"));
							
							
							gotoFxmlScene("Dashboard", (Stage) resume.getScene().getWindow());
							playAudio("click.wav", 1.0);
						}

						// if the json object is empty
						else
						{
							System.out.println("user does not exist!");
						}
					}

					catch (IOException e)
					{
						e.printStackTrace();
					}
				});
				resume.setOnMouseEntered(event -> {
					resume.setImage(new Image("file:images/menu/ResumeHover.png"));
					playAudio("hover.wav", 1.0);
				});
				resume.setOnMouseExited(event -> {
					resume.setImage(new Image("file:images/menu/Resume.png"));
				});

				/// HIGHSCORES
				highscores.setOnMousePressed(event -> {
					try
					{
						gotoFxmlScene("HighScores", (Stage) highscores.getScene().getWindow());
						playAudio("click.wav", 1.0);
					}
					
					catch (IOException e)
					{
						e.printStackTrace();
					}
				});
				highscores.setOnMouseEntered(event -> {
					highscores.setImage(new Image("file:images/menu/HighScoresHover.png"));
					playAudio("hover.wav", 1.0);
				});
				highscores.setOnMouseExited(event -> {
					highscores.setImage(new Image("file:images/menu/HighScores.png"));
				});

				/// EXIT
				exit.setOnMousePressed(event -> {
					
					try 
					{
						GameController.stopAutoSave();
						playAudio("click.wav", 1.0);
					} 
					
					catch (IOException e) 
					{
						e.printStackTrace();
					}
					
					System.exit(0);
				});
				exit.setOnMouseEntered(event -> {
					exit.setImage(new Image("file:images/menu/ExitIconHover.png"));
					playAudio("hover.wav", 1.0);
				});
				exit.setOnMouseExited(event -> {
					exit.setImage(new Image("file:images/menu/ExitIcon.png"));
				});

				/// SETTINGS
				settings.setOnMousePressed(event -> {
					try
					{
						gotoFxmlScene("Settings", (Stage) settings.getScene().getWindow());
						playAudio("click.wav", 1.0);
					}
					
					catch (IOException e)
					{
						e.printStackTrace();
					}
				});
				settings.setOnMouseEntered(event -> {
					settings.setImage(new Image("file:images/menu/SettingsHover.png"));
					playAudio("hover.wav", 1.0);
				});
				settings.setOnMouseExited(event -> {
					settings.setImage(new Image("file:images/menu/Settings.png"));
				});
			}
		};
		
		animationTimer.start();

	}
}
