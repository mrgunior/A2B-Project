package manager.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import manager.controller.GameController;

public class Profile
{
	private double						highScore;
	private static double				budget;
	private String						teamName;
	private static List<Driver>			drivers;
	private static Car					car;
	private static ArrayList<Driver>	allDrivers;
	private static int					strategy;	// 1 = low risk, 2 = medium risk, 3 = high risk

	private static int	currentRace		= 1;
	private static int	currentSeason	= 1;
	private static int	racesPerSeason	= 2;
	private static int	teamID;

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

	public static List<Driver> getDrivers()
	{
		return drivers;
	}

	public static ArrayList<Driver> getAllDrivers()
	{
		return allDrivers;
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
		Profile.drivers = drivers;
	}

	public void setAllDrivers(ArrayList<Driver> drivers)
	{
		Profile.allDrivers = drivers;
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

	public static int getCurrentRace()
	{
		return currentRace;
	}

	public static void setCurrentRace(int currentRace)
	{
		Profile.currentRace = currentRace;
	}

	public static int getCurrentSeason()
	{
		return currentSeason;
	}

	public static void setCurrentSeason(int currentSeason)
	{
		Profile.currentSeason = currentSeason;
	}

	public static int getRacesPerSeason()
	{
		return racesPerSeason;
	}

	public static void setRacesPerSeason(int racesPerSeason)
	{
		Profile.racesPerSeason = racesPerSeason;
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

	public static int getTeamID()
	{
		return teamID;
	}

	public static void setTeamID(int teamID)
	{
		Profile.teamID = teamID;
	}

}
