package manager.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import manager.model.Suspension;

public class SuspensionTest {

	@Before
	public void setUp()
	{
		Suspension aerodynamics = new Suspension();
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsZero()
	{
		double methodReturn = Suspension.priceAtCertainLevel(0);
		assertEquals(4.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsNegative()
	{
		double methodReturn = Suspension.priceAtCertainLevel(-1);
		assertEquals(4.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsOne()
	{
		double methodReturn = Suspension.priceAtCertainLevel(1);
		assertEquals(4.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsTwo()
	{
		double methodReturn = Suspension.priceAtCertainLevel(2);
		assertEquals(6, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsThree()
	{
		double methodReturn = Suspension.priceAtCertainLevel(3);
		assertTrue("It equals to 10 when it level is 3", 10==methodReturn);
	}
	
}
