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
	static boolean fullscreen = false;
	static boolean resizable = false;
	
	public static boolean isFullscreen()
	{
		return fullscreen;
	}
	public static boolean isResizable()
	{
		return resizable;
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage stage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
		Scene theScene = new Scene(root);
		stage.setTitle("Formula 1 Manager");
		stage.setScene(theScene);
		stage.setFullScreen(fullscreen);
		stage.setResizable(resizable);
		stage.show();
	}
}
