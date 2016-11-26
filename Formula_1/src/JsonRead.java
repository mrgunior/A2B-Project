import java.io.FileReader;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
/**
 * @author Victor Wernet
 */
 
public class JsonRead 
{
    public static void main(String[] args) 
    {
    	//needs to be split into different methods
        JSONParser parser = new JSONParser();
        try 
        {
        	//creating an object to later on cast it to a jsonobject
            Object obj = parser.parse(new FileReader("./data.dat"));
            JSONObject jsonObject = (JSONObject) obj;
 
            //getting the values of specific keys
            String username = (String) jsonObject.get("Username");
            int budget = Integer.parseInt((String)jsonObject.get("Budget"));
            
            //getting keys that have arrays
            JSONArray car1 = (JSONArray) jsonObject.get("Car1");
            JSONArray car2 = (JSONArray) jsonObject.get("Car2");
            JSONArray driver1 = (JSONArray) jsonObject.get("d1");
            
            //creating the arrays into iterations
            Iterator<String> car1Iterator = car1.iterator();
            Iterator<String> car2Iterator = car2.iterator();
            Iterator<String> driver1Iterator = driver1.iterator();
            
            //printoutContent of array driver1Iterator
            while (driver1Iterator.hasNext()) 
            {
                System.out.println(driver1Iterator.next());
            }
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}