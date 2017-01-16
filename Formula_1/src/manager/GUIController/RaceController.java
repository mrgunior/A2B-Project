package manager.GUIController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import manager.GUIController.ResultController;
import manager.controller.SceneLoadController;
import manager.controller.GUICar;
import manager.model.RaceSimulation;
import manager.model.Results;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.model.Stopwatch;
import manager.model.formulaApplication;

public class RaceController extends SceneLoadController implements Initializable
{
	// Root for adding nodes
	@FXML
	private AnchorPane	root;
	@FXML
	private ImageView	background;
	// All the cars on the screen
	@FXML
	private ImageView ferrari1, ferrari2, forceIndia1, forceIndia2, haas1, haas2, honda1, honda2, manor1, manor2, williams1, williams2,
			mercedes1, mercedes2, redBull1, redBull2, renault1, renault2, toroRosso1, toroRosso2, sauber1, sauber2;

	private GUICar car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12, car13, car14, car15, car16, car17, car18,
			car19, car20, car21, car22;
	
	// Line for the finish
	@FXML
	private Line finish;
	// Time
	@FXML
	private Text		time;
	@FXML
	private ImageView	startRace;
	@FXML
	private ImageView	gotoResults;

	// All the cars in arraylist
	private ArrayList<GUICar> cars = new ArrayList<GUICar>();

	// Variables for GUI
	private static double	finishX;
	private static double	startCarsX		= 50;
	private static boolean	timerRunning	= true;
	private String			timeString		= "";
	private static double	timeFactor		= 500;

	private int				frames	= 1;
	private static double	fps		= 60;

	private static boolean	raceStarted		= false;
	public static int		amountFinished	= 0;

	public static Results resultsRace;

	/**
	 * Getter for finish X value
	 * 
	 * @return double - x value of finish
	 */
	public static double getFinishX()
	{
		return finishX;
	}

	/**
	 * Getter for x value of starting position cars
	 * 
	 * @return double - x value of starting position cars
	 */
	public static double getStartCarsX()
	{
		return startCarsX;
	}

	/**
	 * Getter for FPS
	 * 
	 * @return double - FPS
	 */
	public static double getFps()
	{
		return fps;
	}

	public static double getTimeFactor()
	{
		return timeFactor;
	}

	public static boolean isRaceStarted()
	{
		return raceStarted;
	}

	public void startRace()
	{
		raceStarted = true;
	}

	public void stopRace()
	{
		//raceStarted = false;
		//setTimerRunning(false);
		gotoResults.setVisible(true);
	}

	public static void carFinished()
	{
		amountFinished += 1;
	}

	/**
	 * Setter for timer running, timer will stop if the timer is set to false
	 * 
	 * @param timerRunning
	 */
	public static void setTimerRunning(boolean timerRunning)
	{
		RaceController.timerRunning = timerRunning;
	}

	public static void setResults(Results newResults)
	{
		resultsRace = newResults;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		ImageView[] carImages = { ferrari1, ferrari2, forceIndia1, forceIndia2, haas1, haas2, honda1, honda2, manor1, manor2, williams1,
				williams2, mercedes1, mercedes2, redBull1, redBull2, renault1, renault2, toroRosso1, toroRosso2, sauber1, sauber2 };
		
		// Fluid GUI
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());
		double sceneWidth = formulaApplication.getScene().getWidth();
		double sceneHeight = formulaApplication.getScene().getHeight();
		finishX = sceneWidth / 1.159;
		finish.setLayoutX(finishX);

		double carStartY = sceneWidth / 12.972972973;
		for (int i = 0; i < carImages.length; i++)
		{
			ImageView carImage = carImages[i];
			carImage.setLayoutY(carStartY + (i * (sceneHeight / 30.8571428571)));
			carImage.setFitWidth(200*sceneWidth/1920);
			carImage.setFitHeight(35*sceneHeight/1080);
		}



		// Simulate results and store in results object
		resultsRace = RaceSimulation.runSimulation(Math.random() * 2 + 4);
		resultsRace.sortResultsByTime();

		// Create cars from results
		createCarsFromResults(resultsRace, 10000);

		for (int i = 0; i < cars.size(); i++)
		{
			cars.get(i).setX(startCarsX);
		}

		// Hide goto results button
		gotoResults.setVisible(false);
		// Setup stopwatch and timer with time 00:00:00.000
		Stopwatch stopwatch = new Stopwatch();
		time.setText(stopwatch.elapsedTimeString(stopwatch.elapsedTime() * timeFactor));

