package manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import manager.model.DriverResult;
import manager.model.Results;

public class ResultsTest
{
	private DriverResult	driverResult1;
	private int				carId1	= 5;
	private String			name1	= "Max Verstappen";
	private double			time1	= 12500;

	private DriverResult	driverResult2;
	private int				carId2	= 3;
	private String			name2	= "Max Verstappen";
	private double			time2	= 15000;

	Results results;

	@Before
	public void setUp() throws Exception
	{
		driverResult1 = new DriverResult(carId1, name1, time1);
		driverResult2 = new DriverResult(carId2, name2, time2);
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
		assertEquals("[Max Verstappen (5) : 12500.0, Max Verstappen (3) : 15000.0]", results.toString());
	}

}
