package manager.model;

public class Engine 
{
	private String engineName;
	private double level;
	
	public Engine(String engineName, double level)
	{
		this.engineName = engineName;
		this.level = level;
	}
	
	//when called with a parameter it will send back a price
	public static double priceAtCertainLevel(double level)
	{
		//standard level = 0
		if(level==1)
		{
			return 10.0;
		}
				
		//if level > 1, then the total amount you'll have to pay would 
		return (level-0.5)*10.0; 
	}
	
	//setters########################################################
	public String getEngineName()
	{
		return this.engineName;
	}
	
	public double getLevel()
	{
		return this.level;
	}
	
	//setters#######################################################
	public void setEngineName(String engineName)
	{
		this.engineName = engineName;
	}
	
	public void setLevel(double level)
	{
		this.level = level;
	}
}
