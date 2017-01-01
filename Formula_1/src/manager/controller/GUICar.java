package manager.controller;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import javafx.scene.image.ImageView;

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

	// Array for all the random points for the car
	private double[] randomPoints;

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

	/**
	 * Setter for X value of the car
	 * 
	 * @param double - X
	 */
	public void setX(double x)
	{
		car.setLayoutX(x);
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
			randomPoints[i] = startCarsX - car.getFitWidth() + ((finishX - startCarsX) / (nPoints + 2) * (i + 2));
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
	public void moveCar()
	{
		// Check if the car has crossed the finish line
		if (getX() < (finishX - car.getFitWidth()))
		{
			setX(getX() + carSpeed);
		}
		else
		{
			RaceController.setTimerRunning(false);
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
		if (currentGoalPoint == nPoints)
		{
			distance -= car.getFitWidth();
		}

		// Time is the time the from one point to another (goalTime / all
		// points) divided by the time of one frame (1000 /
		// RaceController.getFps())
		double time = ((goalTime / (nPoints + 1)) / (1000 / RaceController.getFps()));

		// Speed is the distance divided by time
		double speed = (distance / time);

		return speed;
	}
}
