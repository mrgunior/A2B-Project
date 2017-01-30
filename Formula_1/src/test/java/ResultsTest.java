package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.manager.model.Driver;
import main.java.manager.model.DriverResult;
import main.java.manager.model.Results;

public class ResultsTest
{
	private DriverResult	driverResult1;
	private int				carId1	= 5;
	private double			time1	= 12500;

	private DriverResult	driverResult2;
	private int				carId2	= 3;
	private double			time2	= 15000;

	private Driver driver1;
	private String name1;
	private int id1, teamId1, points1, number1, speed1, acceleration1, turning1;
	private double salary1;
	
	private Driver driver2;
	private String name2;
	private int id2, teamId2, points2, number2, speed2, acceleration2, turning2;
	private double salary2;
	
	Results results;

	@Before
	public void setUp() throws Exception
	{
		name1 = "Victor Wernet";
		id1 = 1;
		teamId1 = 2;
		points1 = 20;
		number1 = 33;
		speed1 = 80;
		acceleration1 = 75;
		turning1 = 69;
		salary1 = 3.0; //3 mil
		
		name2 = "Mika Kuijpers";
		id2 = 2;
		teamId2 = 3;
		points2 = 21;
		number2 = 34;
		speed2 = 81;
		acceleration2 = 76;
		turning2 = 70;
		salary2 = 4.0; //3 mil
		
		driver1 = new Driver(id1, teamId1, name1, points1, number1, speed1, acceleration1, turning1, salary1);
		driver2 = new Driver(id2, teamId2, name2, points2, number2, speed2, acceleration2, turning2, salary2);
		
		driverResult1 = new DriverResult(carId1, driver1, time1);
		driverResult2 = new DriverResult(carId2, driver2, time2);
		results = new Results();
	}

	@Test
	public void testResults()
	{
		assertTrue(results instanceof Results);
	}

	@Test
	public void testAddResult()
	{
		results.addResult(driverResult1);
		assertEquals(1, results.getResults().size());
	}

	@Test
	public void testGetResult()
	{
		results.addResult(driverResult1);
		assertEquals(driverResult1, results.getResult(0));
	}

	@Test
	public void testGetResultsSize()
	{
		results.addResult(driverResult1);
		assertEquals(1, results.getResults().size());
		results.addResult(driverResult2);
		assertEquals(2, results.getResults().size());
	}

	@Test
	public void testGetResults()
	{
		results.addResult(driverResult1);
		assertEquals(driverResult1, results.getResults().get(0));
	}

	@Test
	public void testSortResultsByTime()
	{
		results.addResult(driverResult1);
		results.addResult(driverResult2);
		results.sortResultsByTime();
		assertTrue(Double.compare(results.getResult(0).getTime(), results.getResult(1).getTime()) < 0);
	}

	@Test
	public void testSortResultsByCarId()
	{
		results.addResult(driverResult1);
		results.addResult(driverResult2);
		results.sortResultsByCarId();
		assertTrue(results.getResult(0).getCarId() < results.getResult(1).getCarId());
	}

	@Test
	public void testToString()
	{
		results.addResult(driverResult1);
		results.addResult(driverResult2);
		assertEquals("[Victor Wernet (5) : 12500.0, Mika Kuijpers (3) : 15000.0]", results.toString());
	}

}
