package manager.GUIController;

import manager.controller.GameController;
import manager.controller.SceneLoadController;
import manager.model.Profile;
import manager.model.formulaApplication;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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

	// Scene elements
	@FXML
	private ImageView back;
	@FXML
	private Text raceText;

	@FXML
	private Rectangle carManagement, teamManagement, standings, race;

	// Testing
	@FXML
	private Text teamName, balance;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());
		
		teamName.setText(formulaApplication.getTeamName());
		seasonText.setText("Season " + Profile.getCurrentSeason());
		raceText.setText(" Race " + Profile.getCurrentRace());
		balance.setText("$ " + Double.toString(formulaApplication.getBalance()/1000000) + " Million");

		AnimationTimer animationTimer = new AnimationTimer()
		{	
			@Override
			public void handle(long now)
			{
				// Car Management Button
				carManagement.setOnMousePressed(event -> {
					try
					{
						gotoFxmlScene("CarManagement", (Stage) carManagement.getScene().getWindow());
					} 
					
					catch (IOException e)
					{
						e.printStackTrace();
					}
				});
				carManagement.setOnMouseEntered(event -> {
					carManagement.setStyle("-fx-fill: rgba(192,192,192,0.2);");
					// carManagement.setImage(new
					// Image("file:images/menu/BackHover.png"));
				});
				carManagement.setOnMouseExited(event -> {
					carManagement.setStyle("-fx-fill: rgba(0,0,0,0);");
					// carManagement.setImage(new Image("file:images/menu/Back.png"));
				});

				// Team Management Button
				teamManagement.setOnMousePressed(event -> {
					try
					{
						gotoFxmlScene("TeamManagement", (Stage) teamManagement.getScene().getWindow());
					} 
					
					catch (IOException e)
					{
						e.printStackTrace();
					}
				});
				teamManagement.setOnMouseEntered(event -> {
					teamManagement.setStyle("-fx-fill: rgba(192,192,192,0.2);");
					// teamManagement.setImage(new
					// Image("file:images/menu/BackHover.png"));
				});
				teamManagement.setOnMouseExited(event -> {
					teamManagement.setStyle("-fx-fill: rgba(0,0,0,0);");
					// teamManagement.setImage(new Image("file:images/menu/Back.png"));
				});

				// Standings Button
				standings.setOnMousePressed(event -> {
					try
					{
						gotoFxmlScene("Standings", (Stage) standings.getScene().getWindow());
					} 
					
					catch (IOException e)
					{
						e.printStackTrace();
					}
				});
				standings.setOnMouseEntered(event -> {
					standings.setStyle("-fx-fill: rgba(192,192,192,0.2);");
					// standings.setImage(new Image("file:images/menu/BackHover.png"));
				});
				standings.setOnMouseExited(event -> {
					standings.setStyle("-fx-fill: rgba(0,0,0,0);");
					// standings.setImage(new Image("file:images/menu/Back.png"));
				});

				// Race Button
				race.setOnMousePressed(event -> {
					try
					{
						gotoFxmlScene("Race", (Stage) race.getScene().getWindow());
					} 
					
					catch (IOException e)
					{
						e.printStackTrace();
					}
				});
				race.setOnMouseEntered(event -> {
					race.setStyle("-fx-fill: rgba(192,192,192,0.2);");
					// carManagement.setImage(new
					// Image("file:images/menu/BackHover.png"));
				});
				race.setOnMouseExited(event -> {
					race.setStyle("-fx-fill: rgba(0,0,0,0);");
					// carManagement.setImage(new Image("file:images/menu/Back.png"));
				});
			
				// Team Text
				teamName.setOnMousePressed(event -> {
					String currentTeamName = formulaApplication.getTeamName();
					teamName.setText(currentTeamName);
				});

				// Balance Text
				balance.setOnMousePressed(event -> {
					String currentBalance = Double.toString(formulaApplication.getBalance());
					balance.setText(currentBalance);
				});
				
				back.setOnMousePressed(event -> {
					try
					{
						gotoFxmlScene("MainMenu", (Stage) back.getScene().getWindow());
					} 
					
					catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				back.setOnMouseEntered(event -> {
					back.setImage(new Image("file:images/menu/BackHover.png"));
				});
				back.setOnMouseExited(event -> {
					back.setImage(new Image("file:images/menu/Back.png"));
				});

			}
		};
		
		animationTimer.start();
	}
}
