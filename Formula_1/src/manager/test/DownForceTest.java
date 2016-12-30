package manager.test;

import static org.junit.Assert.*;

import org.junit.Test;

import manager.model.DownForce;

public class DownForceTest 
{
	@Test
	public void testPriceAtCertainLevelWhenItIsZero()
	{
		double methodReturn = DownForce.priceAtCertainLevel(0);
		assertEquals(6.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsNegative()
	{
		double methodReturn = DownForce.priceAtCertainLevel(-1);
		assertEquals(6.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsOne()
	{
		double methodReturn = DownForce.priceAtCertainLevel(1);
		assertEquals(6.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsTwo()
	{
		double methodReturn = DownForce.priceAtCertainLevel(2);
		assertEquals(9.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsThree()
	{
		double methodReturn = DownForce.priceAtCertainLevel(3);
		assertTrue("It equals to 15.0 when it level is 3", 15.0==methodReturn);
	}
}
