package manager.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Templates.DriverResult;
import Templates.Results;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.model.Stopwatch;
import sun.management.counter.Variability;

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

	/**
	 * Setter for timer running, timer will stop if the timer is set to false
	 * 
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

		// ===== RESULT STARTING =====//

		Results results = new Results();

		DriverResult result1 = new DriverResult(1, "Result 1", 10000);
		DriverResult result2 = new DriverResult(2, "Result 2", 3000);
		DriverResult result3 = new DriverResult(3, "Result 3", 2000);
		DriverResult result4 = new DriverResult(4, "Result 1", 10000);
		DriverResult result5 = new DriverResult(5, "Result 2", 3000);
		DriverResult result6 = new DriverResult(6, "Result 3", 2000);
		DriverResult result7 = new DriverResult(7, "Result 1", 10000);
		DriverResult result8 = new DriverResult(8, "Result 2", 3000);
		DriverResult result9 = new DriverResult(9, "Result 3", 2000);
		DriverResult result10 = new DriverResult(10, "Result 1", 10000);
		DriverResult result11 = new DriverResult(11, "Result 2", 3000);
		DriverResult result12 = new DriverResult(12, "Result 2", 3000);
		DriverResult result13 = new DriverResult(13, "Result 3", 2000);
		DriverResult result14 = new DriverResult(14, "Result 1", 10000);
		DriverResult result15 = new DriverResult(15, "Result 2", 3000);
		DriverResult result16 = new DriverResult(16, "Result 3", 2000);
		DriverResult result17 = new DriverResult(17, "Result 1", 10000);
		DriverResult result18 = new DriverResult(18, "Result 2", 3000);
		DriverResult result19 = new DriverResult(19, "Result 3", 2000);
		DriverResult result20 = new DriverResult(20, "Result 1", 10000);
		DriverResult result21 = new DriverResult(21, "Result 2", 3000);
		DriverResult result22 = new DriverResult(22, "Result 3", 2000);

		results.addResult(result1);
		results.addResult(result2);
		results.addResult(result3);
		results.addResult(result4);
		results.addResult(result5);
		results.addResult(result6);
		results.addResult(result7);
		results.addResult(result8);
		results.addResult(result9);
		results.addResult(result10);
		results.addResult(result11);
		results.addResult(result12);
		results.addResult(result13);
		results.addResult(result14);
		results.addResult(result15);
		results.addResult(result16);
		results.addResult(result17);
		results.addResult(result18);
		results.addResult(result19);
		results.addResult(result20);
		results.addResult(result21);
		results.addResult(result22);

		addCarsFromResults(results, 10000);

		// ===========================//

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
				// Calculate fps, important for calculating the speed of the
				// cars
				fps = frames / (stopwatch.elapsedTime() / 1000);
				// Stop updating timer if the timer has been turned off
				if (timerRunning)
				{
					timeString = stopwatch.elapsedTimeString();
					time.setText(timeString);
				}
			}
		};

		// Start the animationTimer, everything in the handle(){...} will be run
		// every tick
		animationTimer.start();
	}

	/**
	 * Add all cars to the cars arrayList
	 */
	private void addCars(double time)
	{
		// TODO Get a better way to add all the cars to the arraylist
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

	public void addCarsFromResults(Results results, double time)
	{
		// GUICar carX = new GUICar(carName, time)
		results.sortResultsByCarId();
		// GUICar car
		GUICar car1 = null, car2 = null, car3 = null, car4 = null, car5 = null, car6 = null, car7 = null, car8 = null,
				car9 = null, car10 = null, car11 = null, car12 = null, car13 = null, car14 = null, car15 = null,
				car16 = null, car17 = null, car18 = null, car19 = null, car20 = null, car21 = null, car22 = null;
		for (int i = 0; i < results.getResults().size(); i++)
		{
			switch (results.getResult(i).getCarId())
			{
			case 1:
				car1 = new GUICar(ferrari1, results.getResult(0).getTime()); break;
			case 2:
				car2 = new GUICar(ferrari2, results.getResult(1).getTime()); break;
			case 3:
				car3 = new GUICar(forceIndia1, results.getResult(2).getTime()); break;
			case 4:
				car4 = new GUICar(forceIndia2, results.getResult(3).getTime()); break;
			case 5:
				car5 = new GUICar(haas1, results.getResult(4).getTime()); break;
			case 6:
				car6 = new GUICar(haas2, results.getResult(5).getTime()); break;
			case 7:
				car7 = new GUICar(honda1, results.getResult(6).getTime()); break;
			case 8:
				car8 = new GUICar(honda2, results.getResult(7).getTime()); break;
			case 9:
				car9 = new GUICar(manor1, results.getResult(8).getTime()); break;
			case 10:
				car10 = new GUICar(manor2, results.getResult(9).getTime()); break;
			case 11:
				car11 = new GUICar(williams1, results.getResult(10).getTime()); break;
			case 12:
				car12 = new GUICar(williams2, results.getResult(11).getTime()); break;
			case 13:
				car13 = new GUICar(mercedes1, results.getResult(12).getTime()); break;
			case 14:
				car14 = new GUICar(mercedes2, results.getResult(13).getTime()); break;
			case 15:
				car15 = new GUICar(redBull1, results.getResult(14).getTime()); break;
			case 16:
				car16 = new GUICar(redBull2, results.getResult(15).getTime()); break;
			case 17:
				car17 = new GUICar(renault1, results.getResult(16).getTime()); break;
			case 18:
				car18 = new GUICar(renault2, results.getResult(17).getTime()); break;
			case 19:
				car19 = new GUICar(toroRosso1, results.getResult(18).getTime()); break;
			case 20:
				car20 = new GUICar(toroRosso2, results.getResult(19).getTime()); break;
			case 21:
				car21 = new GUICar(sauber1, results.getResult(20).getTime()); break;
			case 22:
				car22 = new GUICar(sauber2, results.getResult(21).getTime()); break;

			default:
				break;
			}
		}
		// Add all GUICars
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
