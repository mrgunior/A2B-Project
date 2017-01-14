package manager.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import manager.controller.GameController;

public class Profile 
{
	private double highScore;
	private static double budget;
	private String teamName;
	private List<Driver> drivers;
	private static Car car;
	private ArrayList<Driver> allDrivers;
	
	public Profile(double highScore, double budget, String teamName){
		this.highScore = highScore;
		Profile.budget = budget;
		this.teamName = teamName;
	}

	//Getters
	public double getHighScore(){
		return this.highScore;
	}
	
	public String getTeamName(){
		return this.teamName;
	}
	
	public static double getBudget(){
		return budget;
	}
	
	public List<Driver> getDrivers(){
		return this.drivers;
	}
	
	public ArrayList<Driver> getAllDrivers(){
		return this.allDrivers;
	}
	
	public static Car getCar(){
		return car;
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
	public static void setBudget(double amount, boolean state){
		
		//if state is true subtract amount from budget
		if(amount<0)
		{
			amount = -1*amount;
		}
		
		if(state)
		{
			budget -= amount;
		}
		
		//else state is false and amount gets added to budget
		else
		{
			budget += amount;
		}
	}
	
	public static void setBudget(double amount)
	{
		budget = amount;
	}
	
	public void setDrivers(List<Driver> drivers){
		this.drivers = drivers;
	}
	
	public void setAllDrivers(ArrayList<Driver> drivers){
		this.allDrivers = drivers;
	}
	
	public void setCar(Car car){
		this.car = car;
	}
	
	public void resetDriverPoints()
	{
		System.out.println("Resetting drivers...");
		allDrivers.get(1).setPoints(999);
		for (int i = 0; i < allDrivers.size(); i++)
		{
			System.out.println("Before: " + allDrivers.get(i));
			allDrivers.get(i).setPoints(0);
			System.out.println("After: " + allDrivers.get(i));
			System.out.println();
		}
		
		try
		{
			GameController.writeDriversToJSON();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Drivers reset");
		System.out.println(allDrivers);
		
	}
	
	public void sortDriversById()
	{
		Collections.sort(drivers, Driver.sortById());
	}
	
	public void sortDriversByPoints()
	{
		drivers.sort(Driver.sortByPoints());
	}


}
