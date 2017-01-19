package manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import manager.model.Car;
import manager.model.Driver;
import manager.model.Team;
import manager.model.Upgrades;

public class TeamTest {
	
	private Team team;
	private String teamName, driver1Name, driver2Name;
	private int teamID, balance, id1, points1, number1, speed1, acceleration1, turning1, id2, points2, number2, speed2, acceleration2, turning2;
	private int down, aero, gearbox, engine, susp, tires, weightRed, cspeed, cacceleration, chandling, cbraking, cweight, ccrashChance, criskMultiplier;
	private double salary1, salary2;
	private Driver driver1, driver2;
	private Upgrades cupgrades;
	private Car car;

	@Before
	public void setUp()
	{
		
		teamID = 0;
		id1 = 0;
		driver1Name = "testDriver1";
		points1 = 0;
		number1 = 1;
		speed1 = 50;
		acceleration1 = 50;
		turning1 = 50;
		salary1 = 15.0;
		
		id2 = 1;
		driver2Name = "testDriver2";
		points2 = 0;
		number2 = 2;
		speed2 = 50;
		acceleration2 = 50;
		turning2 = 50;
		salary2 = 15.0;

		driver1 = new Driver(id1, teamID, driver1Name, points1, number1, speed1, acceleration1, turning1, salary1);
		driver2 = new Driver(id2, teamID, driver2Name, points2, number2, speed2, acceleration2, turning2, salary2);
		
		down = 0;
		aero = 0;
		gearbox = 0;
		engine = 0;
		susp = 0;
		tires = 0;
		weightRed = 0;
		
		cupgrades = new Upgrades(down, aero, gearbox, engine, susp, tires, weightRed);
		
		cspeed = 50;
		cacceleration = 50;
		chandling = 50;
		cbraking = 50;
		cweight = 50;
		ccrashChance = 0;
		criskMultiplier = 0;
		
		car = new Car(cspeed, cacceleration, chandling, cbraking, cweight, cupgrades, ccrashChance, criskMultiplier);
		
		teamName = "testTeam";
		balance = 200;
		
		team = new Team(teamName, teamID, balance, driver1, driver2, car);
		
	}
	
	@Test
	public void testGetName() {
		assertTrue("Constructor initialized team name correctly", team.getName().equals(teamName));
	}
	
	@Test
	public void testGetTeamID() {
		assertEquals("Constructor initialized team ID correctly", team.getTeamID(), teamID);
	}
	
	@Test
	public void testGetBalance() {
		assertEquals("Constructor initialized team balance correctly", team.getBalance(), balance);
	}
	
	@Test
	public void testGetDriver1() {
		assertEquals("Constructor initialized driver 1 from team correctly", team.getDriver1(), driver1);
	}
	
	@Test
	public void testGetDriver2() {
		assertEquals("Constructor initialized driver 2 from team correctly", team.getDriver2(), driver2);
	}
	
	@Test
	public void testGetCar() {
		assertEquals("Constructor initialized team car correctly", team.getCar(), car);
	}
	
	@Test
	public void testSetName() {
		String newName = "New Name";
		team.setName(newName);
		assertTrue("Constructor correctly set new team name", team.getName().equals(newName));
	}
	
	@Test
	public void testSetTeamID() {
		int newTeamID = 1;
		team.setTeamID(newTeamID);
		assertEquals("Constructor correctly set new team ID", team.getTeamID(), newTeamID);
	}
	
	@Test
	public void testSetBalance() {
		int newBalance = 201;
		team.setBalance(newBalance);
		assertEquals("Constructor correctly set new team balance", team.getBalance(), newBalance);
	}
	
	@Test
	public void testSetDriver1() {
		int nteamID = 1;
		int nid1 = 1;
		String ndriver1Name = "testDriver1";
		int npoints1 = 1;
		int nnumber1 = 2;
		int nspeed1 = 51;
		int nacceleration1 = 51;
		int nturning1 = 51;
		double nsalary1 = 15.1;

		Driver newDriver1 = new Driver(nid1, nteamID, ndriver1Name, npoints1, nnumber1, nspeed1, nacceleration1, nturning1, nsalary1);
		
		team.setDriver1(newDriver1);
		
		assertEquals("Constructor correctly set new team driver1", team.getDriver1(), newDriver1);
	}
	
