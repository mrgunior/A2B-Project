package manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import manager.model.Car;
import manager.model.Upgrades;

public class CarTest {
	private Car car;
	private Upgrades upgrades;
	int speed, acceleration, handling, braking, weight;

	@Before
	public void setUp() {
		upgrades = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		car = new Car(0, 0, 0, 0, 0, upgrades, 0);
	}
	
	@Test
	public void testGetCrashChance() {
		assertEquals("Crash chance is equal to crash chance in Constructor", car.getCrashChance(), 0);
	}
	
	@Test
	public void testSetCrashChance() {
		car.setCrashChance(1);
		assertEquals("Crash chance updated correctly via setCrashChance()", car.getCrashChance(), 1);
	}

	@Test
	public void testGetSpeed() {
		assertEquals("Speed is equal to speed in Constructor", car.getSpeed(), 0);
	}

	@Test
	public void testSetSpeed() {
		car.setSpeed(1);
		assertEquals("Speed updated correctly via setSpeed()", car.getSpeed(), 1);
	}

	@Test
	public void testGetAcceleration() {
		assertEquals("Acceleration is equal to acceleration in Constructor", car.getAcceleration(), 0);
	}

	@Test
	public void testSetAcceleration() {
		car.setAcceleration(1);
		assertEquals("Speed updated correctly via setSpeed()", car.getAcceleration(), 1);
	}

	@Test
	public void testGetHandling() {
		assertEquals("Handling is equal to handling in Constructor", car.getHandling(), 0);
	}

	@Test
	public void testSetHandling() {
		car.setHandling(1);
		assertEquals("Handling updated correctly via setHandling()", car.getHandling(), 1);
	}

	@Test
	public void testGetBraking() {
		assertEquals("Braking is equal to braking in Constructor", car.getBraking(), 0);
	}

	@Test
	public void testSetBraking() {
		car.setBraking(1);
		assertEquals("Braking updated correctly via setBraking()", car.getBraking(), 1);
	}

	@Test
	public void testGetWeight() {
		assertEquals("Weight is equal to weight in Constructor", car.getWeight(), 0);
	}

	@Test
	public void testSetWeight() {
		car.setWeight(1);
		assertEquals("Weight updated correctly via setWeight()", car.getWeight(), 1);
	}

	@Test
	public void testGetUpgrades() {
		assertTrue("Objects that are equal should be the same", upgrades.equals(car.getUpgrades()));
	}

	@Test
	public void testSetUpgrades() {
		Upgrades upgradesTest = new Upgrades(1, 1, 1, 1, 0, 0, 0);
		car.setUpgrades(upgradesTest);
		assertTrue("Objects that are equal should be the same", upgradesTest.equals(car.getUpgrades()));
	}

	@Test
	public void testConstructorCarSpeed() {
		assertEquals(car.getSpeed(), speed);
	}

	@Test
	public void testConstructorCarAcceleration() {
		assertEquals(car.getAcceleration(), acceleration);
	}

	@Test
	public void testConstructorCarHandling() {
		assertEquals(car.getHandling(), handling);
	}

	@Test
	public void testConstructorCarBraking() {
		assertEquals(car.getBraking(), braking);
	}

	@Test
	public void testConstructorCarWeight() {
		assertEquals(car.getWeight(), weight);
	}

	@Test
	public void testConstructorUpgrades() {
		assertEquals(car.getUpgrades(), upgrades);
	}

	@Test
	public void testIncrementSpeed() {
		int incrementAmount = 2;
		car.incrementSpeed(incrementAmount);
		assertEquals(speed + incrementAmount, car.getSpeed());
	}

	@Test
	public void testIncrementAcceleration() {
		int incrementAmount = 3;
		car.incrementAcceleration(incrementAmount);
		assertEquals(acceleration + incrementAmount, car.getAcceleration());
	}

	@Test
	public void testIncrementHandling() {
		int incrementAmount = 5;
		car.incrementHandling(incrementAmount);
		assertEquals(handling + incrementAmount, car.getHandling());
	}

	@Test
	public void testIncrementBraking() {
		int incrementAmount = 3;
		car.incrementBraking(incrementAmount);
		assertEquals(braking + incrementAmount, car.getBraking());
	}

	@Test
	public void testIncrementWeight() {
		int incrementAmount = 8;
		car.incrementWeight(incrementAmount);
		assertEquals(weight + incrementAmount, car.getWeight());
	}

	@Test
	public void testUpgradeAero()
	{
		upgrades.upgradeAero();
		assertEquals(1, car.getUpgrades().getAero());
	}

	@Test
	public void testUpgradeDown()
	{
		upgrades.upgradeDown();
		assertEquals(1, car.getUpgrades().getDown());
	}

	@Test
	public void testUpgradeEngine()
	{
		upgrades.upgradeEngine();
		assertEquals(1, car.getUpgrades().getEngine());
	}

	@Test
	public void testUpgradeGearbox()
	{
		upgrades.upgradeGearbox();
		assertEquals(1, car.getUpgrades().getGearbox());
	}

	@Test
	public void testUpgradeSusp()
	{
		upgrades.upgradeSusp();
		assertEquals(1, car.getUpgrades().getSusp());
	}

	@Test
	public void testUpgradeTires()
	{
		upgrades.upgradeTires();
		assertEquals(1, car.getUpgrades().getTires());
	}

	@Test
	public void testUpgradeWeightRed()
	{
		upgrades.upgradeWeightRed();
		assertEquals(1, car.getUpgrades().getWeightRed());
	}
	
	@Test
	public void testCurrentLevelAero()
	{
		int input = 5;
		upgrades.setAero(input);
		int output = car.getCurrentLevel("aero");
		assertEquals(input, output);
	}
	
	@Test
	public void testCurrentLevelAeroSameHash()
	{
		int input = 5;
		upgrades.setAero(input);
		int output = car.getCurrentLevel("Aero");
		assertEquals(input, output);
	}
	
	@Test
	public void testCurrentLevelDown()
	{
		int input = 5;
		upgrades.setDown(input);
		int output = car.getCurrentLevel("down");
		assertEquals(input, output);
	}
	
	@Test
	public void testCurrentLevelEngine()
	{
		int input = 5;
		upgrades.setEngine(input);
		int output = car.getCurrentLevel("engine");
		assertEquals(input, output);
	}
	
	@Test
	public void testCurrentLevelGearbox()
	{
		int input = 5;
		upgrades.setGearbox(input);
		int output = car.getCurrentLevel("gearbox");
		assertEquals(input, output);
	}
	
	@Test
	public void testCurrentLevelSusp()
	{
		int input = 5;
		upgrades.setSusp(input);
		int output = car.getCurrentLevel("susp");
		assertEquals(input, output);
	}
	
	
	@Test
	public void testCurrentLevelTires()
	{
		int input = 5;
		upgrades.setTires(input);
		int output = car.getCurrentLevel("tires");
		assertEquals(input, output);
	}
	
	
	@Test
	public void testCurrentLevelWeightRed()
	{
		int input = 5;
		upgrades.setWeightRed(input);
		int output = car.getCurrentLevel("weightRed");
		assertEquals(input, output);
	}
	
	@Test
	public void testCurrentLevelDefault()
	{
		int output = car.getCurrentLevel("defaultSwitchReturn");
		assertEquals(0, output);
	}
	
	@Test
	public void testToString() {
		assertEquals(
				"<Car[speed: 0, braking: 0, acceleration: 0, weight: 0, handling: 0, Upgrades[weightRed: 0, down: 0, susp: 0, tires: 0, gearbox: 0, aero: 0, engine: 0]>]>",
				car.toString());
	}
}
