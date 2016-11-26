import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
/**
 * @author Nichelle Fleming
 */
 
public class WriteToFile{
 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
 
		//creating a json object and putting values
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Username", "");
		jsonObject.put("Budget", "200000000");
 
		//creating a new jsonarray 
		JSONArray car1 = new JSONArray();
		car1.add("Mercedes");
		car1.add("good");
		jsonObject.put("Car1",car1);
		
		JSONArray car2 = new JSONArray();
		car2.add("Mercedes");
		car2.add("best");
		jsonObject.put("Car2",car2);

		JSONArray driver1 = new JSONArray();
		driver1.add("Max Verstappen");
		driver1.add(33);
		driver1.add(92);
		driver1.add(91);
		driver1.add(98);
		driver1.add(94.1);
		driver1.add(20.8);
		jsonObject.put("Driver1",driver1);
		
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter("./data.dat")) {
			file.write(jsonObject.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + jsonObject);
		}
	}
}