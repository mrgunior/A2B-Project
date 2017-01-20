package manager.model;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class formulaApplication extends Application
{
	// Static setting variables
	static boolean fullscreen = true;
	static boolean resizable = true;
	private static GameController gamecontroller;
	
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
		//call method in GameController to get the teamname 
		return GameController.getProfile().getTeamName();
	}
	
	public static void setTeamName(String teamName)
	{
		GameController.getProfile().setTeamName(teamName);
	}
	
	public static void setDrivers(ArrayList<Driver> drivers)
	{
		GameController.getProfile().setDrivers(drivers);
	}
	
	public static double getBalance()
	{
		GameController.getProfile();
		return Profile.getBudget();
	}
	
	//temporary
	public static GameController getGameController()
	{
		return gamecontroller;
	}
	
	// Launch application
	public static void main(String[] args)
	{
		launch(args);
	}
	
	// Setup for stage
	public void start(Stage stage) throws Exception
	{
		// Creates a gamecontroller object at the starting up of the application
		gamecontroller = new GameController("./data.json");
		GameController.getProfile().setAllDrivers(GameController.getDrivers("./data/drivers.json"));
		
		//why this?? why are you writing everything after reading it from the json to the json?? @Mika
		//GameController.writeDriversToJSON();
		
		Parent root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
		theScene = new Scene(root);
		stage.setTitle("Formula 1 Manager v1.6.2");
		stage.setScene(theScene);
		stage.setFullScreen(fullscreen);
		stage.setResizable(resizable);
		stage.show();
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	          public void handle(WindowEvent we) {
	              	try
					{
						gamecontroller.stopAutoSave();
					}
					catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	          }
	      });  
	}
}
