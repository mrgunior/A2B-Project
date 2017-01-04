package manager.controller;
 
import java.util.Timer;
import java.util.TimerTask;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import manager.model.Car;
import manager.model.Driver;
import manager.model.Profile;
import manager.model.Upgrades;
 
/**
 * @author Victor Wernet
 * @author Nichelle Fleming
 * version 0.6
 */
 
public class GameController {
	
	private Profile profile;
	private Timer timer;
	private String jsonFile;
	
	/**
	 * when initialized it will call the readJsonObjectAndInitialize() method to create profile according to the Json file
	 * it will create a timer object and call the autoSave() method to save the game every 2 min
	 * @throws IOException
	 */
	public GameController(String jsonFile) throws IOException
	{
		this.jsonFile = jsonFile;
		
		readJsonObjectAndInitialize();
		timer = new Timer();
		
		autoSave();
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
				try 
				{
					writeJsonObjectToFile();
				} 
				
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			
		}, 2*60*1000, 2*60*1000); //in 1 minute you have 60 seconds and each second is 1000 milliseconds and times that by 2 gives you 2 minutes.
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	public void stopAutoSave() throws IOException
	{
		//update the json file when the game is closed
		writeJsonObjectToFile();

		//print status out on console
		System.out.println("auto-save stopped and game saved");
		timer.cancel();
	}
	
	/**
	 * from what it reads it will make an object out of it.
	 */
    public void readJsonObjectAndInitialize(){
        
    	JSONParser parser = new JSONParser();
 
        try 
        {      	
        	/*
        	 * create the profile first
			 * create the drivers
			 * create the cars		
        	 */
        	
        	//###########################Parse##########################
            Object obj = parser.parse(new FileReader(jsonFile));
            JSONObject jsonObject = (JSONObject) obj;
 
            //getting the team name
            String teamName = (String) jsonObject.get("Teamname");
            
            //getting the budget
            double budget = Double.parseDouble(String.valueOf(jsonObject.get("Budget")));
            
            //getting high score
            double highScore = Double.parseDouble(String.valueOf(jsonObject.get("Highscore")));
            
            //Printing them to console
            System.out.println("Teamname: " + teamName);
            System.out.println("Budget: " + budget);
            System.out.println("Highscore: " + highScore);
           
            //1. create a profile from a json file (data.dat)
            profile = new Profile(highScore, budget, teamName);
            
            //2. create the drivers from a json file (data.dat)
            initializeDriversInProfile(jsonObject);
            
            //3. create the cars from a json file (data.dat)
            initializeCarsInProfile(jsonObject);
        } 
        
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * initializes the drivers to objects in Profile
     * @param jsonObject
     */
    private void initializeDriversInProfile(JSONObject jsonObject) {
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
    	
        for(int i = 0; i < 2; i++)
        {
        	driverString+=(i+1);
        	
        	//System.out.println(driverString);
        	driverArray = (JSONArray) jsonObject.get(driverString);
        	object = (JSONObject) driverArray.get(0);
        	
        	//create 2 drivers
        	Driver driver = new Driver(driverString, i, i, i, i, i);
        	
        	for(int d = 0; d < 6; d++)
        	{
                String valueOfObject = String.valueOf(object.get(infos[d]));   
                System.out.println(infos[d]+": "+valueOfObject);
                
                switch(d)
                {
                	case 0 :int speed = Integer.parseInt(valueOfObject);
                			driver.setSpeed(speed);
                			break;
                	case 1 :double salary = Double.parseDouble(valueOfObject);
                			driver.setSalary(salary);
            				break;
                	case 2 :int number = Integer.parseInt(valueOfObject);
                			driver.setNumber(number);
            				break;
                	case 3 :int turning = Integer.parseInt(valueOfObject);
                			driver.setTurning(turning);
            				break;
                	case 4 :driver.setName(valueOfObject);
            				break;
                	case 5 :int acceleration = Integer.parseInt(valueOfObject);
                			driver.setAcceleration(acceleration);
            				break;
            		default : //do something else by default
            				break;	
                }
        	}
        	
        	//each time it comes out of the inner loop it adds it to the list
        	driversList.add(driver);
        	//reset this for each loop
        	driverString = "Driver";
        }
        
        //Set the drivers to the profile
        profile.setDrivers(driversList);
	}

    /**
     * initializes the cars as objects in profile.
     * @param jsonObject
     */
	private void initializeCarsInProfile(JSONObject jsonObject) 
	{
        //getting car1 #################################################
        JSONArray car = (JSONArray) jsonObject.get("Car1");
        
        
        Car car1 = new Car(0, 0, 0, 0, 0, new Upgrades(0,0,0,0,0,0,0));
        
        //getting car2 ################################################
        car = (JSONArray) jsonObject.get("Car2");
    
        Car car2 = new Car(0, 0, 0, 0, 0, new Upgrades(0,0,0,0,0,0,0));
        
        //Creating an ArrayList########################################
        List<Car> carsList = new ArrayList<Car>();
        carsList.add(car1);
        carsList.add(car2);
        
        //set the cars to the profile
        profile.setCars(carsList);
	}

	
	/**
	 * Writes everything to the data.dat file in json format
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void writeJsonObjectToFile() throws IOException 
	{
    	//###########################User Profile#########################
    	
    	JSONObject obj = new JSONObject();																	//create JSON object {}
		obj.put("Teamname", profile.getTeamName());															//"TeamName":""
		obj.put("Budget", String.valueOf(profile.getBudget()));												//"Budget":""
		obj.put("Highscore", String.valueOf(profile.getHighScore()));										//"Highscore":""
			
		//2 for 2 drivers and cars.
		for(int i = 0; i < 2; i++)
		{
			//###########################Drivers##############################
			
			//standard upon creating a game until you add drivers
			JSONObject info = new JSONObject();																	//create an object {}
			info.put("Name", profile.getDrivers().get(i).getName());											//"Name":""
			info.put("Speed", String.valueOf(profile.getDrivers().get(i).getSpeed()));							//"Speed":""
			info.put("Number", String.valueOf(profile.getDrivers().get(i).getNumber()));						//"Number":""
			info.put("Acceleration", profile.getDrivers().get(i).getAcceleration());							//"Acceleration":""
			info.put("Turning", profile.getDrivers().get(i).getTurning());										//"Turning":""
			info.put("AveragePerformance", String.valueOf(profile.getDrivers().get(i).getAveragePerformance()));//"AveragePerformance":""
			info.put("Salary", String.valueOf(profile.getDrivers().get(i).getSalary()));						//"Salary":""
			
			JSONArray driver = new JSONArray();																	//create an array [], name is added later
			driver.add(info);																					//you get this [{}]
			obj.put("Driver"+(i+1), driver);																	//"Driver":[{}]
			
			//###########################Cars################################
			
			JSONArray car = new JSONArray(); 																	//create an array [], name is added later
			
			JSONObject standardCarStuff = new JSONObject(); 													//create an object {} to add in the array																												//add the key:value to the object
			
			standardCarStuff.put("speed", String.valueOf(profile.getCars().get(i).getSpeed())); 				//"speed":""
			standardCarStuff.put("acceleration", String.valueOf(profile.getCars().get(i).getAcceleration())); 	//"acceleration":""
			standardCarStuff.put("handling", String.valueOf(profile.getCars().get(i).getHandling())); 			//"handling":""
			standardCarStuff.put("braking", String.valueOf(profile.getCars().get(i).getBraking())); 			//"braking":""
			standardCarStuff.put("weight", String.valueOf(profile.getCars().get(i).getWeight())); 				//"weight":""
			
			JSONArray upgrades = new JSONArray();																//create an array [], name is added later								
			JSONObject upgradeItems = new JSONObject();															//create an object {} to add in the array
																												//add the key:value to the object
			upgradeItems.put("down", String.valueOf(profile.getCars().get(i).getUpgrades().getDown()));			//"down":""
			upgradeItems.put("aero", String.valueOf(profile.getCars().get(i).getUpgrades().getAero()));			//"aero":""
			upgradeItems.put("gearbox", String.valueOf(profile.getCars().get(i).getUpgrades().getGearbox()));	//"gearbox":""
			upgradeItems.put("engine", String.valueOf(profile.getCars().get(i).getUpgrades().getEngine()));		//"engine":""
			upgradeItems.put("susp", String.valueOf(profile.getCars().get(i).getUpgrades().getSusp()));			//"susp":""
			upgradeItems.put("tires", String.valueOf(profile.getCars().get(i).getUpgrades().getTires()));		//"tires":""
			upgradeItems.put("weightRed", String.valueOf(profile.getCars().get(i).getUpgrades().getWeightRed()));//"weightRed":""
			
			upgrades.add(upgradeItems);																			//we are creating this structure: [{}]
			standardCarStuff.put("Upgrades", upgrades);															//we are now adding name: "Uprades":[{}]
			
			car.add(standardCarStuff);																			//[,,"Upgrades":[{}]]
			obj.put("Car"+(i+1), car);																			// "Car1":[,,"Upgrades":[{}]] 
		}
		
		//try-with-resources just in case if things go wrong
		try (FileWriter file = new FileWriter(jsonFile)) 
		{
			file.write(obj.toJSONString());
			System.out.println("Json object successfully written to file");
			System.out.println("\nJSON Object: " + obj+"\n");
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
	 * @return
	 */
    public Profile getProfile()
    {
    	return this.profile;
    }
}