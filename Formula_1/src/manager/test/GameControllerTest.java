package manager.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import manager.model.Profile;
import manager.model.Upgrades;
import manager.model.Car;
import manager.model.Driver;
import manager.model.GameController;

public class GameControllerTest 
{
	private GameController gamecontroller;
	private Profile testProfile;
	private String teamname ="TestTeam", jsonFile = "./JsonTestFilesDontTouch/dataTest.json";
	private double highScore = 50.0, budget = 200.0;
	private List<Car> cars = new ArrayList<Car>();
	private Car car1, car2;
	private List<Driver> drivers = new ArrayList<Driver>();
	private Driver driver1, driver2;
	
	@Before
	public void setUp() throws IOException
	{	
		gamecontroller = new GameController(jsonFile);
		testProfile = new Profile(highScore, budget, teamname);
		
		car1 = new Car(0,0,0,0,0, new Upgrades(0,0,0,0,0,0,0), 0, 0);
		car2 = new Car(0,0,0,0,0, new Upgrades(1,1,1,1,1,1,1), 0, 0);
		cars.add(car1);
		cars.add(car2);
		
		driver1 = new Driver(1,2,"Victor Wernet",0,33,80,75,69,1480000.0);
		driver2 = new Driver(2,2,"Nichelle Fleming",0,33,80,75,69,1480000.0);
		drivers.add(driver1);
		drivers.add(driver2);
		
		testProfile.setCar(car1);
		testProfile.setDrivers(drivers);
	}
	
	@After
	public void tearDown() throws IOException
	{
		//need to do this otherwise after time you run a test it use recourse and not close it.
		gamecontroller.stopAutoSave();
	}
	
	@Test
	public void testReadJsonObjectAndInitializeDifferentHighScore()
	{
		assertFalse("After readJsonObjectAndInitialize has been called profile should have been created", GameController.getProfile().equals(testProfile));
	}
	
	@Test
	public void testReadJsonObjectAndInitializeSameHighScore()
	{	
		assertTrue("After readJsonObjectAndInitialize has been called profile should have been created", GameController.getProfile().getHighScore() == testProfile.getHighScore());
	}
	
	@Test
	public void testReadJsonObjectAndInitializeSameBudget()
	{
		assertTrue("After readJsonObjectAndInitialize has been called profile should have been created", Profile.getBudget() == Profile.getBudget());
	}
		
	@Test
	public void testGetDriversZero()
	{
		List<Driver> driverTest = GameController.getDrivers("./JsonTestFilesDontTouch/driversTest.json");
		assertEquals("Driver lists is correctly read and initialized at index 0",driverTest.get(0).toString(),"Driver [name=Kevin Magnussen, id=11, teamId=8, points=0, number=20, speed=76, acceleration=82, turning=78, salary=1560000.0, averagePerformance=78.0]");
	}
	
	@Test
	public void testGetDriversOne()
	{
		List<Driver> driverTest = GameController.getDrivers("./JsonTestFilesDontTouch/driversTest.json");
		assertEquals("Driver lists is correctly read and initialized at index 1",driverTest.get(1).toString(),"Driver [name=Pascal Wehrlein, id=22, teamId=4, points=0, number=11, speed=74, acceleration=78, turning=74, salary=1500000.0, averagePerformance=75.0]");
	}
	
	@Test
	public void testReadCarsFromJsonZero()
	{
		ArrayList<Car> carsTest = GameController.readCarsFromJSON("./JsonTestFilesDontTouch/carsTest.json");
		assertEquals("Car lists is correctly read and initialized at index 0",carsTest.get(0).toString(),"<Car[speed: 50, braking: 50, acceleration: 50, weight: 750, handling: 50, Upgrades[weightRed: 0, down: 0, susp: 0, tires: 0, gearbox: 0, aero: 0, engine: 0]>]>");
	}
	
	@Test
	public void testReadCarsFromJsonOne()
	{
		ArrayList<Car> carsTest = GameController.readCarsFromJSON("./JsonTestFilesDontTouch/carsTest.json");
		assertEquals("Car lists is correctly read and initialized at index 1",carsTest.get(1).toString(),"<Car[speed: 50, braking: 50, acceleration: 50, weight: 550, handling: 50, Upgrades[weightRed: 0, down: 0, susp: 0, tires: 0, gearbox: 0, aero: 0, engine: 0]>]>");
	}
		
	@Test
	public void testReadNestedObjectEmpty()
	{
		JSONObject testObject = (JSONObject)GameController.readNestedObject("./JsonTestFilesDontTouch/driversTestEmpty.json", new String[] { "1" });
		assertNull("Objects should be null", testObject);
	}
	
	@Test
	public void testWriteDriversToJSON() throws IOException
	{
		List<Driver> driversTest = GameController.getDrivers("./JsonTestFilesDontTouch/driversTest.json");
		testProfile.setAllDrivers((ArrayList<Driver>)driversTest);
		Profile.getAllDrivers().get(0).setPoints(444);
		Profile.getAllDrivers().get(1).setPoints(444);
		
		GameController.writeDriversToJSON("./JsonTestFilesDontTouch/driversTestWrite.json");
		assertEquals("Car lists is correctly read and initialized at index 1",Profile.getAllDrivers().get(1).toString(),"Driver [name=Pascal Wehrlein, id=22, teamId=4, points=444, number=11, speed=74, acceleration=78, turning=74, salary=1500000.0, averagePerformance=75.0]");
	}
}