	@Test
	public void testSetDriver2() {
		int nteamID = 1;
		int nid2 = 2;
		String ndriver2Name = "testDriver2";
		int npoints2 = 1;
		int nnumber2 = 3;
		int nspeed2 = 51;
		int nacceleration2 = 51;
		int nturning2 = 51;
		double nsalary2 = 15.1;

		Driver newDriver2 = new Driver(nid2, nteamID, ndriver2Name, npoints2, nnumber2, nspeed2, nacceleration2, nturning2, nsalary2);
		
		team.setDriver2(newDriver2);
		
		assertEquals("Constructor correctly set new team driver2", team.getDriver2(), newDriver2);
	}
	
	@Test
	public void testSetCar() {
		int down = 1;
		int aero = 1;
		int gearbox = 1;
		int engine = 1;
		int susp = 1;
		int tires = 1;
		int weightRed = 1;
		
		Upgrades newCUpgrades = new Upgrades(down, aero, gearbox, engine, susp, tires, weightRed);
		
		int cspeed = 51;
		int cacceleration = 51;
		int chandling = 51;
		int cbraking = 51;
		int cweight = 51;
		int ccrashChance = 1;
		int criskMultiplier = 1;
		
		Car newCar = new Car(cspeed, cacceleration, chandling, cbraking, cweight, newCUpgrades, ccrashChance, criskMultiplier);
		
		team.setCar(newCar);
		
		assertEquals("Constructor correctly set new team car", team.getCar(), newCar);
	}
	
	@Test
	public void testEqualsItself() {
		assertTrue("A team should equal itself.", team.equals(team));
	}
	
	@Test
	public void testEqualSimilar() {
		Team testTeam = new Team(teamName, teamID, balance, driver1, driver2, car);
		assertTrue("A team should equal another team with same values.", team.equals(testTeam));
	}
	
	@Test
	public void testEqualsNull() {
		assertFalse("A team should not equal null.", team.equals(null));
	}
	
	@Test
	public void testEqualsNullTeam() {
		Team testTeam = new Team(null, 0, 0, null, null, null);
		assertFalse("A team should not equal an empty team.", team.equals(testTeam));
	}
	
	@Test
	public void testEqualsWithDifferentName() {
		Team testTeam = new Team(teamName, teamID, balance, driver1, driver2, car);
		testTeam.setName("Hello world!");
		assertFalse("A team should not equal a team with different Name.", team.equals(testTeam));
	}
	
	@Test
	public void testEqualsWithDifferentBalance() {
		Team testTeam = new Team(teamName, teamID, balance, driver1, driver2, car);
		testTeam.setBalance(500);
		assertFalse("A team should not equal a team with different Balance.", team.equals(testTeam));
	}
	
	@Test
	public void testEqualsWithDifferentTeamID() {
		Team testTeam = new Team(teamName, teamID, balance, driver1, driver2, car);
		testTeam.setTeamID(1);
		assertFalse("A team should not equal a team with different TeamID.", team.equals(testTeam));
	}
	
	@Test
	public void testEqualsWithDifferentDriver1() {
		Team testTeam = new Team(teamName, teamID, balance, driver1, driver2, car);
		testTeam.setDriver1(driver2);
		assertFalse("A team should not equal a team with different Driver1.", team.equals(testTeam));
	}
	
	@Test
	public void testEqualsWithDifferentDriver2() {
		Team testTeam = new Team(teamName, teamID, balance, driver1, driver2, car);
		testTeam.setDriver2(driver1);
		assertFalse("A team should not equal a team with different Driver2.", team.equals(testTeam));
	}
	
	@Test
	public void testEqualsWithDifferentCar() {
		Team testTeam = new Team(teamName, teamID, balance, driver1, driver2, car);
		Car testCar = new Car(0, cacceleration, chandling, cbraking, cweight, cupgrades, ccrashChance, criskMultiplier);
		testTeam.setCar(testCar);
		assertFalse("A team should not equal a team with different Car.", team.equals(testTeam));
	}
	
}
