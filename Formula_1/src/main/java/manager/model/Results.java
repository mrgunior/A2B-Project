package main.java.manager.model;

import java.util.ArrayList;
import java.util.Collections;

public class Results
{
	/**
	 * Variables for a Results object ArrayList results stores all the
	 * DriverResult objects trackName stores the trackName
	 */
	ArrayList<DriverResult>	results;
	String					trackName	= "";

	/**
	 * Constructor for Results Initializes the results ArrayList
	 */
	public Results()
	{
		results = new ArrayList<DriverResult>();
	}

	// Used for testing Results object:
	// public static void main(String[] args)
	// {
	// Results results = new Results();
	//
	// DriverResult result1 = new DriverResult(4, "Result 1", 1000);
	// DriverResult result2 = new DriverResult(6, "Result 2", 3000);
	// DriverResult result3 = new DriverResult(2, "Result 3", 2000);
	//
	// results.addResult(result1);
	// results.addResult(result2);
	// results.addResult(result3);
	//
	// results.sortResultsByCarId();
	//
	// System.out.println(results.toString());
	// }

	/**
	 * Getter for the DriverResult at a certain index, usually used when the
	 * results are sorted by carID
	 * 
	 * @param index - Index
	 * @return DriverResult - The DriverResult located a the given index
	 */
	public DriverResult getResult(int index)
	{
		return results.get(index);
	}
	
	public int getLength() {
		return results.size();
	}

	/**
	 * Getter for all DriverResult objects
	 * 
	 * @return ArrayList - An ArrayList of DriverResult objects
	 */
	public ArrayList<DriverResult> getResults()
	{
		return results;
	}

	/**
	 * Add a DriverResult to the Results object
	 * 
	 * @param driverResult - DriverResult object to be added
	 */
	public void addResult(DriverResult driverResult)
	{
		results.add(driverResult);
	}

	/**
	 * Sort the ArrayList inside the Results objects by result time
	 */
	public void sortResultsByTime()
	{
		Collections.sort(results, DriverResult.getTimeComparator());
	}
	/**
	 * Sort the ArrayList inside the Results objects by car ID
	 */
	public void sortResultsByCarId()
	{
		Collections.sort(results, DriverResult.getCarIdComparator());
	}

	/**
	 * Return a string format of a Results object
	 * @return String - String format of Results object
	 */
	public String toString()
	{
		return results.toString();
	}
}
