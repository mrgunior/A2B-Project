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
 
/**
 * @author Victor Wernet
 * @author Nichelle Fleming
 * version 0.6
 */
 
public class GameController {
	
	private Profile profile;
	private Timer timer;
	
	/**
	 * when initialized it will call the readJsonObjectAndInitialize() method to create profile according to the Json file
	 * it will create a timer object and call the autoSave() method to save the game every 2 min
	 * @throws IOException
	 */
	public GameController() throws IOException
	{
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
	 * from what it reads it will make an object out of it.
	 */
    public void readJsonObjectAndInitialize(){
        
    	JSONParser parser = new JSONParser();
 
        try {
        	
        	/*
        	 * create the profile first
			 * create the drivers
			 * create the cars		
        	 */
        	//###########################Parse##########################
            Object obj = parser.parse(new FileReader("./data.dat"));
            JSONObject jsonObject = (JSONObject) obj;
 
            //getting the teamname
            String teamName = (String) jsonObject.get("Teamname");
            
            //getting the budget
            double budget = Double.parseDouble(String.valueOf(jsonObject.get("Budget")));
            
            //getting highscore
            double highScore = Double.parseDouble(String.valueOf(jsonObject.get("Highscore")));
            
            //just checking
            System.out.println("Teamname: " + teamName);
            System.out.println("Budget: " + budget);
            System.out.println("Highscore: " + highScore);
           
            //1.
            profile = new Profile(highScore, budget, teamName);
            
            //2.
            initializeDriversInProfile(jsonObject);
            
            //3.
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
        
        String[] infos = new String[7];
        infos[0] = "Speed";
        infos[1] = "Salary";
        infos[2] = "Number";
        infos[3] = "Turning";
        infos[4] = "Name";
        infos[5] = "Acceleration";
        infos[6] = "AveragePerformance";
        
        String driverString = "Driver";
        JSONArray driverArray;
    	JSONObject object;
    	
        for(int i = 0; i < 2; i++)
        {
        	driverString+=i;
        	
        	//System.out.println(driverString);
        	driverArray = (JSONArray) jsonObject.get(driverString);
        	object = (JSONObject) driverArray.get(0);
        	
        	//TODO create 11 drivers
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
            		default : 
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
        JSONObject enginenameObject = (JSONObject) car.get(0);
        String engineNameValue = (String)enginenameObject.get("EngineName");
        System.out.println("Car1");
        System.out.println("EngineName: " + engineNameValue);
        
        double engineValue = Double.parseDouble(String.valueOf(enginenameObject.get("EngineLevel")));
        System.out.println("EngineLevel: " + engineValue);
        
        //TODO fill in values for car1
        Car car1 = new Car(0, 0, 0, 0, 0, null);
        
        //getting car2 ################################################
        car = (JSONArray) jsonObject.get("Car2");
        enginenameObject = (JSONObject) car.get(0);
        engineNameValue = (String) enginenameObject.get("EngineName");
        System.out.println("Car2");
        System.out.println("EngineName: " + engineNameValue);
        
        engineValue = Double.parseDouble(String.valueOf(enginenameObject.get("EngineLevel")));
        System.out.println("EngineLevel: " + engineValue);
    
        //TODO fill in values for car2
        Car car2 = new Car(0, 0, 0, 0, 0, null);
        
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
    	
    	JSONObject obj = new JSONObject();
		obj.put("Teamname", profile.getTeamName());
		obj.put("Budget", String.valueOf(profile.getBudget()));
		obj.put("Highscore", String.valueOf(profile.getHighScore()));
				
		//###########################Car 1################################
		
		JSONObject partsOfCar1 = new JSONObject();
		
		//TODO Remove this or change, no more Engine object
//		partsOfCar1.put("EngineName", profile.getCars().get(0).getEngine().getEngineName());
//		partsOfCar1.put("EngineLevel", String.valueOf(profile.getCars().get(0).getEngine().getLevel()));
		
		JSONArray car1 = new JSONArray();
		car1.add(partsOfCar1);
		obj.put("Car1", car1);
		
		//###########################Car 2################################
		JSONObject partsOfCar2 = new JSONObject();
		
		//TODO Remove this or change, no more Engine object
//		partsOfCar2.put("EngineName", profile.getCars().get(1).getEngine().getEngineName());
//		partsOfCar2.put("EngineLevel", String.valueOf(profile.getCars().get(0).getEngine().getLevel()));
		
		JSONArray car2 = new JSONArray();
		car2.add(partsOfCar2);
		obj.put("Car2", car2);
		
		//###########################Drivers##############################
		
		//2 for eleven drivers.
		for(int i = 0; i < 2; i++)
		{
			//standard upon creating a game until you add drivers
			JSONObject info = new JSONObject();
			info.put("Name", profile.getDrivers().get(i).getName());
			info.put("Speed", String.valueOf(profile.getDrivers().get(i).getSpeed()));
			info.put("Number", String.valueOf(profile.getDrivers().get(i).getNumber()));
			info.put("Acceleration", profile.getDrivers().get(i).getAcceleration());
			info.put("Turning", profile.getDrivers().get(i).getTurning());
			info.put("AveragePerformance", String.valueOf(profile.getDrivers().get(i).getAveragePerformance()));
			info.put("Salary", String.valueOf(profile.getDrivers().get(i).getSalary()));
			
			JSONArray driver = new JSONArray();
			driver.add(info);
			obj.put("Driver"+i, driver);
		}
		
		//try-with-resources just in case if things go wrong
		try (FileWriter file = new FileWriter("./data.dat")) 
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