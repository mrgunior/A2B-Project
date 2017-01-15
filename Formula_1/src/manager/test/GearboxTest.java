package manager.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import manager.model.Gearbox;

public class GearboxTest {

	@Before
	public void setUp()
	{
		Gearbox gearbox = new Gearbox();
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsZero()
	{
		double methodReturn = Gearbox.priceAtCertainLevel(0);
		assertEquals(8.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsNegative()
	{
		double methodReturn = Gearbox.priceAtCertainLevel(-1);
		assertEquals(8.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsOne()
	{
		double methodReturn = Gearbox.priceAtCertainLevel(1);
		assertEquals(8.0, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsTwo()
	{
		double methodReturn = Gearbox.priceAtCertainLevel(2);
		assertEquals(12, methodReturn, 0.001);
	}
	
	@Test
	public void testPriceAtCertainLevelWhenItIsThree()
	{
		double methodReturn = Gearbox.priceAtCertainLevel(3);
		assertTrue("It equals to 20 when it level is 3", 20==methodReturn);
	}
	
}
