package manager.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class formulaApplication extends Application
{
	// Static setting variables
	static boolean fullscreen = true;
	static boolean resizable = true;
	static private String teamName = "";
	
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
	
	// Testing methods
	public static String getTeamName()
	{
		return teamName;
	}
	public static void setTeamName(String name)
	{
		teamName = name;
	}
	public static int getBalance()
	{
		return 5123456;
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
