package manager.model;

import java.util.List;

public class Profile 
{
	private double highScore, budget;
	private String teamName;
	private List<Driver> drivers;
	private List<Car> cars;
	
	public Profile(double highScore, double budget, String teamName){
		this.highScore = highScore;
		this.budget = budget;
		this.teamName = teamName;
	}

	//Getters
	public double getHighScore(){
		return this.highScore;
	}
	
	public String getTeamName(){
		return this.teamName;
	}
	
	public double getBudget(){
		return this.budget;
	}
	
	public List<Driver> getDrivers(){
		return this.drivers;
	}
	
	public List<Car> getCars(){
		return this.cars;
	}
	
	//Setters
	public void setHighScore(double score){
		this.highScore += score;
	}
	
	public void setTeamName(String teamName){
		this.teamName = teamName;
	}
	
	//Since the budget gets updated when the player uses it for upgrades or
	//Wins cash, we will use true for subtractions and false for addition.
	public void setBudget(double amount, boolean state){
		
		//if state is true subtract amount from budget
		if(amount<0)
		{
			amount = -1*amount;
		}
		
		if(state)
		{
			this.budget -= amount;
		}
		
		//else state is false and amount gets added to budget
		else
		{
			this.budget += amount;
		}
	}
	
	public void setDrivers(List<Driver> drivers){
		this.drivers = drivers;
	}
	
	public void setCars(List<Car> cars){
		this.cars = cars;
	}
}
