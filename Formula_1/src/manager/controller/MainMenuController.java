package manager.controller;
import manager.model.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainMenuController implements Initializable
{
	@FXML
	private ImageView startGame;
	@FXML
	private ImageView resume;
	@FXML
	private ImageView options;
	@FXML
	private ImageView highscores;
	@FXML
	private ImageView exit;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// Events startGame
		startGame.setOnMousePressed(event -> {
			try
			{
				startGame(event);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		});
		startGame.setOnMouseEntered(event -> {
			startGame.setImage(new Image("file:images/menu/StartGameHover.png"));
		});
		startGame.setOnMouseExited(event -> {
			startGame.setImage(new Image("file:images/menu/StartGame.png"));
		});
		
		
		// Events resume
		resume.setOnMousePressed(event -> {
			try
			{
				resume(event);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		});
		resume.setOnMouseEntered(event -> {
			resume.setImage(new Image("file:images/menu/ResumeHover.png"));
		});
		resume.setOnMouseExited(event -> {
			resume.setImage(new Image("file:images/menu/Resume.png"));
		});
		
		// Events options
		options.setOnMousePressed(event -> {
			try
			{
				options(event);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		});		
		options.setOnMouseEntered(event -> {
			options.setImage(new Image("file:images/menu/OptionsHover.png"));
		});
		options.setOnMouseExited(event -> {
			options.setImage(new Image("file:images/menu/Options.png"));
		});
		
		// Events highscores
		highscores.setOnMousePressed(event -> {
			try
			{
				highscores(event);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		});		
		highscores.setOnMouseEntered(event -> {
			highscores.setImage(new Image("file:images/menu/HighScoresHover.png"));
		});
		highscores.setOnMouseExited(event -> {
			highscores.setImage(new Image("file:images/menu/HighScores.png"));
		});
		
		// Events exit
		exit.setOnMousePressed(event -> {
			try
			{
				exit(event);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		});		
		exit.setOnMouseEntered(event -> {
			exit.setImage(new Image("file:images/menu/ExitHover.png"));
		});
		exit.setOnMouseExited(event -> {
			exit.setImage(new Image("file:images/menu/Exit.png"));
		});
	}	
	
	private void startGame(MouseEvent event) throws IOException
	{
		gotoFxmlScene(event, "ChooseTeam");
	}

	private void resume(MouseEvent event) throws IOException
	{
		gotoFxmlScene(event, "Resume");
	}

	private void options(MouseEvent event) throws IOException
	{
		gotoFxmlScene(event, "Options");
	}

	private void highscores(MouseEvent event) throws IOException
	{
		gotoFxmlScene(event, "Highscores");
	}

	private void exit(MouseEvent event) throws IOException
	{
		System.exit(0);
	}
	
	private void gotoFxmlScene(MouseEvent event, String name) throws IOException
	{
		Parent root = FXMLLoader.load(this.getClass().getResource("../view/" + name + ".fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setFullScreen(formulaApplication.isFullscreen());
		stage.setResizable(formulaApplication.isResizable());
		stage.show();
	}
}
