package manager.model;

import java.awt.Button;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class formulaApplication extends Application
{
	// Static setting variables
	static boolean fullscreen = true;
	static boolean resizable = true;
	
	// Static scene to change screen
	static private Scene theScene;
	
	// Getters and setters
	public static boolean isFullscreen()
	{
		return fullscreen;
	}
	public static void setFullscreen(boolean fullscreenSetting)
	{
		fullscreen = fullscreenSetting;
	}
	
	public static boolean isResizable()
	{
		return resizable;
	}
	public static void setResizable(boolean resizableSetting)
	{
		resizable = resizableSetting;
	}
	
	public static Scene getScene()
	{
		return theScene;
	}
	public static void setSceneRoot(Parent parentRoot)
	{
		theScene.setRoot(parentRoot);
	}
	
	// Launch application
	public static void main(String[] args)
	{
		launch(args);
	}
	
	// Setup for stage
	public void start(Stage stage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
		theScene = new Scene(root);
		stage.setTitle("Formula 1 Manager");
		stage.setScene(theScene);
		stage.setFullScreen(fullscreen);
		stage.setResizable(resizable);
		stage.show();
	}
}
