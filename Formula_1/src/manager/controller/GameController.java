package manager.controller;
 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import manager.model.Car;
import manager.model.Driver;
import manager.model.Engine;
import manager.model.Profile;
 
/**
 * @author Victor
 * @author nichelle
 * version 0.4
 */
 
public class GameController {
	
	private Profile profile;
	
	//when initialized it will call the readJsonObjectAndInitialize() method to create profile according to the Json file
	public GameController() throws IOException
	{
		readJsonObjectAndInitialize();
		writeJsonObjectToFile();
		
	}
	
	//from what it reads it will make an object out of it.
    public void readJsonObjectAndInitialize(){
        
    	JSONParser parser = new JSONParser();
 
        try {
 
        	//###########################Parse##########################
            Object obj = parser.parse(new FileReader("./data.dat"));
            JSONObject jsonObject = (JSONObject) obj;
 
            //###########################Objects########################
            //getting the teamname
            String teamName = (String) jsonObject.get("Teamname");
            
            //getting the budget
            double budget = Double.parseDouble((String) jsonObject.get("Budget"));
            
            //getting highscore
            double highScore = Double.parseDouble((String) jsonObject.get("Highscore"));
            
          //###########################Arrays###########################
            //loop will be implemented
            //getting car1
            JSONArray car1Array = (JSONArray) jsonObject.get("Car1");
            JSONObject brandObject = (JSONObject) car1Array.get(0);
            String brandValueOfCar1 = (String)brandObject.get("Brand");
            System.out.println("Brand: " + brandValueOfCar1);
            
            String engineValueOfCar1 = (String) brandObject.get("Engine");
            System.out.println("Engine: " + engineValueOfCar1);
            
            Car car1 = new Car(new Driver(), new Engine());
            
            //getting car2
            JSONArray car2Array = (JSONArray) jsonObject.get("Car2");
            brandObject = (JSONObject) car2Array.get(0);
            String brandValueOfCar2 = (String) brandObject.get("Brand");
            System.out.println("Brand: " + brandValueOfCar2);
            
            String engineValueOfCar2 = (String) brandObject.get("Engine");
            System.out.println("Engine: " + engineValueOfCar2);
        
            Car car2 = new Car(new Driver(),new Engine());
            
            List<Car> carsList = new ArrayList<Car>();
            carsList.add(car1);
            carsList.add(car2);
            
            //#########################Drivers##########################
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
        	
            for(int i = 0; i < 11; i++)
            {
            	driverString+=i;
            	//System.out.println(driverString);
            	driverArray = (JSONArray) jsonObject.get(driverString);
            	object = (JSONObject) driverArray.get(0);
            	
            	//create 11 drivers
            	Driver driver = new Driver();
            	
            	for(int d = 0; d < 7; d++)
            	{
                    String valueOfObject = (String)object.get(infos[d]);   
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
                    	case 6 :double averagePerformance = Double.parseDouble(valueOfObject);
                    			driver.setAveragePerformance(averagePerformance);
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
 
            System.out.println("Teamname: " + teamName);
            System.out.println("Budget: " + budget);
            System.out.println("Highscore: " + highScore);
           
            //create the profile object
            profile = new Profile(highScore, budget, teamName);
            
            //Set the drivers to the profile
            profile.setDrivers(driversList);
        	
            //set the cars to the profile
            profile.setCars(carsList);
        	
            //setDriverToCar(,);*/
            
        } 
        
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    //public static void writeJsonObjectToFile(Profile profile){}
	public void writeJsonObjectToFile() throws IOException {
    	//extract the current value from the object
    	//and write it to the data.dat file
    	//for example: 
    	//int budget = profile.getBudget();
    	
    	//###########################User Profile#########################
    	JSONObject obj = new JSONObject();
		obj.put("Teamname", "Test");
		obj.put("Budget", "200.0");
		obj.put("Highscore", "50.0");
				
		//###########################Car 1################################
		//car parts.. will adjust it to become:
		//parts.put("Brand", profile.getBrand()); etc
		JSONObject partsOfCar1 = new JSONObject();
		partsOfCar1.put("Brand", "Ferrari");
		partsOfCar1.put("Engine", "Toyota");
		
		JSONArray car1 = new JSONArray();
		car1.add(partsOfCar1);
		obj.put("Car1", car1);
		
		//###########################Car 2################################
		JSONObject partsOfCar2 = new JSONObject();
		partsOfCar2.put("Brand", "Ferrari");
		partsOfCar2.put("Engine", "mercedes");
		
		JSONArray car2 = new JSONArray();
		car2.add(partsOfCar2);
		obj.put("Car2", car2);
		
		//###########################Drivers##############################
		
		//11 for eleven drivers.
		for(int i = 0; i < 11; i++)
		{
			//standard upon creating a game until you add drivers
			JSONObject info = new JSONObject();
			info.put("Name", "A"+i);
			info.put("Speed", "0");
			info.put("Number", ""+i);
			info.put("Acceleration", "0");
			info.put("Turning", "0");
			info.put("AveragePerformance", "0");
			info.put("Salary", "0");
			
			JSONArray driver = new JSONArray();
			driver.add(info);
			obj.put("Driver"+i, driver);
		}
		
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter("./data.dat")) {
			file.write(obj.toJSONString());
			System.out.println("Json object successfully written to file");
			System.out.println("\nJSON Object: " + obj+"\n");
		}
    }
    
    public String getTeamName()
    {
    	return profile.getTeamName();
    }
}