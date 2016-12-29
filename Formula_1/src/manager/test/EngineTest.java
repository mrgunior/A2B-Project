package manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import manager.model.Engine;

public class EngineTest 
{
	private Engine engine;
	private int positiveStatSpeed;
	private int positiveStatAcceleration;
	private int negativeStatWeight;
	
	@Before
	public void setUp()
	{
		engine = new Engine("EngineName1", 1.0);
		positiveStatSpeed = 2;
		positiveStatAcceleration = 2;
		negativeStatWeight = 1;
		
		engine.setPositiveStatSpeed(positiveStatSpeed);
		engine.setPositiveStatAcceleration(positiveStatAcceleration);
		engine.setNegativeStatWeight(negativeStatWeight);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsZero()
	{
		double methodReturn = Engine.priceAtCertainLevel(0);
		assertEquals(10.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsNegative()
	{
		double methodReturn = Engine.priceAtCertainLevel(-1);
		assertEquals(10.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsOne()
	{
		double methodReturn = Engine.priceAtCertainLevel(1);
		assertEquals(10.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsTwo()
	{
		double methodReturn = Engine.priceAtCertainLevel(2);
		assertEquals(15, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsThree()
	{
		double methodReturn = Engine.priceAtCertainLevel(3);
		assertTrue("It equals to 25 when it level is 3", 25.0==methodReturn);
	}
	
	@Test
	public void testConstructorEngineName()
	{
		assertEquals(engine.getEngineName(), "EngineName1");
	}
	
	@Test
	public void testConstructorLevel()
	{
		assertEquals(engine.getLevel(), 1, 0.001);
	}
	
	@Test
	public void testGetPositiveStatSpeed()
	{
		assertEquals(engine.getPositiveStatSpeed(), positiveStatSpeed);
	}
	
	@Test
	public void testGetPositiveStatAcceleration()
	{
		assertEquals(engine.getPositiveStatAcceleration(), positiveStatAcceleration);
	}
	
	@Test
	public void testGetNegativeStatWeight()
	{
		assertEquals(engine.getNegativeStatWeight(), negativeStatWeight);
	}
}
