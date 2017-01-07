package Templates;

import java.util.ArrayList;
import java.util.Collections;

import manager.model.Driver;

public class Results
{
	ArrayList<DriverResult> results;
	String trackName = "";

	public Results()
	{
		results = new ArrayList<DriverResult>();
	}

	public static void main(String[] args)
	{
		Results results = new Results();

		DriverResult result1 = new DriverResult(12, "Result 1", 1000);
		DriverResult result2 = new DriverResult(33, "Result 2", 3000);
		DriverResult result3 = new DriverResult(20, "Result 3", 2000);

		results.addResult(result1);
		results.addResult(result2);
		results.addResult(result3);

		results.sortResults();

		System.out.println(results.toString());
	}

	public DriverResult getResult(int place)
	{
		return results.get(place);
	}

	public ArrayList<DriverResult> getResults()
	{
		return results;
	}

	public void addResult(DriverResult driverResult)
	{
		results.add(driverResult);
	}

	public void sortResults()
	{
		Collections.sort(results, new DriverResult());
	}

	public String toString()
	{
		return results.toString();
	}
}
