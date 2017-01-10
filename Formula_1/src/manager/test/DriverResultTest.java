package manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import manager.model.Driver;
import manager.model.DriverResult;

public class DriverResultTest
{
	private DriverResult driverResult, driverResultTrue, driverResultFalse;
	private int carId = 5;
	private double time = 12500;
	
	private Driver driver;
	private String name;
	private int id, teamId, points, number, speed, acceleration, turning;
	private double salary;
	
	private Driver driver2;
	private String name2;
	private int id2, teamId2, points2, number2, speed2, acceleration2, turning2;
	private double salary2;
	
	
	
	@Before
	public void setUp()
	{
		name = "Victor Wernet";
		id = 1;
		teamId = 2;
		points = 20;
		number = 33;
		speed = 80;
		acceleration = 75;
		turning = 69;
		salary = 3.0; //3 mil
		
		name2 = "Mika Kuijpers";
		id2 = 2;
		teamId2 = 3;
		points2 = 21;
		number2 = 34;
		speed2 = 81;
		acceleration2 = 76;
		turning2 = 70;
		salary2 = 4.0; //3 mil
		
		driver = new Driver(id, teamId, name, points, number, speed, acceleration, turning, salary);
		driver2 = new Driver(id2, teamId2, name2, points2, number2, speed2, acceleration2, turning2, salary2);
		
		driverResult = new DriverResult(carId, driver, time);
		driverResultTrue = new DriverResult(carId, driver, time);
		driverResultFalse = new DriverResult(3, driver2, 15000);
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
		driverResult.getDriver().setName(otherName);
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
		assertEquals("Victor Wernet (5) : 12500.0", driverResult.toString());
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
		driverResultTrue.getDriver().setName("Lewis Hamilton");
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
		driverResult.getDriver().setName(null);
		assertNotEquals(driverResult, driverResultTrue);
	}
	
	@Test
	public void testEqualsNamesNull()
	{
		driverResult.getDriver().setName(null);
		driverResultTrue.getDriver().setName(null);
		assertEquals(driverResult, driverResultTrue);
	}
}
