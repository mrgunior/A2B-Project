package Templates;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadUpgrades
{
	private static String filePath = "./upgrades.dat";
			
	public static void main(String[] args)
	{
		JSONParser parser = new JSONParser();
		
		Object obj = null;
		try
		{
			obj = parser.parse(new FileReader(filePath));
	        
	        System.out.println(readNestedJSON(new String[] {"upgrades", "susp", "level1", "price"}));
		}
		catch (IOException | ParseException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Object readNestedJSON(String[] jsonRoute)
	{
		// jsonRoute = [upgrades, down, level1, name];
		
		JSONParser parser = new JSONParser();
		System.out.println(jsonRoute[0]);
		Object obj = null;
		try
		{
			obj = parser.parse(new FileReader(filePath));
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject[] jsonObjects = new JSONObject[jsonRoute.length];
			
			if (jsonRoute.length > 0)
			{
				jsonObjects[0] = (JSONObject) jsonObject.get(jsonRoute[0]);
				System.out.println(jsonObjects[0]);
				
				if (jsonRoute.length > 1)
				{
					for (int i = 1 ; i < jsonObjects.length; i++)
					{
						if (jsonObjects[i-1].get(jsonRoute[i]) instanceof JSONObject)
						{
							jsonObjects[i] = (JSONObject) jsonObjects[i-1].get(jsonRoute[i]);
						}
						else
						{
							return (jsonObjects[i-1].get(jsonRoute[i]));
						}
						System.out.println(jsonObjects[i]);
					}
				}
				
				return jsonObjects[jsonObjects.length-1];
			}
		}
		catch (IOException | ParseException e)
		{
			e.printStackTrace();
		}
		
		return new JSONObject();
	}
}
