package manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import manager.model.Car;
import manager.model.Engine;
import manager.model.Upgrades;

public class CarTest
{
	private Car		car;
	private Engine	engine1, engine2;
	int speed, acceleration, handling, braking, weight;
	Upgrades upgrades, upgrades2;

	@Before
	public void setUp()
	{
		engine1 = new Engine("TestEngine1", 1.0);
		engine2 = new Engine("TestEngine2", 1.0);

		speed = 10;
		acceleration = 20;
		handling = 30;
		braking = 40;
		weight = 50;
		upgrades = new Upgrades(1, 2, 3, 4, 5, 6, 7);
		
		car = new Car(speed, acceleration, handling, braking, weight, upgrades);
	}

	@Test
	public void testConstructorCarSpeed()
	{
		assertEquals(car.getSpeed(), speed);
	}
	
	@Test
	public void testConstructorCarAcceleration()
	{
		assertEquals(car.getAcceleration(), acceleration);
	}
	
	@Test
	public void testConstructorCarHandling()
	{
		assertEquals(car.getHandling(), handling);
	}
	
	@Test
	public void testConstructorCarBraking()
	{
		assertEquals(car.getBraking(), braking);
	}
	
	@Test
	public void testConstructorCarWeight()
	{
		assertEquals(car.getWeight(), weight);
	}

	@Test
	public void testConstructorUpgrades()
	{
		// TODO Create Upgrades equals method
		assertEquals(car.getUpgrades(), upgrades);
	}
}
