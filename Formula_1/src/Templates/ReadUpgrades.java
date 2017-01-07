package Templates;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadUpgrades
{
	private static String filePath = "./src/Templates/Files/Drivers.json";

	public static void main(String[] args)
	{
		System.out.println(readNestedJsonObjects(filePath, new String[] { "Max Verstappen" }));
	}

	public static Object readNestedJsonObjects(String jsonPath, String[] jsonRoute)
	{
		JSONParser parser = new JSONParser();
		//System.out.println(jsonRoute[0]);
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
							System.out.println(jsonObjects[i]);
						}
					}
				}

				return jsonObjects[jsonObjects.length - 1];
			}
		}
		catch (IOException | ParseException e)
		{
			e.printStackTrace();
		}

		return new JSONObject();
	}
}
