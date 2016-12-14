package manager.controller;

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
	private Rectangle carManagement;
	@FXML
	private Rectangle teamManagement;
	@FXML
	private Rectangle standings;
	@FXML
	private Rectangle race;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());
		
		carManagement.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "MainMenu", (Stage) carManagement.getScene().getWindow());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		carManagement.setOnMouseEntered(event -> {
			//carManagement.setImage(new Image("file:images/menu/BackHover.png"));
		});
		carManagement.setOnMouseExited(event -> {
			//carManagement.setImage(new Image("file:images/menu/Back.png"));
		});
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
			//teamManagement.setImage(new Image("file:images/menu/BackHover.png"));
		});
		teamManagement.setOnMouseExited(event -> {
			//teamManagement.setImage(new Image("file:images/menu/Back.png"));
		});
		
		standings.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "MainMenu", (Stage) standings.getScene().getWindow());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		standings.setOnMouseEntered(event -> {
			//standings.setImage(new Image("file:images/menu/BackHover.png"));
		});
		standings.setOnMouseExited(event -> {
			//standings.setImage(new Image("file:images/menu/Back.png"));
		});
		
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
			//carManagement.setImage(new Image("file:images/menu/BackHover.png"));
		});
		race.setOnMouseExited(event -> {
			//carManagement.setImage(new Image("file:images/menu/Back.png"));
		});
	}
}
