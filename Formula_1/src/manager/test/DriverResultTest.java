package manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Templates.DriverResult;

public class DriverResultTest
{
	private DriverResult driverResult, driverResultTrue, driverResultFalse;
	private int carId = 5;
	private String name = "Max Verstappen";
	private double time = 12500;
	
	@Before
	public void setUp()
	{
		driverResult = new DriverResult(carId, name, time);
		driverResultTrue = new DriverResult(carId, name, time);
		driverResultFalse = new DriverResult(3, "Lewis Hamilton", 15000);
	}
	
	@Test
	public void testConstructor()
	{
		assertTrue(driverResult instanceof DriverResult);
	}
	@Test
	public void testGetCarId()
	{
		assertEquals(carId, driverResult.getCarId());
	}
	
	@Test
	public void testSetCarId()
	{
		int otherCarId = 10;
		driverResult.setCarId(otherCarId);
		assertEquals(otherCarId, driverResult.getCarId());
	}

	@Test
	public void testGetName()
	{
		assertEquals(name, driverResult.getName());
	}
	
	@Test
	public void testSetName()
	{
		String otherName = "Lewis Hamilton";
		driverResult.setName(otherName);
		assertEquals(otherName, driverResult.getName());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetTime()
	{
		assertEquals(time, driverResult.getTime(), 1);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSetTime()
	{
		double otherTime = 15000;
		driverResult.setTime(otherTime);
		assertEquals(otherTime, driverResult.getTime(), 1);
	}

	@Test
	public void testToString()
	{
		assertEquals("Max Verstappen (5) : 12500.0", driverResult.toString());
	}

	@Test
	public void testEqualsSame()
	{
		assertEquals(driverResult, driverResult);
	}
	
	@Test
	public void testEqualsTrue()
	{
		assertTrue(driverResult.equals(driverResultTrue));
	}
	
	@Test
	public void testEqualsFalse()
	{
		assertNotEquals(driverResult, driverResultFalse);
	}
	
	@Test
	public void testEqualsNotDriverResult()
	{
		assertNotEquals(driverResult, new Object());
	}
	
	@Test
	public void testEqualsNull()
	{
		assertNotEquals(driverResult, null);
	}
	
	@Test 
	public void testOtherName()
	{
		driverResultTrue.setName("Lewis Hamilton");
		assertNotEquals(driverResult, driverResultTrue);
	}
	
	@Test 
	public void testEqualsOtherTime()
	{
		driverResultTrue.setTime(20000);
		assertNotEquals(driverResult, driverResultTrue);
	}
	
	@Test
	public void testEqualsNameNullOtherNotNull()
	{
		driverResult.setName(null);
		assertNotEquals(driverResult, driverResultTrue);
	}
	
	@Test
	public void testEqualsNamesNull()
	{
		driverResult.setName(null);
		driverResultTrue.setName(null);
		assertEquals(driverResult, driverResultTrue);
	}
}
