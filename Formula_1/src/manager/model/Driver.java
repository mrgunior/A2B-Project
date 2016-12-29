package manager.model;

public class Driver {
	
	private String name;
	private int number, speed, acceleration, turning;
	private double averagePerformance, salary;
	
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
	}
	
	public void setAcceleration(int acceleration){
		this.acceleration = acceleration;
	}
	
	public void setTurning(int turning){
		this.turning = turning;
	}
	
	public void setAveragePerformance(double averagePerformance){
		this.averagePerformance = averagePerformance;
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
}
