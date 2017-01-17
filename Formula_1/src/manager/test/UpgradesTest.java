package manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import manager.model.Upgrades;

public class UpgradesTest {

	int down, aero, gearbox, engine, susp, tires, weightRed;
	Upgrades upgrades;
	
	@Before
	public void SetUp() {
		
		upgrades = new Upgrades(0);
		
	}
	
	@Test
	public void testGetDown() {
		assertEquals("Constructor correctly initialized downforce", upgrades.getDown(), down);
	}
	
	@Test
	public void testGetAero() {
		assertEquals("Constructor correctly initialized areodynamics", upgrades.getAero(), aero);
	}
	
	@Test
	public void testGetGearBox() {
		assertEquals("Constructor correctly initialized gearbox", upgrades.getGearbox(), gearbox);
	}
	
	@Test
	public void testGetEngine() {
		assertEquals("Constructor correctly initialized engine", upgrades.getEngine(), engine);
	}
	
	@Test
	public void testGetSusp() {
		assertEquals("Constructor correctly initialized suspension", upgrades.getSusp(), susp);
	}
	
	@Test
	public void testGetTires() {
		assertEquals("Constructor correctly initialized tires", upgrades.getTires(), tires);
	}
	
	@Test
	public void testGetWeightRed() {
		assertEquals("Constructor correctly initialized weight reduction", upgrades.getWeightRed(), weightRed);
	}
	
	@Test
	public void testSetDown() {
		int newDown = 1;
		upgrades.setDown(newDown);
		assertEquals("Constructor correctly set new downforce", upgrades.getDown(), newDown);
	}
	
	@Test
	public void testSetAero() {
		int newAero = 1;
		upgrades.setAero(newAero);
		assertEquals("Constructor correctly set new aerodynamics", upgrades.getAero(), newAero);
	}
	
	@Test
	public void testSetGearbox() {
		int newGearbox = 1;
		upgrades.setGearbox(newGearbox);
		assertEquals("Constructor correctly set new gearbox", upgrades.getGearbox(), newGearbox);
	}
	
	@Test
	public void testSetEngine() {
		int newEngine = 1;
		upgrades.setEngine(newEngine);
		assertEquals("Constructor correctly set new engine", upgrades.getEngine(), newEngine);
	}
	
	@Test
	public void testSetSusp() {
		int newSusp = 1;
		upgrades.setSusp(newSusp);
		assertEquals("Constructor correctly set new suspension", upgrades.getSusp(), newSusp);
	}
	
	@Test
	public void testSetTires() {
		int newTires = 1;
		upgrades.setTires(newTires);
		assertEquals("Constructor correctly set new tires", upgrades.getTires(), newTires);
	}
	
	@Test
	public void testSetWeightRed() {
		int newWeightRed = 1;
		upgrades.setWeightRed(newWeightRed);
		assertEquals("Constructor correctly set new weight reduction", upgrades.getWeightRed(), newWeightRed);
	}
	
	@Test
	public void testUpgrade() {
		int upgradeddown = 1;
		int upgradedaero = 1;
		int upgradedgearbox = 1;
		int upgradedengine = 1;
		int upgradedsusp = 1;
		int upgradedtires = 1;
		int upgradedweightRed = 1;
		
		Upgrades upgradedupgrades = new Upgrades(upgradeddown, upgradedaero, upgradedgearbox, upgradedengine, upgradedsusp, upgradedtires, upgradedweightRed);
		
		upgrades.upgrade("aero");
		upgrades.upgrade("down");
		upgrades.upgrade("engine");
		upgrades.upgrade("gearbox");
		upgrades.upgrade("susp");
		upgrades.upgrade("tires");
		upgrades.upgrade("weightRed");
		
		assertEquals("Constructor correctly upgraded every component", upgrades, upgradedupgrades);
	}
	
	@Test
	public void testToString() {
		assertTrue("Constructor correclty set upgrades to string", upgrades.toString().equals("weightRed: 0, down: 0, susp: 0, tires: 0, gearbox: 0, aero: 0, engine: 0"));
	}
	
	@Test
	public void testEquals() {
		Upgrades upgrades2 = new Upgrades(down, aero, gearbox, engine, susp, tires, weightRed);
		
		assertTrue("These two upgrades should equal.", upgrades.equals(upgrades2));
	}
	
