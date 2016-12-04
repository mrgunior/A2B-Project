package manager.controller;
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
import javafx.stage.Popup;
import javafx.stage.Stage;

public class MainMenuController implements Initializable
{
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{

	}

	@FXML
	private void startNewGame(ActionEvent event) throws IOException
	{
		System.out.println("Starting new game...");
		Parent root = FXMLLoader.load(this.getClass().getResource("../view/ChooseTeam.fxml"));
		System.out.println(root.getChildrenUnmodifiable().get(1).toString());
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
	private void highscores(ActionEvent event) throws IOException
	{
		System.out.println("Highscores");
	}

	@FXML
	private void exit(ActionEvent event)
	{
		System.exit(0);
	}

}
