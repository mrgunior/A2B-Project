package manager.model;

public class Driver
{

	private String	name;
	private int		id, teamId, number, speed, acceleration, turning;
	private double	salary;
	private double	averagePerformance;

	public Driver(int id, int teamId, String name, int number, int speed, int acceleration, int turning, double salary)
	{
		this.id = id;
		this.teamId = teamId;
		this.name = name;
		this.number = number;
		this.speed = speed;
		this.acceleration = acceleration;
		this.turning = turning;
		this.salary = salary;
		this.averagePerformance = getAveragePerformance();
	}

	// Getters
	public String getName()
	{
		return this.name;
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

	public double getAveragePerformance()
	{
		// some how this wasn't working as a field
		// so I changed it. A bug?

		this.averagePerformance = (speed + acceleration + turning) / 3;
		// System.out.println(this.averagePerformance);

		return this.averagePerformance;
	}

	public double getSalary()
	{
		return this.salary;
	}

	// Setters
	public void setName(String name)
	{
		this.name = name;
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

	@Override
	public String toString()
	{
		return "Driver [name=" + name + ", id=" + id + ", teamId=" + teamId + ", number=" + number + ", speed=" + speed
				+ ", acceleration=" + acceleration + ", turning=" + turning + ", salary=" + salary
				+ ", averagePerformance=" + averagePerformance + "]";
	}

}