		// Everything inside handle(){...} will be run every tick
		AnimationTimer animationTimer = new AnimationTimer()
		{
			@Override
			public void handle(long now)
			{
				// Move all cars
				for (GUICar car : cars)
				{
					car.moveCar();
				}
				// Get the amount of cars finished
				amountFinished = getAmountFinished();

				// Reset frames to prevent integer overflow
				if (frames < 100000000)
				{
					frames++;
				}
				else
				{
					frames = 0;
				}
				// Calculate fps, important for calculating the speed of the
				// cars
				fps = frames / (stopwatch.elapsedTime() / 1000);
				// Stop updating timer if the timer has been turned off
				if (timerRunning)
				{
					timeString = stopwatch.elapsedTimeString(stopwatch.elapsedTime() * timeFactor);
					time.setText(timeString);
				}

				if (amountFinished >= 22)
				{
					stopRace();
				}
			}
		};

		startRace.setOnMousePressed(event -> {
			playAudio("race.wav", 1.0);
			startRace.setVisible(false);
			animationTimer.start();
			stopwatch.start();
			timerRunning = true;
			raceStarted = true;
		});
		startRace.setOnMouseEntered(event -> {
			startRace.setImage(new Image("file:images/menu/StartGameHover.png"));
		});
		startRace.setOnMouseExited(event -> {
			startRace.setImage(new Image("file:images/menu/StartGame.png"));
		});

		gotoResults.setOnMousePressed(event -> {
			animationTimer.stop();
			ResultController.setResults(resultsRace);
			try
			{
				gotoFxmlScene("Result", (Stage) time.getScene().getWindow());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		gotoResults.setOnMouseEntered(event -> {
			gotoResults.setImage(new Image("file:images/menu/NextHover.png"));
		});
		gotoResults.setOnMouseExited(event -> {
			gotoResults.setImage(new Image("file:images/menu/Next.png"));
		});
	}

	private int getAmountFinished()
	{
		int returnValue = 0;
		for (GUICar car : cars)
		{
			if (car.isFinished())
			{
				returnValue++;
			}
		}
		return returnValue;
	}

	public void createCarsFromResults(Results results, double time)
	{
		// GUICar carX = new GUICar(carName, time)
		results.sortResultsByCarId();

		for (int i = 0; i < results.getResults().size(); i++)
		{
			switch (results.getResult(i).getDriver().getTeamId())
			{
			case 1:
				if (car1 == null)
				{
					car1 = new GUICar(ferrari1, results.getResult(i).getTime());
				}
				else
				{
					car2 = new GUICar(ferrari2, results.getResult(i).getTime());
				}
				break;
			case 2:
				if (car3 == null)
				{
					car3 = new GUICar(forceIndia1, results.getResult(i).getTime());
				}
				else
				{
					car4 = new GUICar(forceIndia2, results.getResult(i).getTime());
				}
				break;
			case 3:
				if (car5 == null)
				{
					car5 = new GUICar(haas1, results.getResult(i).getTime());
				}
				else
				{
					car6 = new GUICar(haas2, results.getResult(i).getTime());
				}
				break;
			case 4:
				if (car7 == null)
				{
					car7 = new GUICar(manor1, results.getResult(i).getTime());
				}
				else
				{
					car8 = new GUICar(manor2, results.getResult(i).getTime());
				}
				break;
			case 5:
				if (car9 == null)
				{
					car9 = new GUICar(honda1, results.getResult(i).getTime());
				}
				else
				{
					car10 = new GUICar(honda2, results.getResult(i).getTime());
				}
				break;
			case 6:
				if (car11 == null)
				{
					car11 = new GUICar(mercedes1, results.getResult(i).getTime());
				}
				else
				{
					car12 = new GUICar(mercedes2, results.getResult(i).getTime());
				}
				break;
			case 7:
				if (car13 == null)
				{
					car13 = new GUICar(redBull1, results.getResult(i).getTime());
				}
				else
				{
					car14 = new GUICar(redBull2, results.getResult(i).getTime());
				}
				break;
			case 8:
				if (car15 == null)
				{
					car15 = new GUICar(renault1, results.getResult(i).getTime());
				}
				else
				{
					car16 = new GUICar(renault2, results.getResult(i).getTime());
				}
				break;
			case 9:
				if (car17 == null)
				{
					car17 = new GUICar(sauber1, results.getResult(i).getTime());
				}
				else
				{
					car18 = new GUICar(sauber2, results.getResult(i).getTime());
				}
				break;
			case 10:
				if (car19 == null)
				{
					car19 = new GUICar(toroRosso1, results.getResult(i).getTime());
				}
				else
				{
					car20 = new GUICar(toroRosso2, results.getResult(i).getTime());
				}
				break;
			case 11:
				if (car21 == null)
				{
					car21 = new GUICar(williams1, results.getResult(i).getTime());
				}
				else
				{
					car22 = new GUICar(williams2, results.getResult(i).getTime());
				}
				break;
			}
		}
		
		GUICar[] tempCars = {car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12, car13, car14, car15, car16, car17,
				car18, car19, car20, car21, car22};
		
		for (int i = 0; i < tempCars.length; i++)
		{
			cars.add(tempCars[i]);
		}
	}
}
