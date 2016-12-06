package manager.model;
 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
/**
 * @author Victor
 * @author nichelle
 * version 0.4
 */
 
public class GameData {

	public static void main(String[] args) throws IOException {
		writeJsonObjectToFile();
		readJsonObjectAndInitialize();
	}
	
    @SuppressWarnings("unchecked")
    public static Profile readJsonObjectAndInitialize(){
        JSONParser parser = new JSONParser();
 
        try {
 
            Object obj = parser.parse(new FileReader("./data.dat"));
 
            JSONObject jsonObject = (JSONObject) obj;
 
            //getting the teamname
            String teamname = (String) jsonObject.get("Teamname");
            
            //getting the budget
            String budget = (String) jsonObject.get("Budget");
            
            //getting highscore
            String highscore = (String) jsonObject.get("Highscore");
                        
            //getting car1
            JSONArray car1 = (JSONArray) jsonObject.get("Car1");
            
            //getting car2
            JSONArray car2 = (JSONArray) jsonObject.get("Car2");
            
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
            System.out.println("Car1: " + car1);
            System.out.println("Budget: " + budget);
            System.out.println("Highscore: " + highscore);
            
            Iterator<String> iteratordriver = driver1.iterator();
            
            //just printing out a specific driver to test to see if it is working
            while (iteratordriver.hasNext()) {
                
            	System.out.println(iteratordriver.next());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Profile profile;
        
        //returns back an object of your user profile
		return null;
    }
    
    @SuppressWarnings("unchecked")
    //public static void writeJsonObjectToFile(Profile profile){}
	public static void writeJsonObjectToFile() throws IOException {
    	//extract the current value from the object
    	//and write it to the data.dat file
    	//for example: 
    	//int budget = profile.getBudget();
    	
    	JSONObject obj = new JSONObject();
		obj.put("Teamname", "");
		obj.put("Budget", "2000000");
		obj.put("Highscore", "");

		//optimization needed
		JSONArray car1 = new JSONArray();
		car1.add("Brand");
		car1.add("Engine");
		obj.put("Car1", car1);
		
		JSONArray car2 = new JSONArray();
		car2.add("Brand");
		car2.add("Engine");
		obj.put("Car2", car2);
		
		//need to be optimized if we have 11 drivers!
		JSONArray driver1 = new JSONArray();
		driver1.add("Victor Wernet");
		driver1.add("1");
		driver1.add("2");
		driver1.add("3");
		driver1.add("4");
		driver1.add("5");
		driver1.add("6");
		obj.put("Driver1", driver1);
		
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter("./data.dat")) {
			file.write(obj.toJSONString());
			System.out.println("Json object successfully written to file");
			System.out.println("\nJSON Object: " + obj+"\n");
		}
    	
    }
}