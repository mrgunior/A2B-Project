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

public class ChooseDriverController extends Controller implements Initializable
{
	// Background
	@FXML
	private AnchorPane root;
	@FXML
	private ImageView background;
	
	// Scene elements
	@FXML
	private ImageView next;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());
		
		// Click
		next.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "Dashboard", (Stage) next.getScene().getWindow());
			} catch (IOException e)
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
	
	
}
