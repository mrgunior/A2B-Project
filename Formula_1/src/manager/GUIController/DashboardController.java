package manager.GUIController;

import manager.controller.SceneLoadController;
import manager.model.GameController;
import manager.model.Profile;
import manager.model.formulaApplication;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DashboardController extends SceneLoadController implements Initializable
{
	// Background
	@FXML
	private AnchorPane root;
	@FXML
	private ImageView background;
	@FXML
	private Text seasonText;

	@FXML
	private Button popupNext;
	
	@FXML
	private Pane popup;
	// Scene elements
	@FXML
	private ImageView back;
	@FXML
	private Text raceText;

	@FXML
	private Pane carManagement, teamManagement, standings, race;

	// Testing
	@FXML
	private Text teamName, balance;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());

		DecimalFormat numberFormat = new DecimalFormat("#.00");
		
		teamName.setText(formulaApplication.getTeamName());
		seasonText.setText("Season " + Profile.getCurrentSeason());
		raceText.setText(" Race " + Profile.getCurrentRace());
		balance.setText("$ " + numberFormat.format(formulaApplication.getBalance()/1000000).toString() + " Million");

		
		AnimationTimer animationTimer = new AnimationTimer()
		{	
			@Override
			public void handle(long now)
			{
				if(Profile.getBudget() >= 0) {
				// Car Management Button
				carManagement.setOnMousePressed(event -> {
					try
					{
						gotoFxmlScene("CarManagement", (Stage) carManagement.getScene().getWindow());
						playAudio("click.wav", 1.0);
					} 
					
					catch (IOException e)
					{
						e.printStackTrace();
					}
				});
				carManagement.setOnMouseEntered(event -> {
					carManagement.setStyle("-fx-background-color: rgba(192,192,192,0.2); -fx-border-color: #7c7a7a96; -fx-border-width: 1;");
					playAudio("hover.wav", 1.0);
					// carManagement.setImage(new
					// Image("file:images/menu/BackHover.png"));
				});
				carManagement.setOnMouseExited(event -> {
					carManagement.setStyle("-fx-background-color: rgba(0,0,0,0); -fx-border-color: #7c7a7a96; -fx-border-width: 1;");
					// carManagement.setImage(new Image("file:images/menu/Back.png"));
				});
				
				// Team Management Button
				teamManagement.setOnMousePressed(event -> {
					try
					{
						gotoFxmlScene("TeamManagement", (Stage) teamManagement.getScene().getWindow());
						playAudio("click.wav", 1.0);
					} 
					
					catch (IOException e)
					{
						e.printStackTrace();
					}
				});
				teamManagement.setOnMouseEntered(event -> {
					teamManagement.setStyle("-fx-background-color: rgba(192,192,192,0.2); -fx-border-color: #7c7a7a96; -fx-border-width: 1;");
					playAudio("hover.wav", 1.0);
					// teamManagement.setImage(new
					// Image("file:images/menu/BackHover.png"));
				});
				teamManagement.setOnMouseExited(event -> {
					teamManagement.setStyle("-fx-background-color: rgba(0,0,0,0); -fx-border-color: #7c7a7a96; -fx-border-width: 1;");
					// teamManagement.setImage(new Image("file:images/menu/Back.png"));
				});

				// Standings Button
				standings.setOnMousePressed(event -> {
					try
					{
						gotoFxmlScene("Standings", (Stage) standings.getScene().getWindow());
						playAudio("click.wav", 1.0);
					} 
					
					catch (IOException e)
					{
						e.printStackTrace();
					}
				});
				standings.setOnMouseEntered(event -> {
					standings.setStyle("-fx-background-color: rgba(192,192,192,0.2); -fx-border-color: #7c7a7a96; -fx-border-width: 1;");
					playAudio("hover.wav", 1.0);
					// standings.setImage(new Image("file:images/menu/BackHover.png"));
				});
				standings.setOnMouseExited(event -> {
					standings.setStyle("-fx-background-color: rgba(0,0,0,0); -fx-border-color: #7c7a7a96; -fx-border-width: 1;");
					// standings.setImage(new Image("file:images/menu/Back.png"));
				});

				// Race Button
				race.setOnMousePressed(event -> {
					try
					{
						gotoFxmlScene("Race", (Stage) race.getScene().getWindow());
						fadeOutMaintheme();
					} 
					
					catch (IOException e)
					{
						e.printStackTrace();
					}
				});
				race.setOnMouseEntered(event -> {
					race.setStyle("-fx-background-color: rgba(192,192,192,0.2); -fx-border-color: #7c7a7a96; -fx-border-width: 1;");
					playAudio("hover.wav", 1.0);
					// carManagement.setImage(new
					// Image("file:images/menu/BackHover.png"));
				});
				race.setOnMouseExited(event -> {
					race.setStyle("-fx-background-color: rgba(0,0,0,0); -fx-border-color: #7c7a7a96; -fx-border-width: 1;");
					// carManagement.setImage(new Image("file:images/menu/Back.png"));
				});
			
				// Team Text
				teamName.setOnMousePressed(event -> {
					String currentTeamName = formulaApplication.getTeamName();
					playAudio("click.wav", 1.0);
					teamName.setText(currentTeamName);
				});

				// Balance Text
				balance.setOnMousePressed(event -> {
					String currentBalance = Double.toString(formulaApplication.getBalance());
					playAudio("click.wav", 1.0);
					balance.setText(currentBalance);
				});
				
				back.setOnMousePressed(event -> {
					try
					{
						gotoFxmlScene("MainMenu", (Stage) back.getScene().getWindow());
						playAudio("click.wav", 1.0);
					} 
					
					catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				back.setOnMouseEntered(event -> {
					back.setImage(new Image("file:images/menu/BackHover.png"));
					playAudio("hover.wav", 1.0);
				});
				back.setOnMouseExited(event -> {
					back.setImage(new Image("file:images/menu/Back.png"));
				});
				
			}
				else {
					carManagement.setCursor(Cursor.DEFAULT);
					teamManagement.setCursor(Cursor.DEFAULT);
					race.setCursor(Cursor.DEFAULT);
					standings.setCursor(Cursor.DEFAULT);
					back.setCursor(Cursor.DEFAULT);
					
				}

				popupNext.setOnMousePressed(event -> { 
					try {
						gotoFxmlScene("MainMenu", (Stage) popupNext.getScene().getWindow());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			}
		};
		
		animationTimer.start();
		if(Profile.getBudget() < 0){
			popup.setVisible(true);
			/*try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			playAudio("fail.wav", 1.0);
			
		}
	}
	
}
