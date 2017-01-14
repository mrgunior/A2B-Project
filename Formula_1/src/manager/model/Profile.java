package manager.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import manager.controller.GameController;

public class Profile
{
	private double				highScore;
	private static double		budget;
	private String				teamName;
	private List<Driver>		drivers;
	private static Car			car;
	private ArrayList<Driver>	allDrivers;
	private static int			strategy;	// 1 = low risk, 2 = medium risk, 3 = high risk

	public Profile(double highScore, double budget, String teamName)
	{
		this.highScore = highScore;
		Profile.budget = budget;
		this.teamName = teamName;
	}

	// Getters
	public double getHighScore()
	{
		return this.highScore;
	}

	public String getTeamName()
	{
		return this.teamName;
	}

	public static double getBudget()
	{
		return budget;
	}

	public List<Driver> getDrivers()
	{
		return this.drivers;
	}

	public ArrayList<Driver> getAllDrivers()
	{
		return this.allDrivers;
	}

	public static Car getCar()
	{
		return car;
	}

	public static int getStrategy()
	{
		return strategy;
	}

	// Setters
	public void setHighScore(double score)
	{
		this.highScore += score;
	}

	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}

	// Since the budget gets updated when the player uses it for upgrades or
	// Wins cash, we will use true for subtractions and false for addition.
	public static void setBudget(double amount, boolean state)
	{

		// if state is true subtract amount from budget
		if (amount < 0)
		{
			amount = -1 * amount;
		}

		if (state)
		{
			budget -= amount;
		}

		// else state is false and amount gets added to budget
		else
		{
			budget += amount;
		}
	}

	public static void setBudget(double amount)
	{
		budget = amount;
	}

	public void setDrivers(List<Driver> drivers)
	{
		this.drivers = drivers;
	}

	public void setAllDrivers(ArrayList<Driver> drivers)
	{
		this.allDrivers = drivers;
	}

	public void setCar(Car car)
	{
		Profile.car = car;
	}

	public static void setStrategy(int strategy)
	{
		if (strategy >= 1 && strategy <= 3)
		{
			Profile.strategy = strategy;
		}
	}

	public void resetProfile()
	{
		resetDriverPoints();
		resetDriverSalaryBonus();
		resetCarUpgrades();
		
		try
		{
			GameController.writeDriversToJSON();
			formulaApplication.getGameController().writeJsonObjectToFile();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void resetDriverPoints()
	{
		for (int i = 0; i < allDrivers.size(); i++)
		{
			allDrivers.get(i).setPoints(0);
		}
		
		System.out.println("All driver points have been reset...");
	}

	public void resetDriverSalaryBonus()
	{
		for (int i = 0; i < allDrivers.size(); i++)
		{
			allDrivers.get(i).setSalaryBonus(1.0);
			allDrivers.get(i).calculateSalary();
		}

		System.out.println("All driver salaries have been reset...");
	}
	
	public void resetCarUpgrades()
	{
		// Set all car stats to 50
		car.setAcceleration(50);
		car.setBraking(50);
		car.setHandling(50);
		car.setSpeed(50);
		car.setWeight(50);
		// Set all upgrades to 0 with an Upgrades object where all the upgrades are level
		car.setUpgrades(new Upgrades(0));
		
		System.out.println("Current car's upgrades have been reset...");
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
