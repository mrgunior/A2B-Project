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
import jdk.nashorn.internal.runtime.Undefined;
import manager.model.formulaApplication;
import manager.model.GameController;

public class SceneLoadController
{	


	static Media maintheme = new Media(new File(new String("audio/maintheme.wav")).toURI().toString());
	static Media racesound = new Media(new File(new String("audio/race.wav")).toURI().toString());
	public static MediaPlayer mainthemePlayer = new MediaPlayer(maintheme);
	public static MediaPlayer racesoundPlayer = new MediaPlayer(racesound);
	public static MediaPlayer mediaPlayer;
	
	public static boolean isMuted = false;
	
	public static double volume = -1.0;
	public static double effectsVolume = -1.0;


	public void startMaintheme() {
		if(isMuted != true){
		mainthemePlayer.stop();
		if(volume != -1.0){
			mainthemePlayer.setVolume(volume);
		}
		mainthemePlayer.play();
		}
	}
	
	public void stopMainTheme() {
		mainthemePlayer.stop();
	}
	
	public void gotoFxmlScene(String name, Stage stage) throws IOException
	{
		Parent root = null;
		//System.out.println("Using SceneCatalog " + GameController.getSceneCatalog());
		SceneFile sceneFile = GameController.getSceneCatalog().getScene(name);
		if (sceneFile == null || name.equals("Race"))
		{
			//System.out.println("Found a new scene " + name);
			root = FXMLLoader.load(this.getClass().getResource("../view/" + name + ".fxml"));
		}
		else
		{
			//System.out.println("Using stored scene " + sceneFile.getName());
			root = sceneFile.getRoot();
		}
		GameController.getSceneCatalog().addSceneFile(new SceneFile(name, root));
		
		
		formulaApplication.setSceneRoot(root);
		
		//stage.setFullScreen(formulaApplication.isFullscreen());
		stage.setResizable(formulaApplication.isResizable());
		stage.show();
	}
	
	public void playRaceSound() {
		if (isMuted != true){	
		if (effectsVolume != -1.0) {
			racesoundPlayer.setVolume(effectsVolume);
		}
		racesoundPlayer.play();
		}
	}
	
	public void stopRaceSound() {
		if (isMuted != true){
		racesoundPlayer.stop();
		}
	}
	
	public void pauseMaintheme() {
		if (isMuted != true){
		mainthemePlayer.pause();
		}
	}
	
	public void resumeMaintheme() {
		if (isMuted != true){
		mainthemePlayer.play();
		}
	}

	public void playAudio(String name, Double volume) {
		if (isMuted != true){
		String musicFile = "audio/" + name;
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		if(effectsVolume != -1.0){
			mediaPlayer.setVolume(effectsVolume);
		}
		else{
		mediaPlayer.setVolume(volume);
		}
		mediaPlayer.play();
		}
	}

	public void fadeOutMaintheme(){
		if (isMuted != true){
		double i = volume;
		while(i > 0.1){
			try {
				TimeUnit.MILLISECONDS.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mainthemePlayer.setVolume(i);
			i = i - 0.1;
		}
		if (volume != -1.0) {
			mainthemePlayer.setVolume(volume);
		}
		else {
			mainthemePlayer.setVolume(1.0);
		}
		mainthemePlayer.pause();
		}
	}
	
	public void fadeOutRaceSound(){
		if (isMuted != true){
		double i = effectsVolume;
		while(i > 0.1){
			try {
				TimeUnit.MILLISECONDS.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			racesoundPlayer.setVolume(i);
			i = i - 0.1;
		}
		if (volume != -1.0) {
			racesoundPlayer.setVolume(effectsVolume);
		}
		else {
			racesoundPlayer.setVolume(1.0);
		}
		racesoundPlayer.stop();
		}
	}
	
	public void StopAudio(String name) {
		if (isMuted != true){
		mediaPlayer.stop();
		}
	}

	public Duration getAudioDuration(String name) {
		String musicFile = "audio/" + name;

		Media sound = new Media(new File(musicFile).toURI().toString());
		return sound.getDuration();
	}
	
//	public void gotoFxmlScene(String name, Stage stage) throws IOException
//	{
//		Parent root = FXMLLoader.load(this.getClass().getResource("../view/" + name + ".fxml"));
//		
//		formulaApplication.setSceneRoot(root);
//		
//		//stage.setFullScreen(formulaApplication.isFullscreen());
//		stage.setResizable(formulaApplication.isResizable());
//		stage.show();
//	}
	
//	public void bindBackground(ImageView _background, AnchorPane _root)
//	{
//		_background.fitWidthProperty().bind(_root.widthProperty());
//		_background.fitHeightProperty().bind(_root.heightProperty());
//	}
}
