package manager.test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import manager.model.Driver;

public class DriverTest 
{
	private Driver driver;
	private String name;
	private int id, teamId, points, number, speed, acceleration, turning;
	private double averagePerformance, salary;

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
		averagePerformance = 74.0; //(speed*acceleration*turning)/3
		salary = 3.0; //3 mil
		
		driver = new Driver(id, teamId, name, points, number, speed, acceleration, turning, salary);
	}
	
	@Test
	public void testGetName()
	{
		assertEquals("driver name has been initialized correctly via constructor", driver.getName(), name);
	}
	
	@Test
	public void testSetName()
	{
		driver.setName("Bob");
		assertTrue("driver name has been set correctly via setName()", driver.getName().equals("Bob"));
	}
	

	@Test
	public void testGetPoints()
	{
		assertEquals("driver points has been initialized correctly via constructor", driver.getPoints(), points);
	}
	
	@Test
	public void testSetPoints()
	{
		driver.setPoints(10);
		assertTrue("driver points has been set correctly via setPoints()", driver.getPoints()==10);
	}
	
	@Test
	public void testGetId()
	{
		assertEquals("driver id has been initialized correctly via constructor", driver.getId(), id);
	}
	
	@Test
	public void testSetId()
	{
		driver.setId(10);
		assertTrue("driver id has been set correctly via setId()", driver.getId()==10);
	}
	
	@Test
	public void testgetTeamId()
	{
		assertEquals("driver team id has been initialized correctly via constructor", driver.getTeamId(), teamId);
	}
	
	@Test
	public void testSetTeamId()
	{
		driver.setTeamId(10);
		assertTrue("driver team id has been set correctly via setTeamId()", driver.getTeamId()==10);
	}

	@Test
	public void testSalaryPercentageBonus()
	{
		double value = 1.01;
		driver.salaryPercentageBonus(1);
		assertEquals("driver salary percentage bonus been initialized correctly via method", driver.getSalaryPercentageBonus(), value, 0.01);
	}
	
	@Test
	public void testgetSalaryBonus()
	{
		assertEquals("driver salary bonus is correctly fixed", driver.getSalaryBonus(), 1, 0.01);
	}
	

	@Test
	public void testGetAddPoints()
	{
		driver.addPoints(1);
		assertEquals("driver points been initialized correctly via method", driver.getAddPoints(), 21);
	}
	
	@Test
	public void testSetSalaryBonus()
	{
		driver.setSalaryBonus(10);
		assertTrue("driver salary bonus is correctly fixed via method", driver.getSalaryBonus()==10);
	}
	
	@Test
	public void testGetNumber()
	{
		assertEquals("driver name has been initialized correctly via constructor", driver.getNumber(), number);
	}
	
	@Test
	public void testSetNumber()
	{
		driver.setNumber(1);
		assertTrue("driver number has been set correctly via setNumber()", driver.getNumber()==1);
	}
	
	@Test
	public void testGetSpeed()
	{
		assertEquals("driver speed has been initialized correctly via constructor", driver.getSpeed(), speed);
	}
	
	@Test
	public void testSetSpeed()
	{
		driver.setSpeed(1);
		assertTrue("driver speed has been set correctly via setSpeed()", driver.getSpeed()==1);
	}
	
	@Test
	public void testGetAcceleration()
	{
		assertEquals("driver acceleration has been initialized correctly via constructor", driver.getAcceleration(), acceleration);
	}
	
	@Test
	public void testSetAcceleration()
	{
		driver.setAcceleration(1);
		assertTrue("driver acceleration has been set correctly via setAcceleration()", driver.getAcceleration()==1);
	}
	
	@Test
	public void testGetTurning()
	{
		assertEquals("driver turning has been initialized correctly via constructor", driver.getTurning(), turning);
	}
	
	@Test
	public void testSetTurning()
	{
		driver.setTurning(1);
		assertTrue("driver turning has been set correctly via setTurning()", driver.getTurning()==1);
	}
	
	@Test
	public void testGetAveragePerformance()
	{
		System.out.println(driver.getAveragePerformance());
		System.out.println(averagePerformance);
		assertEquals("Average performance is calculated correctly with regards to arithmetic calculations", driver.getAveragePerformance(), averagePerformance, 0.001);
	}
	
	@Test
	public void testGetSalary()
	{
		assertEquals("Salary should be equal", driver.getSalary(), 1480000.0, 0.001);
	}
	
	@Test
	public void testSetSalary()
	{
		driver.setSalaryBonus(4.0);
		assertTrue("driver salary has been set correctly via setSalary()", driver.getSalary()==5920000.0);
	}
	
	@Test
	public void testEqualsSameObject()
	{
		assertTrue("Objects that are the same should be the same", driver.equals(driver));
	}
	
	@Test
	public void testEqualsNull()
	{
		assertFalse("Objects that is null is not equal", driver.equals(null));
	}
	
	@Test
	public void testEqualsNotInstanceOfDriver()
	{
		assertFalse("Objects that is not a driver object is not equal", driver.equals(new Object()));
	}
	
	@Test
	public void testEqualsObjectIsEqualAcceleration()
	{
		assertFalse("Objects that are of the same instance but with different values are not equal", driver.equals(new Driver(id, teamId, name, points, number, speed, 50, turning, salary)));
	}
	
	@Test
	public void testEqualsObjectIsEqualAveragePerformance()
	{
		assertFalse("Objects that are of the same instance but with different values are not equal", driver.equals(new Driver(id, teamId, name, points, number, 10, acceleration, 50, salary)));
	}
	
	@Test
	public void testEqualsObjectIsEqualId()
	{
		assertTrue("Objects that are of the same instance but with different values are not equal", driver.equals(new Driver(1, teamId, name, points, number, speed, acceleration, turning, salary)));
	}
	
	@Test
	public void testEqualsObjectNameIsEqualToNull()
	{
		driver.setName(null);
		Driver driver2 = new Driver(id, teamId, name, points, number, speed, acceleration, turning, salary);
		driver2.setName("victor wernet");
		assertFalse("Objects that are of the same instance but with different values are not equal", driver.equals(driver2));
	}
		
	@Test
	public void testEqualsObjectNameIsEqualToNullBoth()
	{
		assertFalse("Objects that are of the same instance but with different values are not equal", driver.equals(new Driver(id, teamId, null, points, number, speed, acceleration, turning, salary)));
	}
	
	@Test
	public void testEqualsNumberIsNotEqual()
	{
		assertFalse("Objects that are of the same instance but with different values are not equal",driver.equals(new Driver(id, teamId, name, points, 444, speed, acceleration, turning, salary)));
	}
	
	@Test
	public void testEqualsPointIsNotEqual()
	{
		assertFalse("Objects that are of the same instance but with different values are not equal",driver.equals(new Driver(id, teamId, name, 444, number, speed, acceleration, turning, salary)));
	}
	
	@Test
	public void testEqualsSalaryIsNotEqual()
	{
		assertFalse("Objects that are of the same instance but with different values are not equal",driver.equals(new Driver(id, teamId, name, points, number, speed, acceleration, turning, 444)));
	}
	
	@Test
	public void testEqualsSalaryBonusIsNotEqual()
	{
		driver.salaryPercentageBonus(2);
		assertFalse("Objects that are of the same instance but with different values are not equal",driver.equals(new Driver(id, teamId, name, points, number, speed, acceleration, turning, salary)));
	}
	
	@Test
	public void testEqualsSpeedIsNotEqual()
	{
		driver.setSpeed(44);
		assertFalse("Objects that are of the same instance but with different values are not equal",driver.equals(new Driver(id, teamId, name, points, number, speed, acceleration, turning, salary)));
	}
	
	@Test
	public void testEqualsTeamIdIsNotEqual()
	{
		assertFalse("Objects that are of the same instance but with different values are not equal",driver.equals(new Driver(id, 44, name, points, number, speed, acceleration, turning, salary)));
	}
	
	@Test
	public void testEqualsTurningIsNotEqual()
	{
		driver.setTurning(444);
		assertFalse("Objects that are of the same instance but with different values are not equal",driver.equals(new Driver(id, teamId, name, points, number, speed, acceleration, turning, salary)));
	}
	
	@Test
	public void testEqualsObjectIsCompletelyNotEquals()
	{
		assertFalse("Objects that are of the same instance but with different values are not equal",driver.equals(new Driver(444, 444, "something else", 444, 444, 444, 444, 444, 444.0)));
	}
	
	public void testComparatorSortById()
	{
		
	}
}