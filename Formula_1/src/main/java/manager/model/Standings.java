package main.java.manager.model;

import java.util.ArrayList;
import java.util.Collections;

public class Standings
{
	private static ArrayList<Integer> standings;
	
	public Standings()
	{
		standings = new ArrayList<Integer>();
		setEmptyStandings();
		calculateStandings();
	}
	
	public ArrayList<Integer> getStandings()
	{
		calculateStandings();
		return standings;
	}
	
	private static void calculateStandings()
	{
		ArrayList<Driver> drivers = GameController.getDrivers("./data/drivers.json");
		
		for (int i = 1; i <= 11; i++)
		{
			for (int j = 0; j < drivers.size(); j++)
			{
				if (drivers.get(j).getTeamId() == i)
				{
					int current = standings.get(i-1);
					standings.set(i-1, current + drivers.get(j).getPoints());
				}
			}
		}
	}
	
	private void setEmptyStandings()
	{
		for (int i = 0; i < 11; i++)
		{
			standings.add(i, 0);
		}
	}
	
	public int getMaxScore()
	{
		return Collections.max(standings);
	}
	
	public String toString()
	{
		return standings.toString();
	}
}
