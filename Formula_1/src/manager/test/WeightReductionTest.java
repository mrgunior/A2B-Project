package manager.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import manager.model.WeightReduction;

public class WeightReductionTest {

	@Before
	public void setUp()
	{
		WeightReduction WeightReduction = new WeightReduction();
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsZero()
	{
		double methodReturn = WeightReduction.priceAtCertainLevel(0);
		assertEquals(20, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsNegative()
	{
		double methodReturn = WeightReduction.priceAtCertainLevel(-1);
		assertEquals(20, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsOne()
	{
		double methodReturn = WeightReduction.priceAtCertainLevel(1);
		assertEquals(20, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsTwo()
	{
		double methodReturn = WeightReduction.priceAtCertainLevel(2);
		assertEquals(30, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsThree()
	{
		double methodReturn = WeightReduction.priceAtCertainLevel(3);
		assertTrue("It equals to 50 when it level is 3", 50==methodReturn);
	}
	
}
