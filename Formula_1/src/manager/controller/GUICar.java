package manager.controller;

import java.util.Random;

import javafx.scene.image.ImageView;
import manager.GUIController.RaceController;

public class GUICar
{
	// Car image corresponding to this object
	private ImageView car;

	// X values for finish and start position
	private double	finishX		= RaceController.getFinishX();
	private double	startCarsX	= RaceController.getStartCarsX();

	// goalTime: time to cross the finish.
	// nPoints: the amount of randomization points
	// currentGoalPoint: the point of the array of points the car is currently
	// going towards
	private double	goalTime;
	private int		nPoints				= 5;
	private int		currentGoalPoint	= 0;

	// Speed of the car
	public double carSpeed;
	
	public boolean driving = true;
	private boolean isFinished = false;

	// Array for all the random points for the car
	private double[] randomPoints;
	
	
	// Testing for drivername next to car
	/*
	private String driverName = "TEST123";
	Text driverNameText;
	*/

	public GUICar(ImageView car, double goalTime)
	{
		this.car = car;
		this.goalTime = goalTime;
		// Randomize amount of points for each car
		nPoints += Math.random() * 5;
		randomPoints = new double[nPoints + 1];

		// Set starting position
		setX(startCarsX);

		// Generate all the random points
		generatePoints();

		// Calculate speed
		carSpeed = calculateSpeed();
	}
	
	public GUICar(ImageView car, double goalTime, String driverName)
	{
		this.car = car;
		this.goalTime = goalTime;
		// Randomize amount of points for each car
		nPoints += Math.random() * 5;
		randomPoints = new double[nPoints + 1];

		// Set starting position
		setX(startCarsX);

		// Generate all the random points
		generatePoints();

		// Calculate speed
		carSpeed = calculateSpeed();
		
		
		
		// Testing for driver name next to car
		/*
		this.driverName = driverName;
		driverNameText = new Text(car.getLayoutX()-50, car.getLayoutY(), driverName);
		driverNameText.setLayoutX(car.getLayoutX()-50);
		driverNameText.setLayoutY(car.getLayoutY());
		driverNameText.setText(driverName);
		*/
	}

	/**
	 * Setter for X value of the car
	 * 
	 * @param double - X
	 */
	public void setX(double x)
	{
		car.setLayoutX(x);
		
		// Testing for driver name next to car
		/*
		driverNameText.setLayoutX(car.getLayoutX()-50);
		driverNameText.setLayoutY(car.getLayoutY());
		driverNameText.setText(driverName);
		
		RaceController.addNode(driverNameText);
		*/
	}

	/**
	 * Getter for X value of the car
	 * 
	 * @return double - X
	 */
	public double getX()
	{
		return car.getLayoutX();
	}
	
	public boolean isFinished()
	{
		return isFinished;
	}

	/**
	 * Generate random points for the car to move towards. Without random points
	 * the car would just be going in a straight line. With these random points
	 * the cars will have some random behaviour and overtake eachother.
	 */
	private void generatePoints()
	{
		// Create all the points at the correct interval
		for (int i = 0; i < randomPoints.length; i++)
		{
			randomPoints[i] = startCarsX - (car.getFitWidth()*car.getScaleX()) + ((finishX - startCarsX) / (nPoints + 2) * (i + 2));
		}

		// Randomize all points
		for (int i = 0; i < randomPoints.length; i++)
		{
			randomPoints[i] = ((Math.random() - 0.5) * (randomPoints[i] / (nPoints * 1.5)) + randomPoints[i]);
		}

		// Last point is the finish line
		randomPoints[nPoints] = finishX;
	}

	/**
	 * Move the car will the car has reached the finish line. Recalculate speed
	 * if the car has reached a point.
	 */
	double speed = 2 * Random();
	boolean crashed = false;;
	
	public void moveCar()
	{
		// Check if the car has crossed the finish line
		if (goalTime >= 99999) {
			isFinished = true;
			double random = Random();
			if (random < 0.496 || random > 0.504) {
				if (!crashed) {
					setX(getX() + carSpeed);
				}
			} else {
				crashed = true;
			}
		} else {
		if (getX() < (finishX - (car.getFitWidth())))
		{
			if (RaceController.isRaceStarted())
			{
				if (carSpeed != 9999999) {
					setX(getX() + carSpeed);
				}
			}
		}
		else
		{
			//setX(finishX - (car.getFitWidth()));
			isFinished = true;
			carSpeed = calculateSpeed();
		}
		}

		// If the car is past its current goal point, goto next point and
		// recalculate speed
		if (getX() > randomPoints[currentGoalPoint])
		{
			if (currentGoalPoint < nPoints)
			{
				currentGoalPoint++;
			}
			carSpeed = calculateSpeed();
		}
	}

	private double Random() {
		Random value = new Random();
		double random = value.nextDouble();
		return random;
	}

	/**
	 * Calculate the speed of the car to arrive at the destination at a given
	 * time
	 * 
	 * @return double - Speed of the car
	 */
	private double calculateSpeed()
	{
		// Distance from the car to the current point
		double distance = randomPoints[currentGoalPoint] - getX();
		double speed = 0;
		if (currentGoalPoint == nPoints)
		{
			distance -= (car.getFitWidth()*car.getScaleX());
			car.setLayoutX(car.getLayoutX() + 2);
			
		}

		// Time is the time the from one point to another (goalTime / all
		// points) divided by the time of one frame (1000 /
		// RaceController.getFps())
		if (goalTime <= 9999999){
			// Speed is the distance divided by time
			double time = ((goalTime / (nPoints + 1)) / (1000 / RaceController.getFps()));
			speed = (distance / time);
		} else {
			Random value = new Random();
			speed = 2 + (4 - 2) * value.nextDouble();
		}
		return speed;
	}
	
	public String toString()
	{
		return car.toString();
	}
}
