package manager.GUIController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import manager.controller.SceneLoadController;

public class ResumeController extends SceneLoadController implements Initializable{

	@FXML
	private AnchorPane root;
	@FXML
	private ImageView background;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());
		
		try {
			System.out.println("%%%%%%%%%%%%%%%%%%%###############@##$#$%!$%");
			try {
				gotoFxmlSceneTimed("Dashboard", (Stage) background.getScene().getWindow());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
