package manager.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import manager.model.Stopwatch;

public class RaceController extends Controller implements Initializable
{
	// All the cars on the screen
	@FXML
	private ImageView ferrari1, ferrari2, forceIndia1, forceIndia2, haas1, haas2, honda1, honda2, manor1, manor2,
			williams1, williams2, mercedes1, mercedes2, redBull1, redBull2, renault1, renault2, toroRosso1, toroRosso2,
			sauber1, sauber2;
	// Line for the finish
	@FXML
	private Line finish;
	// Time
	@FXML
	private Text time;
	// All the cars in arraylist
	private ArrayList<GUICar> cars = new ArrayList<GUICar>();

	// Variables for GUI
	private static double	finishX;
	private static double	startCarsX		= 50;
	private static long		timerSpeed		= 25;
	private static boolean	timerRunning	= true;
	private String			timeString		= "";

	private int				frames	= 1;
	private static double	fps		= 60;

	/**
	 * Getter for finish X value
	 * @return double - x value of finish
	 */
	public static double getFinishX()
	{
		return finishX;
	}

	/**
	 * Getter for x value of starting position cars
	 * @return double - x value of starting position cars
	 */
	public static double getStartCarsX()
	{
		return startCarsX;
	}

	/**
	 * Getter for FPS
	 * @return double - FPS
	 */
	public static double getFps()
	{
		return fps;
	}

	/**
	 * Setter for timer running, timer will stop if the timer is set to false
	 * @param timerRunning
	 */
	public static void setTimerRunning(boolean timerRunning)
	{
		RaceController.timerRunning = timerRunning;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// Setup variables, car arraylist and GUI car position
		finishX = finish.getLayoutX();
		addCars(10000);
		for (GUICar car : cars)
		{
			car.setX(startCarsX);
		}

		// Setup stopwatch
		Stopwatch stopwatch = new Stopwatch();

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
				// Reset frames to prevent integer overflow
				if (frames < 10000000)
				{
					frames++;
				}
				else
				{
					frames = 0;
				}
				// Calculate fps, important for calculating the speed of the cars
				fps = frames / (stopwatch.elapsedTime() / 1000);
				// Stop updating timer if the timer has been turned off
				if (timerRunning)
				{
					timeString = stopwatch.elapsedTimeString();
					time.setText(timeString);
				}
			}
		};

		// Start the animationTimer, everything in the handle(){...} will be run every tick
		animationTimer.start();
	}

	/**
	 * Add all cars to the cars arrayList
	 */
	private void addCars(double time)
	{
		//TODO Get a better way to add all the cars to the arraylist
		GUICar car1 = new GUICar(ferrari1, time);
		GUICar car2 = new GUICar(ferrari2, time);
		GUICar car3 = new GUICar(forceIndia1, time);
		GUICar car4 = new GUICar(forceIndia2, time);
		GUICar car5 = new GUICar(haas1, time);
		GUICar car6 = new GUICar(haas2, time);
		GUICar car7 = new GUICar(honda1, time);
		GUICar car8 = new GUICar(honda2, time);
		GUICar car9 = new GUICar(manor1, time);
		GUICar car10 = new GUICar(manor2, time);
		GUICar car11 = new GUICar(williams1, time);
		GUICar car12 = new GUICar(williams2, time);
		GUICar car13 = new GUICar(mercedes1, time);
		GUICar car14 = new GUICar(mercedes2, time);
		GUICar car15 = new GUICar(redBull1, time);
		GUICar car16 = new GUICar(redBull2, time);
		GUICar car17 = new GUICar(renault1, time);
		GUICar car18 = new GUICar(renault2, time);
		GUICar car19 = new GUICar(toroRosso1, time);
		GUICar car20 = new GUICar(toroRosso2, time);
		GUICar car21 = new GUICar(sauber1, time);
		GUICar car22 = new GUICar(sauber2, time);

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);
		cars.add(car6);
		cars.add(car7);
		cars.add(car8);
		cars.add(car9);
		cars.add(car10);
		cars.add(car11);
		cars.add(car12);
		cars.add(car13);
		cars.add(car14);
		cars.add(car15);
		cars.add(car16);
		cars.add(car17);
		cars.add(car18);
		cars.add(car19);
		cars.add(car20);
		cars.add(car21);
		cars.add(car22);
	}
}