	@Test
	public void testNotEquals() {

		int upgradeddown = 1;
		int upgradedaero = 1;
		int upgradedgearbox = 1;
		int upgradedengine = 1;
		int upgradedsusp = 1;
		int upgradedtires = 1;
		int upgradedweightRed = 1;
		
		Upgrades upgradedupgrades = new Upgrades(upgradeddown, upgradedaero, upgradedgearbox, upgradedengine, upgradedsusp, upgradedtires, upgradedweightRed);
		
		assertFalse("These 2 upgrades shouldn't equal.", upgrades.equals(upgradedupgrades));	
	}
	
	@Test
	public void testNonObjectEquals() {
		int testInteger = 0;
		assertFalse("An integer and object shouldn't equal.", upgrades.equals(testInteger));
	}
	
	@Test
	public void testNullEquals() {
		assertFalse("An upgrades object shouldn't equal null.", upgrades.equals(null));
	}
	
	@Test
	public void testEqualsItself() {
		assertTrue("An object should equal itself.", upgrades.equals(upgrades));
	}
	
	@Test
	public void testDifferentValues1() {
		Upgrades testUpgrade = new Upgrades(0);
		upgrades.upgrade("aero");
		assertFalse("The testupgrade shouldn't equal the upgrades with everything at 0", upgrades.equals(testUpgrade));
	}
	
	@Test
	public void testDifferentValues2() {
		Upgrades testUpgrade = new Upgrades(0);
		upgrades.upgrade("down");
		assertFalse("The testupgrade shouldn't equal the upgrades with everything at 0", upgrades.equals(testUpgrade));
	}
	
	@Test
	public void testDifferentValues3() {
		Upgrades testUpgrade = new Upgrades(0);
		upgrades.upgrade("engine");
		assertFalse("The testupgrade shouldn't equal the upgrades with everything at 0", upgrades.equals(testUpgrade));
	}
	
	@Test
	public void testDifferentValues4() {
		Upgrades testUpgrade = new Upgrades(0);
		upgrades.upgrade("gearbox");
		assertFalse("The testupgrade shouldn't equal the upgrades with everything at 0", upgrades.equals(testUpgrade));
	}
	
	@Test
	public void testDifferentValues5() {
		Upgrades testUpgrade = new Upgrades(0);
		upgrades.upgrade("susp");
		assertFalse("The testupgrade shouldn't equal the upgrades with everything at 0", upgrades.equals(testUpgrade));
	}
	
	@Test
	public void testDifferentValues6() {
		Upgrades testUpgrade = new Upgrades(0);
		upgrades.upgrade("tires");
		assertFalse("The testupgrade shouldn't equal the upgrades with everything at 0", upgrades.equals(testUpgrade));
	}
	
	@Test
	public void testDifferentValues7() {
		Upgrades testUpgrade = new Upgrades(0);
		upgrades.upgrade("weightRed");
		assertFalse("The testupgrade shouldn't equal the upgrades with everything at 0", upgrades.equals(testUpgrade));
	}
	
	@Test
	public void testUpgradeMaxUpgradedUpgrades() {
		Upgrades testUpgrade = new Upgrades(5,5,5,5,5,5,5);
		Upgrades testUpgrade2 = new Upgrades(5,5,5,5,5,5,5);
		testUpgrade.upgrade("aero");
		testUpgrade.upgrade("down");
		testUpgrade.upgrade("engine");
		testUpgrade.upgrade("gearbox");
		testUpgrade.upgrade("susp");
		testUpgrade.upgrade("tires");
		testUpgrade.upgrade("weightRed");
		assertTrue("Upgrades should still be at 5, as this is the max level and cannot be further upgraded.", testUpgrade.equals(testUpgrade2));		
	}
	
	@Test
	public void testUpgradingNonExistingComponent() {
		Upgrades testUpgrade = new Upgrades(0);
		Upgrades testUpgrade2 = new Upgrades(0);
		testUpgrade.upgrade("OOP");
		assertTrue("Upgrade shouldn't have upgraded anything as OOP is an invalid part", testUpgrade.equals(testUpgrade2));
	}
	
	@Test
	public void testWrongInitialization() {
		Upgrades testUpgrade = new Upgrades(1);
		assertTrue("Wrongly Initialized upgrades should be set to 0", upgrades.equals(testUpgrade));
	}
	
}
