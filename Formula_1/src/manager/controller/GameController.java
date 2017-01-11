package manager.controller;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.plaf.synth.SynthSeparatorUI;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Templates.ReadUpgrades;
import manager.model.Car;
import manager.model.Driver;
import manager.model.Profile;
import manager.model.Upgrades;

/**
 * @author Victor Wernet
 * @author Nichelle Fleming version 0.6
 */

public class GameController
{

	private static Profile	profile;
	private Timer			timer;
	private String			jsonFile;

	/**
	 * when initialized it will call the readJsonObjectAndInitialize() method to create profile according to
	 * the Json file it will create a timer object and call the autoSave() method to save the game every 2 min
	 * 
	 * @throws IOException
	 */
	public GameController(String jsonFile) throws IOException
	{
		this.jsonFile = jsonFile;

		readJsonObjectAndInitialize();
		timer = new Timer();

		autoSave();
	}

	public static Object readNestedObject(String jsonPath, String[] jsonRoute)
	{
		JSONParser parser = new JSONParser();
		// System.out.println(jsonRoute[0]);
		Object obj = null;
		try
		{
			obj = parser.parse(new FileReader(jsonPath));
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject[] jsonObjects = new JSONObject[jsonRoute.length];

			// Only continue if there are things specified in the array
			if (jsonRoute.length > 0)
			{
				if (jsonObject.containsKey(jsonRoute[0]))
				{
					if (jsonObject.get(jsonRoute[0]) instanceof JSONObject)
					{
						jsonObjects[0] = (JSONObject) jsonObject.get(jsonRoute[0]);
					}
					else
					{
						return jsonObject.get(jsonRoute[0]);
					}
				}
				// System.out.println(jsonObjects[0]);

				// Only continue if there are more than 1 objects specified in
				// the array
				if (jsonRoute.length > 1)
				{

					for (int i = 1; i < jsonRoute.length; i++)
					{
						// Continue if the current objects has the next nested
						// object
						if (jsonObjects[i - 1].containsKey(jsonRoute[i]))
						{
							if (jsonObjects[i - 1].get(jsonRoute[i]) instanceof JSONObject)
							{
								jsonObjects[i] = (JSONObject) jsonObjects[i - 1].get(jsonRoute[i]);
							}
							else
							{
								return (jsonObjects[i - 1].get(jsonRoute[i]));
							}
							//System.out.println(jsonObjects[i]);
						}
					}
				}

				return jsonObjects[jsonObjects.length - 1];
			}
			return jsonObject;
		}
		catch (IOException | ParseException e)
		{
			e.printStackTrace();
		}

		return new JSONObject();
	}

