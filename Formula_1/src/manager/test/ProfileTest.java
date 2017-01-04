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
import static org.hamcrest.CoreMatchers.*;

public class ProfileTest
{
	private Profile			profile;
	private double			highScore, budget;
	private String			teamName;
	private List<Driver>	drivers;
	private List<Car>		cars;

	@Before
	public void setUp()
	{
		highScore = 0.0;
		budget = 200.0;
		teamName = "TestName";

		profile = new Profile(highScore, budget, teamName);

		drivers = new ArrayList<Driver>();
		drivers.add(new Driver());
		drivers.add(new Driver());

		cars = new ArrayList<Car>();
		// TODO No engines in car, something else for the tests should be here
		// cars.add(new Car(new Engine("Engine1", 1.0)));
		// cars.add(new Car(new Engine("Engine2", 1.0)));
	}

	@Test
	public void testConstructorProfileHighScore()
	{
		assertEquals("Constructor initialized highscore correctly", profile.getHighScore(), highScore, 0.001);
	}

	@Test
	public void testConstructorProfileBudget()
	{
		assertEquals("Constructor initialized budget correctly", profile.getBudget(), budget, 0.001);
	}

	@Test
	public void testConstructorProfileTeamName()
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
	public void testGetCars()
	{
		profile.setCars(cars);
		assertThat("Method set cars is setting it correctly", cars, is(profile.getCars()));
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
	public void testSetBudgetIf()
	{
		profile.setBudget(50.0, true);
		assertTrue("Budget is 150.0", profile.getBudget() == 150.0);
	}

	@Test
	public void testSetBudgetElse()
	{
		profile.setBudget(50.0, false);
		assertTrue("Budget is 250.0", profile.getBudget() == 250.0);
	}

	@Test
	public void testSetBudgetNegativeNumber()
	{
		profile.setBudget(-50.0, false);
		assertTrue("Method needs to deal with negatives", profile.getBudget() == 250.0);
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
		profile.setCars(cars); // not empty
		assertEquals("Method set cars is setting it correctly when full", profile.getCars(), cars);
	}
}
