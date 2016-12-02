import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIController implements Initializable
{
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{

	}

	@FXML
	private void startNewGame(ActionEvent event) throws IOException
	{
		System.out.println("Starting new game...");
		Parent root = FXMLLoader.load(this.getClass().getResource("NewGame.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void resume(ActionEvent event)
	{
		System.out.println("Resume");
	}

	@FXML
	private void options(ActionEvent event)
	{
		System.out.println("Options");
	}

	@FXML
	private void highscores(ActionEvent event)
	{
		System.out.println("Show highscores");
	}

	@FXML
	private void exit(ActionEvent event)
	{
		System.out.println("Exit");
	}

}
