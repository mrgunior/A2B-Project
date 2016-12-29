package manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import manager.model.Car;
import manager.model.Engine;

public class CarTest 
{
	private Car car;
	private Engine engine1, engine2;
	
	@Before
	public void setUp()
	{
		engine1 = new Engine("TestEngine1", 1.0);
		engine2 = new Engine("TestEngine2", 1.0);
		car = new Car(engine1);
	}
	
	@Test
	public void testConstructorCar()
	{
		assertEquals(car.getEngine(), engine1);
	}
	
	@Test
	public void testSetEngine()
	{
		car.setEngine(engine2);
		assertEquals(car.getEngine(), engine2);
	}
}
