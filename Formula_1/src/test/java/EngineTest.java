package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.manager.model.Engine;
import main.java.manager.model.Upgrades;

public class EngineTest 
{
	public Engine engine;
	public String name = "Engine";
	public double level = 0.0;
	
	@Before
	public void setUp() {
		engine = new Engine(name, level);
	}
	
	@Test
	public void testPriceAtLevel0() {
		assertTrue("Price at level 0 should be 10", Engine.priceAtCertainLevel(0.0)==10.0);
	}
	
	@Test
	public void testPriceAtLevel2() {
		assertTrue("Price at level 0 should be 10", Engine.priceAtCertainLevel(2.0)==15.0);
	}
	
	@Test
	public void testEqualsNullEngine() {
		Engine testEngine = null;
		assertFalse("Engine not should equal null engine.", engine.equals(testEngine));
	}
	
	@Test
	public void testEquals() {
		assertTrue("Engine should equal itself.", engine.equals(engine));
	}
	
	@Test
	public void testEqualsNull() {
		assertFalse("Engine not should equal null.", engine.equals(null));
	}
	
	@Test
	public void testEqualsNonEngine() {
		int testInt = 0;
		assertFalse("Engine should not equal an integer.", engine.equals(testInt));
	}
	
	@Test
	public void testEqualsOtherEngine() {
		Engine testEngine = new Engine(name, level);
		assertTrue("An engine should equal another engine with same values.", engine.equals(testEngine));
	}
	
	@Test
	public void testEqualsUpgrades() {
		Upgrades upgrades = new Upgrades(0);
		assertFalse("An engine should not equal an upgrades object.", engine.equals(upgrades));
	}
	
	@Test
	public void testNotEqualsEngineWithDifferentName() {
		Engine testEngine = new Engine("testEngine", level);
		assertFalse("Engine should not equal another engine with different name.", engine.equals(testEngine));
	}
	
	@Test
	public void testNotEqualsEngineWithDifferentLevel() {
		Engine testEngine = new Engine(name, 1.0);
		assertFalse("Engine should not equal another engine with different level.", engine.equals(testEngine));
	}
	
	@Test
	public void testSetGetPositiveStatSpeed() {
		engine.setPositiveStatSpeed(10);
		assertEquals("Positive Stat Speed should be set to 10.", engine.getPositiveStatSpeed(), 10);
	}
	
	@Test
	public void testSetGetPositiveStatAcceleration() {
		engine.setPositiveStatAcceleration(10);
		assertEquals("Positive Stat Acceleration should be set to 10.", engine.getPositiveStatAcceleration(), 10);
	}
	
	@Test
	public void testSetGetNegativeStatWeight() {
		engine.setNegativeStatWeight(10);
		assertEquals("Negative Stat Weight should be set to 10.", engine.getNegativeStatWeight(), 10);
	}
	
	@Test
	public void testSetNameAndLevel() {
		engine.setEngineName("Engine2");
		engine.setLevel(1.0);
		Engine testEngine = new Engine("Engine2", 1.0);
		assertTrue("Engine should now equal testengine.", engine.equals(testEngine));
	}
	
}