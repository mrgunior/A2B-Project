package manager.model;

import java.util.Comparator;

public class Driver
{

	private String	name;
	private int		id, teamId, points, number, speed, acceleration, turning;
	private double	salary;
	private double	salaryBonus	= 1;
	private double	averagePerformance;
	
	double salaryFactor = 3;

	public Driver(int id, int teamId, String name, int points, int number, int speed, int acceleration, int turning, double salary)
	{
		this.id = id;
		this.teamId = teamId;
		this.name = name;
		this.points = points;
		this.number = number;
		this.speed = speed;
		this.acceleration = acceleration;
		this.turning = turning;
		this.salary = salary;
		calculateAveragePerformance();
	}

	// Getters
	public String getName()
	{
		return this.name;
	}

	public int getPoints()
	{
		return this.points;
	}

	public int getId()
	{
		return id;
	}

	public int getTeamId()
	{
		return teamId;
	}

	public int getNumber()
	{
		return this.number;
	}

	public int getSpeed()
	{
		return this.speed;
	}

	public int getAcceleration()
	{
		return this.acceleration;
	}

	public int getTurning()
	{
		return this.turning;
	}

	public void calculateAveragePerformance()
	{
		this.averagePerformance = (speed + acceleration + turning) / 3;
	}

	public double getAveragePerformance()
	{
		calculateAveragePerformance();
		return averagePerformance;
	}
	
	public void setAveragePerformance(double averagePerformance)
	{
		this.averagePerformance = averagePerformance;
	}
	
	public void salaryPercentageBonus(double percentage)
	{
		this.salaryBonus += (percentage/100);
	}
	
	public double getSalaryPercentageBonus()
	{
		return this.salaryBonus;
	}
	
	public double getSalaryFactor()
	{
		return salaryFactor;
	}

	public void calculateSalary()
	{
		calculateAveragePerformance();
		double avgPerf = getAveragePerformance();
		
		this.salary = ((Math.pow(avgPerf,3.4) * salaryFactor * salaryBonus)/2);
	}

	public double getSalary()
	{
		calculateSalary();
		return this.salary;
	}
	
	public double getSalaryBonus()
	{
		return this.salaryBonus;
	}

	// Setters
	public void setName(String name)
	{
		this.name = name;
	}

	public void setPoints(int points)
	{
		this.points = points;
	}

	public void addPoints(int points)
	{
		this.points += points;
	}
	
	public int getAddPoints()
	{
		return this.points;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setTeamId(int teamId)
	{
		this.teamId = teamId;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public void setAcceleration(int acceleration)
	{
		this.acceleration = acceleration;
	}

	public void setTurning(int turning)
	{
		this.turning = turning;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	public void setSalaryBonus(double salaryBonus)
	{
		this.salaryBonus = salaryBonus;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Driver)) {
			return false;
		}
		Driver other = (Driver) obj;
		if (acceleration != other.acceleration) {
			return false;
		}
		if (Double.doubleToLongBits(averagePerformance) != Double.doubleToLongBits(other.averagePerformance)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (name == null && (other.getName() != null)) {
			return false;
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (number != other.number) {
			return false;
		}
		if (points != other.points) {
			return false;
		}
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary)) {
			return false;
		}
		if (Double.doubleToLongBits(salaryBonus) != Double.doubleToLongBits(other.salaryBonus)) {
			return false;
		}
		if (speed != other.speed) {
			return false;
		}
		if (teamId != other.teamId) {
			return false;
		}
		if (turning != other.turning) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the Comparator to sort by Id
	 * 
	 * @return Comparator - Compares by time
	 */
	public static Comparator<Driver> sortById()
	{
		return new Comparator<Driver>()
		{
			@Override
			public int compare(Driver d1, Driver d2)
			{
				return (int) (d1.getId() - d2.getId());
			}
		};
	}

	/**
	 * Returns the Comparator to sort by points
	 * 
	 * @return Comparator - Compares by time
	 */
	public static Comparator<Driver> sortByPoints()
	{
		return new Comparator<Driver>()
		{
			@Override
			public int compare(Driver d1, Driver d2)
			{
				return (int) (d2.getPoints() - d1.getPoints());
			}
		};
	}

	@Override
	public String toString()
	{
		return "Driver [name=" + name + ", id=" + id + ", teamId=" + teamId + ", points=" + points + ", number=" + number + ", speed="
				+ speed + ", acceleration=" + acceleration + ", turning=" + turning + ", salary=" + salary + ", averagePerformance="
				+ averagePerformance + "]";
	}
}
