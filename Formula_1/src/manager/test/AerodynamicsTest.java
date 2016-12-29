package manager.test;

import static org.junit.Assert.*;

import org.junit.Test;

import manager.model.Aerodynamics;

public class AerodynamicsTest 
{
	@Test
	public void testPriceAtCertainLevelWhenItIsZero()
	{
		double methodReturn = Aerodynamics.priceAtCertainLevel(0);
		assertEquals(5.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsNegative()
	{
		double methodReturn = Aerodynamics.priceAtCertainLevel(-1);
		assertEquals(5.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsOne()
	{
		double methodReturn = Aerodynamics.priceAtCertainLevel(1);
		assertEquals(5.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsTwo()
	{
		double methodReturn = Aerodynamics.priceAtCertainLevel(2);
		assertEquals(7.5, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsThree()
	{
		double methodReturn = Aerodynamics.priceAtCertainLevel(3);
		assertTrue("It equals to 12.5 when it level is 3", 12.5==methodReturn);
	}
}
