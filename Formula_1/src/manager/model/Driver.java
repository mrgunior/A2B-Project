package manager.model;

public class Driver {
	
	private String name;
	private int number, speed, acceleration, turning;
	private double salary;

	private double averagePerformance = (speed*acceleration*turning)/3;
	
	public Driver(String name, int number, int speed, int acceleration, int turning, double salary) {
		
		this.setName(name);
		this.setNumber(number);
		this.setSpeed(speed);
		this.setAcceleration(acceleration);
		this.setTurning(turning);
		this.setSalary(salary);
		
		updateAveragePerformance();
	}
	
	public Driver()
	{
		// TODO Set variables to default values
		this.setName("Default Driver Name");
		this.setNumber(999);
		this.setSpeed(999);
		this.setAcceleration(999);
		this.setTurning(999);
		this.setSalary(999);
		
		updateAveragePerformance();
	}

	//Getters
	public String getName(){
		return this.name;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public int getSpeed(){
		return this.speed;
	}
	
	public int getAcceleration(){
		return this.acceleration;
	}
	
	public int getTurning(){
		return this.turning;
	}
	
	public double getAveragePerformance(){
		updateAveragePerformance();
		return this.averagePerformance;
	}
	
	public double getSalary(){
		return this.salary;
	}
	
	//Setters
	public void setName(String name){
		this.name = name;
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
		updateAveragePerformance();
	}
	
	public void setAcceleration(int acceleration){
		this.acceleration = acceleration;
		updateAveragePerformance();
	}
	
	public void setTurning(int turning){
		this.turning = turning;
		updateAveragePerformance();
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	
	// Other methods
	public void updateAveragePerformance(){
		this.averagePerformance = (speed*acceleration*turning)/3;
	}
}
