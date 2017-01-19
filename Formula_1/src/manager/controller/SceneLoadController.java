package manager.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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


	static Media maintheme = new Media(new File(new String("audio/maintheme.wav")).toURI().toString());
	static Media racesound = new Media(new File(new String("audio/race.wav")).toURI().toString());
	public static MediaPlayer mainthemePlayer = new MediaPlayer(maintheme);
	public static MediaPlayer racesoundPlayer = new MediaPlayer(racesound);
	public static MediaPlayer mediaPlayer;


	public void startMaintheme() {
		mainthemePlayer.stop();
		mainthemePlayer.play();
	}
	
	public void playRaceSound() {
		racesoundPlayer.play();
	}
	
	public void stopRaceSound() {
		racesoundPlayer.stop();
	}
	
	public void pauseMaintheme() {
		mainthemePlayer.pause();
	}
	
	public void resumeMaintheme() {
		mainthemePlayer.play();
	}

	public void playAudio(String name, Double volume) {
		String musicFile = "audio/" + name;
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setVolume(volume);
		mediaPlayer.play();
	}

	public void fadeOutMaintheme(){
		double i = 1;
		while(i > 0.1){
			try {
				TimeUnit.MILLISECONDS.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
			mainthemePlayer.setVolume(i);
			i = i - 0.1;
		}
		mainthemePlayer.setVolume(1.0);
		mainthemePlayer.pause();
	}
	
	public void fadeOutRaceSound(){
		double i = 1;
		while(i > 0.1){
			try {
				TimeUnit.MILLISECONDS.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
			racesoundPlayer.setVolume(i);
			i = i - 0.1;
		}
		racesoundPlayer.setVolume(1.0);
		racesoundPlayer.stop();
	}
	
	public void StopAudio(String name) {
		mediaPlayer.stop();
	}

	public Duration getAudioDuration(String name) {
		String musicFile = "audio/" + name;

		Media sound = new Media(new File(musicFile).toURI().toString());
		return sound.getDuration();
	}
	
	public void gotoFxmlScene(String name, Stage stage) throws IOException
	{
		Parent root = FXMLLoader.load(this.getClass().getResource("../view/" + name + ".fxml"));
		
		formulaApplication.setSceneRoot(root);
		
		//stage.setFullScreen(formulaApplication.isFullscreen());
		stage.setResizable(formulaApplication.isResizable());
		stage.show();
	}
	
//	public void bindBackground(ImageView _background, AnchorPane _root)
//	{
//		_background.fitWidthProperty().bind(_root.widthProperty());
//		_background.fitHeightProperty().bind(_root.heightProperty());
//	}
}
