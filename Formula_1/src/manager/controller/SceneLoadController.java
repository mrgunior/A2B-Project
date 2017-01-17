package manager.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.omg.CORBA.PUBLIC_MEMBER;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.internal.dynalink.beans.StaticClass;
import manager.model.formulaApplication;

public class SceneLoadController
{	
	MediaPlayer mediaPlayer;
	
	public void gotoFxmlScene(String name, Stage stage) throws IOException
	{
		Parent root = null;
		SceneFile sceneFile = GameController.getSceneCatalog().getScene(name);
		if (sceneFile == null || name.equals("Race"))
		{
			System.out.println("Found a new scene " + name);
			root = FXMLLoader.load(this.getClass().getResource("../view/" + name + ".fxml"));
		}
		else
		{
			System.out.println("Using stored scene " + sceneFile.getName());
			root = sceneFile.getRoot();
		}
		GameController.getSceneCatalog().addSceneFile(new SceneFile(name, root));
		
		
		formulaApplication.setSceneRoot(root);
		
		//stage.setFullScreen(formulaApplication.isFullscreen());
		stage.setResizable(formulaApplication.isResizable());
		stage.show();
	}
	
	public void playAudio(String name, Double volume) {
		String musicFile = "audio/" + name;
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setVolume(volume);
		mediaPlayer.play();
		}
		
	
	public void StopAudio(String name) {
		mediaPlayer.stop();
	}
	
	public Duration getAudioDuration(String name) {
		String musicFile = "audio/" + name;

		Media sound = new Media(new File(musicFile).toURI().toString());
		return sound.getDuration();
	}
//	public void bindBackground(ImageView _background, AnchorPane _root)
//	{
//		_background.fitWidthProperty().bind(_root.widthProperty());
//		_background.fitHeightProperty().bind(_root.heightProperty());
//	}
}
