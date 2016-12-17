package manager.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CarManagementController extends Controller implements Initializable
{
	// Background
	@FXML
	private AnchorPane root;
	@FXML
	private ImageView background;
	
	// Scene elements
	@FXML
	private ImageView back;
	
	// Upgrade Names Text
	@FXML
	private Text downNextUpgrade, aeroNextUpgrade, gearboxNextUpgrade, engineNextUpgrade, suspNextUpgrade, tiresNextUpgrade, weightNextUpgrade;
	// Next Level Text
	@FXML
	private Text downNextLevel, aeroNextLevel, gearboxNextLevel, engineNextLevel, suspNextLevel, tiresNextLevel, weightNextLevel;
	// Improvements Text
	@FXML
	private Text downImprov, aeroImprov, gearboxImprov, engineImprov, suspImprov, tiresImprov, weightImprov;
	// Price Text
	@FXML
	private Text downPrice, aeroPrice, gearboxPrice, enginePrice, suspPrice, tiresPrice, weightPrice;
	// Upgrade buttons
	@FXML
	private ImageView downUpgrade, aeroUpgrade, gearboxUpgrade, engineUpgrade, suspUpgrade, tiresUpgrade, weightUpgrade;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());
		
		// Click
		back.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "Dashboard", (Stage) back.getScene().getWindow());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		// Hover on
		back.setOnMouseEntered(event -> {
			back.setImage(new Image("file:images/menu/BackHover.png"));
		});
		// Hover off
		back.setOnMouseExited(event -> {
			back.setImage(new Image("file:images/menu/Back.png"));
		});
	}
	
	
}
