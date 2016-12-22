package manager.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.prism.Image;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import manager.model.Car;

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
	// All the cars in arraylist
	private ArrayList<ImageView> cars = new ArrayList<ImageView>();
	// Variables for GUI
	private double	finishX;
	private double	startCarsX	= 200;
	private long	timerSpeed	= 50;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// Setup variables, arraylist and GUI car position
		finishX = finish.getLayoutX();
		addCars();
		for (ImageView car : cars)
		{
			car.setLayoutX(startCarsX);
		}

		// Actions that will occur every gametick
		TimerTask gameTickActions = new TimerTask()
		{
			@Override
			public void run()
			{
				for (ImageView car : cars)
				{
					driveCar(car, calculateSpeed(10000));
				}
			}
		};

		// Create the timer that will run the gametick tasks every <timerSpeed> milliseconds
		Timer timer = new Timer();
		timer.schedule(gameTickActions, 1, timerSpeed);
	}

	/**
	 * Will move the given car in the positive x with speed given. Will stop if
	 * the car is at or over the finish line
	 * 
	 * @param car - The car that should be moved
	 * @param speed - The relative x value the car should move
	 */
	private void driveCar(ImageView car, double speed)
	{
		if (car.getLayoutX() < (finishX - car.getFitWidth()))
		{
			car.setLayoutX(car.getLayoutX() + speed * 2);
		}
	}

	/**
	 * Calculate the x value that the car should be moving every gameTick
	 * 
	 * @param time - The goal time of the car in milliseconds.
	 * @return The x value the car should move every gameTick to reach the
	 *         finish at the right time
	 */
	private double calculateSpeed(double time)
	{
		// 100 is the width of the car
		double distance = finishX - startCarsX - 100;
		double speed = (distance / (time / timerSpeed)) / 2;

		return speed;
	}

	/**
	 * Add all cars to the cars arrayList
	 */
	private void addCars()
	{
		cars.add(ferrari1);
		cars.add(ferrari2);
		cars.add(forceIndia1);
		cars.add(forceIndia2);
		cars.add(haas1);
		cars.add(haas2);
		cars.add(honda1);
		cars.add(honda2);
		cars.add(manor1);
		cars.add(manor2);
		cars.add(williams1);
		cars.add(williams2);
		cars.add(mercedes1);
		cars.add(mercedes2);
		cars.add(redBull1);
		cars.add(redBull2);
		cars.add(renault1);
		cars.add(renault2);
		cars.add(toroRosso1);
		cars.add(toroRosso2);
		cars.add(sauber1);
		cars.add(sauber2);
	}
}
