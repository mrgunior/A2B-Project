package manager.test;

import org.junit.Assert.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import manager.model.Driver;
import manager.model.DriverResult;
import manager.model.GameController;
import manager.model.RaceSimulation;
import manager.model.Results;

public class RaceSimulationTest {

	private static RaceSimulation raceSim;
	private DriverResult	driverResult1;
	private int				carId1	= 5;
	private double			time1	= 12500;

	private DriverResult	driverResult2;
	private int				carId2	= 3;
	private double			time2	= 15000;

	private Driver driver1;
	private String name1;
	private int id1, teamId1, points1, number1, speed1, acceleration1, turning1;
	private double salary1;
	
	private Driver driver2;
	private String name2;
	private int id2, teamId2, points2, number2, speed2, acceleration2, turning2;
	private double salary2;
	
	private ArrayList<Driver> drivers;
	
	Results results;
	
	@Before
	public void initialize() {
		raceSim = new RaceSimulation();		
		
		name1 = "Victor Wernet";
		id1 = 1;
		teamId1 = 2;
		points1 = 20;
		number1 = 33;
		speed1 = 80;
		acceleration1 = 75;
		turning1 = 69;
		salary1 = 3.0; //3 mil
		
		name2 = "Mika Kuijpers";
		id2 = 2;
		teamId2 = 3;
		points2 = 21;
		number2 = 34;
		speed2 = 81;
		acceleration2 = 76;
		turning2 = 70;
		salary2 = 4.0; //3 mil
		
		driver1 = new Driver(id1, teamId1, name1, points1, number1, speed1, acceleration1, turning1, salary1);
		driver2 = new Driver(id2, teamId2, name2, points2, number2, speed2, acceleration2, turning2, salary2);
		
		driverResult1 = new DriverResult(carId1, driver1, time1);
		driverResult2 = new DriverResult(carId2, driver2, time2);
		results = new Results();
		
		drivers = new ArrayList<Driver>();
	}

	@Test
	public void testGetDriverList() {
		String res = "[Driver [name=Kevin Magnussen, id=11, teamId=8, points=0, number=20, speed=76, acceleration=82, turning=78, salary=1560000.0, averagePerformance=78.0], Driver [name=Pascal Wehrlein, id=22, teamId=4, points=0, number=11, speed=74, acceleration=78, turning=74, salary=1500000.0, averagePerformance=75.0]]";
		assertEquals(res, GameController.getDrivers("./JsonTestFilesDontTouch/driversTest.json").toString());
	}
	
	@Test
	public void testCalculateResult() {
		assertEquals(RaceSimulation.calculateResult(10, 10, 10, 5), 20, 0.000000001);
	}

	@Test
	public void testRandom() {
		assertEquals(0.9043956591864711, RaceSimulation.random(true), 0.00000000001);
		assertEquals(1.0, RaceSimulation.random(false), 0.1);
	}
	@Test
	public void testRunSimulation() {
		fail("Not yet implemented");
	}

}
