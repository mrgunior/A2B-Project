package manager.model;

import java.util.Comparator;

public class DriverResult
{
	/**
	 * Variables for a single result of a driver (carId is for race simulation)
	 */
	private int		carId	= 0;
	private Driver driver;
	private double	time	= 0;

	/**
	 * Getter for car ID
	 * 
	 * @return int - Car ID
	 */
	public int getCarId()
	{
		return carId;
	}
	
	/**
	 * Setter for car ID
	 * @param carId - Car ID to set for the DriverResult
	 */
	public void setCarId(int carId)
	{
		this.carId = carId;
	}

	/**
	 * Getter for driver Name
	 * 
	 * @return String - Driver name
	 */
	public String getName()
	{
		return driver.getName();
	}

	public Driver getDriver()
	{
		return driver;
	}

	public void setDriver(Driver driver)
	{
		this.driver = driver;
	}

	/**
	 * Getter for result time
	 * 
	 * @return double - Result time
	 */
	public double getTime()
	{
		return time;
	}
	
	/**
	 * Setter for carId
	 * @param time - Time to set for the DriverResult
	 */
	public void setTime(double time)
	{
		this.time = time;
	}

	/**
	 * Constructor for a Driver Result
	 * 
	 * @param carId - int, car ID for the simulation
	 * @param driver - String, driver name
	 * @param time - double, result time
	 */
	public DriverResult(int carId, Driver driver, double time)
	{
		this.carId = carId;
		this.driver = driver;
		this.time = time;
	} 

	


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DriverResult other = (DriverResult) obj;
		if (carId != other.carId) {
			return false;
		}
		if (driver == null) {
			if (other.driver != null) {
				return false;
			}
		} else if (!driver.equals(other.driver)) {
			return false;
		}
		if (Double.doubleToLongBits(time) != Double.doubleToLongBits(other.time)) {
			return false;
		}
		return true;
	}

	/**
	 * Converts the DriverResult object into a string
	 * 
	 * @return String - DriverResult object in string format
	 */
	public String toString()
	{
		return (driver.getName() + " (" + carId + ") : " + time);
	}

	/**
	 * Returns the Comparator to sort by result time from low to high
	 * 
	 * @return Comparator - Compares by time
	 */
	static Comparator<DriverResult> getTimeComparator()
	{
		return new Comparator<DriverResult>()
		{
			@Override
			public int compare(DriverResult dR1, DriverResult dR2)
			{
				return (int) (dR1.getTime() - dR2.getTime());
			}
		};
	}

	/**
	 * Returns the Comparator to sort by car ID from low to high
	 * 
	 * @return Comparator - Compares by car ID
	 */
	static Comparator<DriverResult> getCarIdComparator()
	{
		return new Comparator<DriverResult>()
		{
			@Override
			public int compare(DriverResult dR1, DriverResult dR2)
			{
				return (int) (dR1.getCarId() - dR2.getCarId());
			}
		};
	}
}
