package manager.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import manager.model.DriverResult;
import manager.model.Results;
import manager.controller.ResultController;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.model.Stopwatch;

public class RaceController extends Controller implements Initializable
{
	// All the cars on the screen
	@FXML
	private ImageView ferrari1, ferrari2, forceIndia1, forceIndia2, haas1, haas2, honda1, honda2, manor1, manor2,
			williams1, williams2, mercedes1, mercedes2, redBull1, redBull2, renault1, renault2, toroRosso1, toroRosso2,
			sauber1, sauber2;
	
	ImageView[] carImages = {ferrari1, ferrari2, forceIndia1, forceIndia2, haas1, haas2, honda1, honda2, manor1, manor2, williams1, williams2, mercedes1, mercedes2, redBull1, redBull2, renault1, renault2, toroRosso1, toroRosso2, sauber1, sauber2};
	
	// Line for the finish
	@FXML
	private Line finish;
	// Time
	@FXML
	private Text time;
	@FXML
	private ImageView startRace;
	@FXML
	private ImageView gotoResults;
	
	// All the cars in arraylist
	private ArrayList<GUICar> cars = new ArrayList<GUICar>();

	// Variables for GUI
	private static double	finishX;
	private static double	startCarsX		= 50;
	private static boolean	timerRunning	= true;
	private String			timeString		= "";

	private int				frames	= 1;
	private static double	fps		= 60;
	
	private static boolean raceStarted = false;
	public static int nFinished = 0;
	
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
		raceStarted = false;
		setTimerRunning(false);
		gotoResults.setVisible(true);
	}
	
	public static void carFinished()
	{
		nFinished += 1;
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
		// Setup variables, car arraylist and GUI car position
		finishX = finish.getLayoutX();
		
		carImages[0] = ferrari1;
		
		// ===== RESULT STARTING =====//

		resultsRace = new Results();

//		DriverResult result1 = new DriverResult(1, "Result 1", 10000);
//		DriverResult result2 = new DriverResult(2, "Result 2", 3000);
//		DriverResult result3 = new DriverResult(3, "Result 3", 2000);
//		DriverResult result4 = new DriverResult(4, "Result 1", 10000);
//		DriverResult result5 = new DriverResult(5, "Result 2", 3000);
//		DriverResult result6 = new DriverResult(6, "Result 3", 2000);
//		DriverResult result7 = new DriverResult(7, "Result 1", 10000);
//		DriverResult result8 = new DriverResult(8, "Result 2", 3000);
//		DriverResult result9 = new DriverResult(9, "Result 3", 2000);
//		DriverResult result10 = new DriverResult(10, "Result 1", 10000);
//		DriverResult result11 = new DriverResult(11, "Result 2", 3000);
//		DriverResult result12 = new DriverResult(12, "Result 2", 3000);
//		DriverResult result13 = new DriverResult(13, "Result 3", 2000);
//		DriverResult result14 = new DriverResult(14, "Result 1", 10000);
//		DriverResult result15 = new DriverResult(15, "Result 2", 3000);
//		DriverResult result16 = new DriverResult(16, "Result 3", 2000);
//		DriverResult result17 = new DriverResult(17, "Result 1", 10000);
//		DriverResult result18 = new DriverResult(18, "Result 2", 3000);
//		DriverResult result19 = new DriverResult(19, "Result 3", 2000);
//		DriverResult result20 = new DriverResult(20, "Result 1", 10000);
//		DriverResult result21 = new DriverResult(21, "Result 2", 3000);
//		DriverResult result22 = new DriverResult(22, "Result 3", 2000);
		
		DriverResult result1 = new DriverResult(1, "Car 1", 10000);
		DriverResult result2 = new DriverResult(2, "Car 2", 6500);
		DriverResult result3 = new DriverResult(3, "Car 3", 6488);
		DriverResult result4 = new DriverResult(4, "Car 4", 3522);
		DriverResult result5 = new DriverResult(5, "Car 5", 3900);
		DriverResult result6 = new DriverResult(6, "Car 6", 9400);
		DriverResult result7 = new DriverResult(7, "Car 7", 5300);
		DriverResult result8 = new DriverResult(8, "Car 8", 4533);
		DriverResult result9 = new DriverResult(9, "Car 9", 6574);
		DriverResult result10 = new DriverResult(10, "Car 10", 6252);
		DriverResult result11 = new DriverResult(11, "Car 11", 7744);
		DriverResult result12 = new DriverResult(12, "Car 12", 7366);
		DriverResult result13 = new DriverResult(13, "Car 13", 7335);
		DriverResult result14 = new DriverResult(14, "Car 14", 8477);
		DriverResult result15 = new DriverResult(15, "Car 15", 9933);
		DriverResult result16 = new DriverResult(16, "Car 16", 9399);
		DriverResult result17 = new DriverResult(17, "Car 17", 6374);
		DriverResult result18 = new DriverResult(18, "Car 18", 6477);
		DriverResult result19 = new DriverResult(19, "Car 19", 8833);
		DriverResult result20 = new DriverResult(20, "Car 20", 9922);
		DriverResult result21 = new DriverResult(21, "Car 21", 7744);
		DriverResult result22 = new DriverResult(22, "Car 22", 7263);

		resultsRace.addResult(result1);
		resultsRace.addResult(result2);
		resultsRace.addResult(result3);
		resultsRace.addResult(result4);
		resultsRace.addResult(result5);
		resultsRace.addResult(result6);
		resultsRace.addResult(result7);
		resultsRace.addResult(result8);
		resultsRace.addResult(result9);
		resultsRace.addResult(result10);
		resultsRace.addResult(result11);
		resultsRace.addResult(result12);
		resultsRace.addResult(result13);
		resultsRace.addResult(result14);
		resultsRace.addResult(result15);
		resultsRace.addResult(result16);
		resultsRace.addResult(result17);
		resultsRace.addResult(result18);
		resultsRace.addResult(result19);
		resultsRace.addResult(result20);
		resultsRace.addResult(result21);
		resultsRace.addResult(result22);

		addCarsFromResults(resultsRace, 10000);

		// ===========================//

		for (GUICar car : cars)
		{
			car.setX(startCarsX);
		}
		
		//Hide goto results button
		gotoResults.setVisible(false);
		// Setup stopwatch and timer
		Stopwatch stopwatch = new Stopwatch();
		time.setText(stopwatch.elapsedTimeString());
		
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
				nFinished = getNFinished();
				
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
				
				if (nFinished >= 22)
				{
					stopRace();
				}
			}
		};

		startRace.setOnMousePressed(event -> {
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
				gotoFxmlScene(event, "Result", (Stage) time.getScene().getWindow());
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
		
		time.setOnMousePressed(event -> {
			animationTimer.start();
			stopwatch.start();
			raceStarted = true;
		});
	}

	private int getNFinished()
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
	
	/**
	 * Add all cars to the cars arrayList
	 */
	@SuppressWarnings("unused")
	private void addCars(double time)
	{
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
		/*
		GUICar[] tempCars = {car1, car2, car3, car4, car5, car6, car7, car8,
				car9, car10, car11, car12, car13, car14, car15,
				car16, car17, car18, car19, car20, car21, car22};
		
		for (int i = 0; i < tempCars.length; i++)
		{
			//System.out.println(ferrari1);
			System.out.println(carImages[i]);
			tempCars[i] = new GUICar(carImages[i], results.getResult(i).getTime());
		}
		 */
		
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
