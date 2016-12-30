package manager.test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import manager.model.Driver;

public class DriverTest 
{
	private Driver driver;
	private String name;
	private int number, speed, acceleration, turning;
	private double averagePerformance, salary;

	@Before
	public void setUp() throws Exception 
	{
		driver = new Driver();
		name = "Victor Wernet";
		number = 33;
		speed = 80;
		acceleration = 75;
		turning = 69;
		averagePerformance = 78.6;
		salary = 3.0; //3 mil
		
		//just updating the fields of the driver object.
		driver.setName(name);
		driver.setNumber(number);
		driver.setSpeed(speed);
		driver.setAcceleration(acceleration);
		driver.setTurning(turning);
		driver.setAveragePerformance(averagePerformance);
		driver.setSalary(salary);
	}
	
	@Test
	public void testGetName()
	{
		assertEquals(driver.getName(), name);
	}
	
	@Test
	public void testGetNumber()
	{
		assertEquals(driver.getNumber(), number);
	}
	
	@Test
	public void testGetSpeed()
	{
		assertEquals(driver.getSpeed(), speed);
	}
	
	@Test
	public void testGetAcceleration()
	{
		assertEquals(driver.getAcceleration(), acceleration);
	}
	
	@Test
	public void testGetTurning()
	{
		assertEquals(driver.getTurning(), turning);
	}
	
	@Test
	public void testGetAveragePerformance()
	{
		assertEquals(driver.getAveragePerformance(), averagePerformance, 0.001);
	}
	
	@Test
	public void testGetSalary()
	{
		assertEquals(driver.getSalary(), salary, 0.001);
	}
}