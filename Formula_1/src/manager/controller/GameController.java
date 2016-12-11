package manager.controller;
 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import manager.model.Profile;
 
/**
 * @author Victor
 * @author nichelle
 * version 0.4
 */
 
public class GameController {

	public static void main(String[] args) throws IOException {
		//writeJsonObjectToFile();
		readJsonObjectAndInitialize();
	}
	
	
	//from what it reads it will make an object out of it.
    @SuppressWarnings("unchecked")
    public static Profile readJsonObjectAndInitialize(){
        JSONParser parser = new JSONParser();
 
        try {
 
        	//###########################Parse##########################
            Object obj = parser.parse(new FileReader("./data.dat"));
            JSONObject jsonObject = (JSONObject) obj;
 
            //###########################Objects########################
            //getting the teamname
            String teamname = (String) jsonObject.get("Teamname");
            
            //getting the budget
            String budget = (String) jsonObject.get("Budget");
            
            //getting highscore
            String highscore = (String) jsonObject.get("Highscore");
            
          //###########################Arrays###########################
            //loop will be implemented
            //getting car1
            JSONArray car1Array = (JSONArray) jsonObject.get("Car1");
            JSONObject brandObject = (JSONObject) car1Array.get(0);
            String brandValueOfCar1 = (String)brandObject.get("Brand");
            System.out.println("Brand: " + brandValueOfCar1);
            
            //getting car2
            JSONArray car2Array = (JSONArray) jsonObject.get("Car2");
            brandObject = (JSONObject) car2Array.get(0);
            String brandValueOfCar2 = (String) brandObject.get("Brand");
            System.out.println("Brand: " + brandValueOfCar2);
            
            //drivers. Will use a for loop the next time to optimize this
            //next update
            JSONArray driver1 = (JSONArray) jsonObject.get("Driver1");
            JSONArray driver2 = (JSONArray) jsonObject.get("Driver2");
            JSONArray driver3 = (JSONArray) jsonObject.get("Driver3");
            JSONArray driver4 = (JSONArray) jsonObject.get("Driver4");
            JSONArray driver5 = (JSONArray) jsonObject.get("Driver5");
            JSONArray driver6 = (JSONArray) jsonObject.get("Driver6");
            JSONArray driver7 = (JSONArray) jsonObject.get("Driver7");
            JSONArray driver8 = (JSONArray) jsonObject.get("Driver8");
            JSONArray driver9 = (JSONArray) jsonObject.get("Driver9");
            JSONArray driver10 = (JSONArray) jsonObject.get("Driver10");
            JSONArray driver11 = (JSONArray) jsonObject.get("Driver11");
 
            System.out.println("Teamname: " + teamname);
            System.out.println("Budget: " + budget);
            System.out.println("Highscore: " + highscore);
            
            //Iterator<String> iteratordriver = driver1.iterator();
            
            //just printing out a specific driver to test to see if it is working
            /*while (iteratordriver.hasNext()) {
                
            	System.out.println(iteratordriver.next());
            }*/
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Profile profile;
        
        //returns back an object of your user profile that was loaded from the json object
		return null;
    }
    
    @SuppressWarnings("unchecked")
    //public static void writeJsonObjectToFile(Profile profile){}
	public static void writeJsonObjectToFile() throws IOException {
    	//extract the current value from the object
    	//and write it to the data.dat file
    	//for example: 
    	//int budget = profile.getBudget();
    	
    	//###########################User Profile#########################
    	JSONObject obj = new JSONObject();
		obj.put("Teamname", "");
		obj.put("Budget", "2000000");
		obj.put("Highscore", "");
				
		//###########################Car 1################################
		//car parts.. will adjust it to become:
		//parts.put("Brand", profile.getBrand()); etc
		JSONObject partsOfCar1 = new JSONObject();
		partsOfCar1 .put("Brand", "Ferrari");
		partsOfCar1 .put("Engine", "Toyota");
		
		JSONArray car1 = new JSONArray();
		car1.add(partsOfCar1 );
		obj.put("Car1", car1);
		
		//###########################Car 2################################
		JSONObject partsOfCar2 = new JSONObject();
		partsOfCar2 .put("Brand", "Ferrari");
		partsOfCar2 .put("Engine", "mercedes");
		
		JSONArray car2 = new JSONArray();
		car2.add(partsOfCar2);
		obj.put("Car2", car2);
		
		//###########################Drivers##############################
		JSONArray driver = new JSONArray();
		driver.add("Victor Wernet");
		driver.add("1");
		driver.add("2");
		driver.add("3");
		driver.add("4");
		driver.add("5");
		driver.add("6");
		//put it to the obj
		obj.put("Drivers", driver);
		
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter("./data.dat")) {
			file.write(obj.toJSONString());
			System.out.println("Json object successfully written to file");
			System.out.println("\nJSON Object: " + obj+"\n");
		}
    	
    }  
}