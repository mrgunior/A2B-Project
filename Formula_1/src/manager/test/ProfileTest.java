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
	private Profile profile;
	private double highScore, budget;
	private String teamName;
	private List<Driver> drivers;
	private List<Car> cars;
	
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
		cars.add(new Car(new Engine("Engine1", 1.0)));
		cars.add(new Car(new Engine("Engine2", 1.0)));
	}
	
	@Test
	public void testConstructorProfileHighScore()
	{
		assertEquals(profile.getHighScore(), highScore, 0.001);
	}
	
	@Test
	public void testConstructorProfileBudget()
	{
		assertEquals(profile.getBudget(), budget, 0.001);
	}
	
	@Test
	public void testConstructorProfileTeamName()
	{
		assertEquals(profile.getTeamName(), teamName);
	}
	
	@Test
	public void testGetDrivers()
	{
		profile.setDrivers(drivers);
		assertThat(drivers, is(profile.getDrivers()));
	}
}
