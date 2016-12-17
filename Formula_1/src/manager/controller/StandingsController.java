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

public class StandingsController extends Controller implements Initializable
{
	// Background
	@FXML
	private AnchorPane root;
	@FXML
	private ImageView background;

	// Basic Scene elements
	@FXML
	private ImageView back;

	// Team Logos
	@FXML
	private ImageView logo1, logo2, logo3, logo4, logo5, logo6, logo7, logo8, logo9, logo10, logo11, logo12, logo13, logo14,
	logo15, logo16, logo17, logo18, logo19, logo20, logo21, logo22;
	// Standings Names
	@FXML
	private Text name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14,
			name15, name16, name17, name18, name19, name20, name21, name22;
	// Next Level Text
	@FXML
	private Text points1, points2, points3, points4, points5, points6, points7, points8, points9, points10, points11, points12, points13, points14,
			points15, points16, points17, points18, points19, points20, points21, points22;

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