	/**
	 * Timer to autosave the game after every 2 min
	 */
	public void autoSave()
	{
		timer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				getDrivers();
				try
				{
					writeJsonObjectToFile();
				}

				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

		}, 2 * 60 * 1000, 2 * 60 * 1000); // in 1 minute you have 60 seconds and each second is 1000
											// milliseconds and times that by 2 gives you 2 minutes.
	}

	/**
	 * @throws IOException
	 * 
	 */
	public void stopAutoSave() throws IOException
	{
		// update the json file when the game is closed
		writeJsonObjectToFile();

		// print status out on console
		System.out.println("auto-save stopped and game saved");
		timer.cancel();
	}

	/**
	 * from what it reads it will make an object out of it.
	 */
	public void readJsonObjectAndInitialize()
	{

		JSONParser parser = new JSONParser();

		try
		{
			/*
			 * create the profile first create the drivers create the cars
			 */

			// ###########################Parse##########################
			Object obj = parser.parse(new FileReader(jsonFile));
			JSONObject jsonObject = (JSONObject) obj;

			// getting the team name
			String teamName = (String) jsonObject.get("Teamname");

			// getting the budget
			double budget = Double.parseDouble(String.valueOf(jsonObject.get("Budget")));

			// getting high score
			double highScore = Double.parseDouble(String.valueOf(jsonObject.get("Highscore")));

			// Printing them to console
			System.out.println("Teamname: " + teamName);
			System.out.println("Budget: " + budget);
			System.out.println("Highscore: " + highScore);

			// 1. create a profile from a json file (data.dat)
			profile = new Profile(highScore, budget, teamName);

			// 2. create the drivers from a json file (data.dat)
			initializeDriversInProfile(jsonObject);

			// 3. create the cars from a json file (data.dat)
			initializeCarsInProfile(jsonObject);
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * initializes the drivers to objects in Profile
	 * 
	 * @param jsonObject
	 */
	private void initializeDriversInProfile(JSONObject jsonObject)
	{
		List<Driver> driversList = new ArrayList<Driver>();

		String[] infos = new String[6];
		infos[0] = "Speed";
		infos[1] = "Salary";
		infos[2] = "Number";
		infos[3] = "Turning";
		infos[4] = "Name";
		infos[5] = "Acceleration";

		String driverString = "Driver";
		JSONArray driverArray;
		JSONObject object;

		for (int i = 0; i < 2; i++)
		{
			driverString += (i + 1);

			System.out.println("\n" + driverString);
			driverArray = (JSONArray) jsonObject.get(driverString);
			object = (JSONObject) driverArray.get(0); // get the first {} object in "Driver1":[{}] and in
														// "Driver2":[{}]

			// create 2 drivers layout
			Driver driver = new Driver(i, i, "", i, i, i, i, i, i); // name will be updated in switch case
																	// together with
																	// the other fields

			for (int d = 0; d < 6; d++)
			{
				String valueOfObject = String.valueOf(object.get(infos[d]));
				System.out.println(infos[d] + ": " + valueOfObject);

				switch (d)
				{
				case 0:
					int speed = Integer.parseInt(valueOfObject);
					driver.setSpeed(speed);
					break;
				case 1:
					double salary = Double.parseDouble(valueOfObject);
					driver.setSalary(salary);
					break;
				case 2:
					int number = Integer.parseInt(valueOfObject);
					driver.setNumber(number);
					break;
				case 3:
					int turning = Integer.parseInt(valueOfObject);
					driver.setTurning(turning);
					break;
				case 4:
					driver.setName(valueOfObject);
					break;
				case 5:
					int acceleration = Integer.parseInt(valueOfObject);
					driver.setAcceleration(acceleration);
					break;
				default: // do something else by default
					break;
				}
			}

			// each time it comes out of the inner loop it adds it to the list
			driversList.add(driver);

			// reset this for each loop. We are using this to get the second
			// driver
			driverString = "Driver";
		}

		// Set the drivers to the profile
		profile.setDrivers(driversList);
	}

	/**
	 * initializes the cars as objects in profile.
	 * 
	 * @param jsonObject
	 */
	private void initializeCarsInProfile(JSONObject jsonObject)
	{
		List<Car> carsList = new ArrayList<Car>();

		String[] standardCarStuff = new String[5];
		standardCarStuff[0] = "Speed";
		standardCarStuff[1] = "Braking";
		standardCarStuff[2] = "Acceleration";
		standardCarStuff[3] = "Weight";
		standardCarStuff[4] = "Handling";

		String[] upgradeItems = new String[7];
		upgradeItems[0] = "WeightRed";
		upgradeItems[1] = "Down";
		upgradeItems[2] = "Susp";
		upgradeItems[3] = "Tires";
		upgradeItems[4] = "Gearbox";
		upgradeItems[5] = "Aero";
		upgradeItems[6] = "Engine";

		String carString = "Car";
		JSONArray carArray;
		JSONObject objectCar;
		JSONObject objectUpgrades;

		for (int i = 0; i < 2; i++)
		{
			carString += (i + 1);

			System.out.println("\n" + carString);
			carArray = (JSONArray) jsonObject.get(carString);
			objectCar = (JSONObject) carArray.get(0); // get the first {} object
														// in "Driver1":[{}] and
														// in "Driver2":[{}]
			objectUpgrades = (JSONObject) objectCar.get("Upgrades"); // now get the object Upgrades in the
																		// object Car [{"Upgrades":{}}]

			// create 2 cars layout
			Upgrades upgrades = new Upgrades(i, i, i, i, i, i, i);
			Car car = new Car(i, i, i, i, i, upgrades); // these will be updated in the switch case

			// get the standard car stuff
			for (int c = 0; c < 5; c++)
			{
				String valueOfObject = String.valueOf(objectCar.get(standardCarStuff[c]));
				System.out.println(standardCarStuff[c] + ": " + valueOfObject);

				switch (c)
				{
				case 0:
					int speed = Integer.parseInt(valueOfObject);
					car.setSpeed(speed);
					break;
				case 1:
					int braking = Integer.parseInt(valueOfObject);
					car.setBraking(braking);
					break;
				case 2:
					int acceleration = Integer.parseInt(valueOfObject);
					car.setAcceleration(acceleration);
					break;
				case 3:
					int weight = Integer.parseInt(valueOfObject);
					car.setWeight(weight);
					break;
				case 4:
					int handling = Integer.parseInt(valueOfObject);
					car.setHandling(handling);
					break;
				default: // do something else by default
					break;
				}
			}

			// get the upgrade items now in the Upgrades Object
			for (int u = 0; u < 7; u++)
			{
				String valueOfObject = String.valueOf(objectUpgrades.get(upgradeItems[u])); // here i am
																							// getting the
																							// key:value
																							// combination
				System.out.println(upgradeItems[u] + ": " + valueOfObject);

				switch (u)
				{
				case 0:
					int weightRed = Integer.parseInt(valueOfObject);
					upgrades.setWeightRed(weightRed);
					break;
				case 1:
					int down = Integer.parseInt(valueOfObject);
					upgrades.setDown(down);
					break;
				case 2:
					int susp = Integer.parseInt(valueOfObject);
					upgrades.setSusp(susp);
					break;
				case 3:
					int tires = Integer.parseInt(valueOfObject);
					upgrades.setTires(tires);
					break;
				case 4:
					int gearbox = Integer.parseInt(valueOfObject);
					upgrades.setGearbox(gearbox);
					break;
				case 5:
					int aero = Integer.parseInt(valueOfObject);
					upgrades.setAero(aero);
					break;
				case 6:
					int engine = Integer.parseInt(valueOfObject);
					upgrades.setEngine(engine);
					break;
				default: // do something else by default
					break;
				}
			}

			// each time it comes out of the inner loop it adds it to the list
			carsList.add(car);

			// reset this for each loop. We are using this to get the second car
			carString = "Car";
		}

		// set the cars to the profile
		profile.setCars(carsList);
	}

	/**
	 * Writes everything to the data.dat file in json format
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void writeJsonObjectToFile() throws IOException
	{
		// ###########################User Profile#########################

		JSONObject obj = new JSONObject(); // create JSON object {}
		obj.put("Teamname", profile.getTeamName()); // "TeamName":""
		obj.put("Budget", String.valueOf(profile.getBudget())); // "Budget":""
		obj.put("Highscore", String.valueOf(profile.getHighScore())); // "Highscore":""

		// 2 for 2 drivers and cars.
		for (int i = 0; i < 2; i++)
		{
			// ###########################Drivers##############################

			// standard upon creating a game until you add drivers
			JSONObject info = new JSONObject(); // create an object {}
			info.put("Name", profile.getDrivers().get(i).getName()); // "Name":""
			info.put("Speed", String.valueOf(profile.getDrivers().get(i).getSpeed())); // "Speed":""
			info.put("Number", String.valueOf(profile.getDrivers().get(i).getNumber())); // "Number":""
			info.put("Acceleration", profile.getDrivers().get(i).getAcceleration()); // "Acceleration":""
			info.put("Turning", profile.getDrivers().get(i).getTurning()); // "Turning":""
			info.put("AveragePerformance", String.valueOf(profile.getDrivers().get(i).getAveragePerformance()));// "AveragePerformance":""
			info.put("Salary", String.valueOf(profile.getDrivers().get(i).getSalary())); // "Salary":""

			JSONArray driver = new JSONArray(); // create an array [], name is added later
			driver.add(info); // you get this [{}]
			obj.put("Driver" + (i + 1), driver); // "Driver":[{}]

			// ###########################Cars################################

			JSONArray car = new JSONArray(); // create an array [], name is added later

			JSONObject standardCarStuff = new JSONObject(); // create an object {} to add in the array //add
															// the key:value to the object

			standardCarStuff.put("Speed", String.valueOf(profile.getCars().get(i).getSpeed())); // "speed":""
			standardCarStuff.put("Acceleration", String.valueOf(profile.getCars().get(i).getAcceleration())); // "acceleration":""
			standardCarStuff.put("Handling", String.valueOf(profile.getCars().get(i).getHandling())); // "handling":""
			standardCarStuff.put("Braking", String.valueOf(profile.getCars().get(i).getBraking())); // "braking":""
			standardCarStuff.put("Weight", String.valueOf(profile.getCars().get(i).getWeight())); // "weight":""

			JSONObject upgradeItems = new JSONObject(); // create an object {} to add in the array add the
														// key:value to the object
			upgradeItems.put("Down", String.valueOf(profile.getCars().get(i).getUpgrades().getDown())); // "down":""
			upgradeItems.put("Aero", String.valueOf(profile.getCars().get(i).getUpgrades().getAero())); // "aero":""
			upgradeItems.put("Gearbox", String.valueOf(profile.getCars().get(i).getUpgrades().getGearbox())); // "gearbox":""
			upgradeItems.put("Engine", String.valueOf(profile.getCars().get(i).getUpgrades().getEngine())); // "engine":""
			upgradeItems.put("Susp", String.valueOf(profile.getCars().get(i).getUpgrades().getSusp())); // "susp":""
			upgradeItems.put("Tires", String.valueOf(profile.getCars().get(i).getUpgrades().getTires())); // "tires":""
			upgradeItems.put("WeightRed", String.valueOf(profile.getCars().get(i).getUpgrades().getWeightRed()));// "weightRed":""
			// we are creating this structure: [{}]
			standardCarStuff.put("Upgrades", upgradeItems); // we are now adding name: "Uprades":[{}]

			car.add(standardCarStuff); // [,,"Upgrades":[{}]]
			obj.put("Car" + (i + 1), car); // "Car1":[,,"Upgrades":[{}]]
		}

		// try-with-resources just in case if things go wrong
		try (FileWriter file = new FileWriter(jsonFile))
		{
			file.write(obj.toJSONString());
			System.out.println("\n\n################# Write to JSON file section ########################");
			System.out.println("JSON Object successfully written to file: " + jsonFile);
			System.out.println("JSON Object: " + obj + "\n");
		}
	}

	public static ArrayList<Driver> getDrivers()
	{
		System.out.println();
		String path = "./data/drivers.json";
		ArrayList<Driver> drivers = new ArrayList<Driver>();

		// System.out.println();
		// System.out.println("GameController.getDrivers(): Getting drivers from " + path);
		// System.out.println("GameController.getDrivers(): Drivers object" +
		// ReadUpgrades.readNestedJsonObjects(path, new String[] {}) + "");

		int nDrivers = ((JSONObject) readNestedObject(path, new String[] {})).size();
		for (int i = 1; i <= nDrivers; i++)
		{
			String name = (String) readNestedObject(path, new String[] { i + "", "name" });
			int points = Integer.parseInt(readNestedObject(path, new String[] { i + "", "points" }).toString());
			int id = Integer.parseInt(readNestedObject(path, new String[] { i + "", "id" }).toString());
			int teamId = Integer.parseInt(readNestedObject(path, new String[] { i + "", "teamId" }).toString());
			int number = Integer.parseInt(readNestedObject(path, new String[] { i + "", "number" }).toString());
			int speed = Integer.parseInt(readNestedObject(path, new String[] { i + "", "speed" }).toString());
			int acceleration = Integer.parseInt(readNestedObject(path, new String[] { i + "", "acceleration" }).toString());
			int turning = Integer.parseInt(readNestedObject(path, new String[] { i + "", "turning" }).toString());

			double salary = (double) ReadUpgrades.readNestedJsonObjects(path, new String[] { i + "", "salary" });

			Driver driver = new Driver(id, teamId, name, points, number, speed, acceleration, turning, salary);
			drivers.add(driver);
			// System.out.println(driver);
		}

		// System.out.println(drivers);
		return drivers;
	}

	public static void writeDriversToJSON() throws IOException
	{
		String path = "./data/drivers.json";

		ArrayList<Driver> drivers = profile.getAllDrivers();
		// System.out.println("##### All drivers:");
		// System.out.println(" " + drivers);

		JSONObject allDrivers = new JSONObject();
		for (int i = 0; i < drivers.size(); i++)
		{
			JSONObject driver = new JSONObject();
			driver.put("name", drivers.get(i).getName());
			driver.put("id", drivers.get(i).getId());
			driver.put("teamId", drivers.get(i).getTeamId());
			driver.put("points", drivers.get(i).getPoints());
			driver.put("number", drivers.get(i).getNumber());
			driver.put("speed", drivers.get(i).getSpeed());
			driver.put("acceleration", drivers.get(i).getAcceleration());
			driver.put("turning", drivers.get(i).getTurning());
			driver.put("salary", drivers.get(i).getSalary());

			allDrivers.put("" + drivers.get(i).getId() + "", driver);
		}

		try (FileWriter fileWriter = new FileWriter(path))
		{
			// System.out.println(allDrivers.toJSONString());
			fileWriter.write(allDrivers.toJSONString());
		}
	}

	/**
	 * 
	 * @return
	 */
	public String[] top22()
	{
		return new String[10];
	}

	/**
	 * very important when needed to access data in the profile object
	 * 
	 * @return
	 */
	public static Profile getProfile()
	{
		return profile;
	}
}