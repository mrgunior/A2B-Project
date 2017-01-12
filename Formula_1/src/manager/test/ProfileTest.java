package manager.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import manager.model.Car;
import manager.model.Driver;
import manager.model.Engine;
import manager.model.Profile;
import manager.model.Upgrades;

import static org.hamcrest.CoreMatchers.*;

public class ProfileTest
{
	private Profile profile;
	private double highScore, budget;
	private String teamName, name;
	private int id, teamId, points, number, speed, acceleration, turning, handling, braking, weight;
	private double averagePerformance, salary;
	private Upgrades upgrades;
	private List<Driver> drivers;
	private Car car;

	@Before
	public void setUp()
	{
		//profile stuff
		highScore = 0.0;
		budget = 200.0;
		teamName = "TestName";
		
		//driver & car stuff
		name = "Victor Wernet";
		id = 1;
		teamId = 2;
		points = 0;
		number = 33;
		speed = 80;
		acceleration = 75;
		turning = 69;
		averagePerformance = 138000.0;
		salary = 3.0; //3 mil
		
		profile = new Profile(highScore, budget, teamName);
		upgrades = new Upgrades(0,0,0,0,0,0,0);
		
		drivers = new ArrayList<Driver>();
		drivers.add(new Driver(id, teamId, name, points, number, speed, acceleration, turning, salary));
		drivers.add(new Driver(id, teamId, name, points, number, speed, acceleration, turning, salary));
		
		car = new Car(speed, acceleration, handling, braking, weight, upgrades);
	}

	@Test
	public void testGetHighScore()
	{
		assertEquals("Constructor initialized highscore correctly", profile.getHighScore(), highScore, 0.001);
	}

	@Test
	public void testGetBudget()
	{
		assertEquals("Constructor initialized budget correctly", Profile.getBudget(), budget, 0.001);
	}

	@Test
	public void testGetTeamName()
	{
		assertEquals("Constructor initialized teamname correctly", profile.getTeamName(), teamName);
	}

	@Test
	public void testGetDrivers()
	{
		profile.setDrivers(drivers);
		assertThat("Method set drivers is setting it correctly", drivers, is(profile.getDrivers()));
	}
	
	@Test
	public void testGetStrategyTrue()
	{
		Profile.setStrategy(2);
		assertEquals(2, Profile.getStrategy());
	}
	
	@Test
	public void testGetStrategyFalse()
	{
		Profile.setStrategy(1);
		assertNotEquals(2, Profile.getStrategy());
	}
	
	@Test
	public void testGetStrategySmall()
	{
		Profile.setStrategy(2);
		Profile.setStrategy(0);
		assertEquals(2, Profile.getStrategy());
	}
	
	@Test
	public void testGetStrategyBig()
	{
		Profile.setStrategy(2);
		Profile.setStrategy(5);
		assertEquals(2, Profile.getStrategy());
	}

	@Test
	public void testGetCars()
	{
		profile.setCar(car);
		assertThat("Method set cars is setting it correctly", car, is(Profile.getCar()));
	}

	@Test
	public void testSetHighScore()
	{
		profile.setHighScore(2.0);
		assertEquals("Method set highscore is setting it correctly", profile.getHighScore(), 2.0, 0.001);
	}

	@Test
	public void testSetTeamName()
	{
		profile.setTeamName(teamName);
		assertEquals("Method set teamname is setting it correctly", profile.getTeamName(), "TestName");
	}

	@Test
	public void testSetBudget()
	{
		Profile.setBudget(20000000);
		assertEquals(20000000, Profile.getBudget(), 0.5);
	}
	
	@Test
	public void testSetBudgetIf()
	{
		Profile.setBudget(50.0, true);
		assertTrue("Budget is 150.0", Profile.getBudget() == 150.0);
	}

	@Test
	public void testSetBudgetElse()
	{
		Profile.setBudget(50.0, false);
		assertTrue("Budget is 250.0", Profile.getBudget() == 250.0);
	}

	@Test
	public void testSetBudgetNegativeNumber()
	{
		Profile.setBudget(-50.0, false);
		assertTrue("Method needs to deal with negatives", Profile.getBudget() == 250.0);
	}

	@Test
	public void testSetDriversEmpty()
	{
		profile.setDrivers(new ArrayList<Driver>()); // empty
		assertEquals("Method set drivers is setting it correctly when empty", profile.getDrivers(),
				new ArrayList<Driver>());
	}

	@Test
	public void testSetDriversNotEmpty()
	{
		profile.setDrivers(drivers); // not empty
		assertEquals("Method set drivers is setting it correctly when full", profile.getDrivers(), drivers);
	}

	@Test
	public void testSetCarsEmpty()
	{
		profile.setDrivers(new ArrayList<Driver>()); // empty
		assertEquals("Method set cars is setting it correctly when empty", profile.getDrivers(),
				new ArrayList<Driver>());
	}

	@Test
	public void testSetCarsNotEmpty()
	{
		profile.setCar(car); // not empty
		assertEquals("Method set cars is setting it correctly when full", Profile.getCar(), car);
	}
}
