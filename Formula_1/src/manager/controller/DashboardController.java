package manager.controller;

import manager.model.formulaApplication;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DashboardController extends Controller implements Initializable
{
	// Background
	@FXML
	private AnchorPane root;
	@FXML
	private ImageView background;

	// Scene elements
	@FXML
	private ImageView back;

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
		balance.setText(Integer.toString(formulaApplication.getBalance()));

		// Car Management Button
		carManagement.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "CarManagement", (Stage) carManagement.getScene().getWindow());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		carManagement.setOnMouseEntered(event -> {
			// carManagement.setImage(new
			// Image("file:images/menu/BackHover.png"));
		});
		carManagement.setOnMouseExited(event -> {
			// carManagement.setImage(new Image("file:images/menu/Back.png"));
		});

		// Team Management Button
		teamManagement.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "MainMenu", (Stage) teamManagement.getScene().getWindow());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		teamManagement.setOnMouseEntered(event -> {
			// teamManagement.setImage(new
			// Image("file:images/menu/BackHover.png"));
		});
		teamManagement.setOnMouseExited(event -> {
			// teamManagement.setImage(new Image("file:images/menu/Back.png"));
		});

		// Standings Button
		standings.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "Standings", (Stage) standings.getScene().getWindow());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		standings.setOnMouseEntered(event -> {
			// standings.setImage(new Image("file:images/menu/BackHover.png"));
		});
		standings.setOnMouseExited(event -> {
			// standings.setImage(new Image("file:images/menu/Back.png"));
		});

		// Race Button
		race.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "inRace", (Stage) race.getScene().getWindow());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		race.setOnMouseEntered(event -> {
			// carManagement.setImage(new
			// Image("file:images/menu/BackHover.png"));
		});
		race.setOnMouseExited(event -> {
			// carManagement.setImage(new Image("file:images/menu/Back.png"));
		});

		// Team Text
		teamName.setOnMousePressed(event -> {
			String currentTeamName = formulaApplication.getTeamName();
			teamName.setText(currentTeamName);
		});

		// Balance Text
		balance.setOnMousePressed(event -> {
			String currentBalance = Integer.toString(formulaApplication.getBalance());
			balance.setText(currentBalance);
		});
		
		back.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "MainMenu", (Stage) back.getScene().getWindow());
			} catch (IOException e)
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
}
