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
		String res = "[Driver [name=Fernando Alonso, id=1, teamId=5, points=0, number=14, speed=85, acceleration=85, turning=82, salary=1680000.0, averagePerformance=84.0], Driver [name=Valtteri Bottas, id=2, teamId=11, points=0, number=77, speed=97, acceleration=84, turning=83, salary=1760000.0, averagePerformance=88.0], Driver [name=Jensen Button, id=3, teamId=5, points=0, number=22, speed=78, acceleration=74, turning=80, salary=1540000.0, averagePerformance=77.0], Driver [name=Marcus Ericsson, id=4, teamId=9, points=0, number=11, speed=72, acceleration=82, turning=71, salary=1500000.0, averagePerformance=75.0], Driver [name=Romain Grosjean, id=5, teamId=3, points=0, number=33, speed=79, acceleration=76, turning=76, salary=1540000.0, averagePerformance=77.0], Driver [name=Esteban Gutierrez, id=6, teamId=3, points=0, number=11, speed=72, acceleration=69, turning=69, salary=1400000.0, averagePerformance=70.0], Driver [name=Lewis Hamilton, id=7, teamId=6, points=0, number=33, speed=94, acceleration=95, turning=95, salary=1880000.0, averagePerformance=94.0], Driver [name=Rio Haryanto, id=8, teamId=4, points=0, number=11, speed=71, acceleration=70, turning=72, salary=1420000.0, averagePerformance=71.0], Driver [name=Nicolas Hulkenberg, id=9, teamId=2, points=0, number=33, speed=82, acceleration=75, turning=82, salary=1580000.0, averagePerformance=79.0], Driver [name=Daniil Kvyat, id=10, teamId=10, points=0, number=11, speed=78, acceleration=70, turning=74, salary=1480000.0, averagePerformance=74.0], Driver [name=Kevin Magnussen, id=11, teamId=8, points=0, number=20, speed=76, acceleration=82, turning=78, salary=1560000.0, averagePerformance=78.0], Driver [name=Felipe Massa, id=12, teamId=11, points=0, number=11, speed=80, acceleration=78, turning=75, salary=1540000.0, averagePerformance=77.0], Driver [name=Felipe Nasr, id=13, teamId=9, points=0, number=33, speed=76, acceleration=76, turning=79, salary=1540000.0, averagePerformance=77.0], Driver [name=Jolyon Palmer, id=14, teamId=8, points=0, number=11, speed=73, acceleration=72, turning=71, salary=1440000.0, averagePerformance=72.0], Driver [name=Sergio Perez, id=15, teamId=2, points=0, number=33, speed=86, acceleration=86, turning=85, salary=1700000.0, averagePerformance=85.0], Driver [name=Kimi Raikkonnen, id=16, teamId=1, points=0, number=11, speed=92, acceleration=90, turning=90, salary=1800000.0, averagePerformance=90.0], Driver [name=Daniel Ricciardo, id=17, teamId=7, points=0, number=33, speed=93, acceleration=94, turning=90, salary=1840000.0, averagePerformance=92.0], Driver [name=Nico Rosberg, id=18, teamId=6, points=0, number=11, speed=97, acceleration=95, turning=93, salary=1900000.0, averagePerformance=95.0], Driver [name=Carloz Sainz Junior, id=19, teamId=10, points=0, number=33, speed=81, acceleration=74, turning=82, salary=1580000.0, averagePerformance=79.0], Driver [name=Max Verstappen, id=20, teamId=7, points=0, number=11, speed=96, acceleration=96, turning=96, salary=1920000.0, averagePerformance=96.0], Driver [name=Sebastian Vettel, id=21, teamId=1, points=0, number=33, speed=94, acceleration=94, turning=94, salary=1880000.0, averagePerformance=94.0], Driver [name=Pascal Wehrlein, id=22, teamId=4, points=0, number=11, speed=74, acceleration=78, turning=74, salary=1500000.0, averagePerformance=75.0]]";
		assertEquals(res, GameController.getDrivers("./data/driver.json").toString());
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
