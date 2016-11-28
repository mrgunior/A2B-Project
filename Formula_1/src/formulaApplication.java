import java.awt.Button;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
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
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage stage)
	{
		stage.setTitle("Formula 1 Manager");
		
		Group root = new Group();
		Scene theScene = new Scene(root);
		stage.setScene(theScene);
		
		Canvas canvas = new Canvas(1920*.90, 1080*.90);
		root.getChildren().add(canvas);
		
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setFill(Color.GRAY);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		gc.setFill(Color.RED);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		Font font = Font.font("Impact", FontWeight.BOLD, 120);
		gc.setFont(font);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.CENTER);
		gc.fillText("FORMULA 1 MANAGER", canvas.getWidth()/2, canvas.getHeight()/2);
		gc.strokeText("FORMULA 1 MANAGER", canvas.getWidth()/2, canvas.getHeight()/2);
		
		Button startNewGame = new Button("Start New Game");
		Button resumeGame = new Button("Resume Game");
		Button Highscores = new Button("Highscores");
		Button exitGame = new Button("Exit Game");
		
		stage.show();
	}
}
