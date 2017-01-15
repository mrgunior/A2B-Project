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
		
		down = 0;
		aero = 0;
		gearbox = 0;
		engine = 0;
		susp = 0;
		tires = 0;
		weightRed = 0;
		
		upgrades = new Upgrades(down, aero, gearbox, engine, susp, tires, weightRed);
		
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
		
		assertTrue(upgrades.equals(upgrades2));
	}
	
}
