import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class GUIController implements Initializable
{
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
				
	}
	
	@FXML
	private void startNewGame(ActionEvent event)
	{
		System.out.println("Start new game");
	}
	@FXML
	private void resume(ActionEvent event)
	{
		System.out.println("Resume");
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
