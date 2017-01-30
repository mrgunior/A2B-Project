package main.java.manager.model;

public class Engine 
{
	private String engineName;
	private double level;
	private int positiveStatSpeed;
	private int positiveStatAcceleration;
	private int negativeStatWeight;
	
	public Engine(String engineName, double level)
	{
		this.engineName = engineName;
		this.level = level;
	}
	
	//when called with a parameter it will send back a price
	public static double priceAtCertainLevel(double level)
	{
		//standard level = 0
		if(level<=1)
		{
			return 10.0;
		}
				
		//if level > 1, then the total amount you'll have to pay 
		return (level-0.5)*10.0; 
	}
	
	//setters########################################################
	public int getPositiveStatSpeed()
	{
		return this.positiveStatSpeed;
	}
	
	public int getPositiveStatAcceleration()
	{
		return this.positiveStatAcceleration;
	}
	
	public int getNegativeStatWeight()
	{
		return this.negativeStatWeight;
	}
	
	public String getEngineName()
	{
		return this.engineName;
	}
	
	public double getLevel()
	{
		return this.level;
	}
	
	//setters#######################################################
	public void setPositiveStatSpeed(int positiveStatSpeed)
	{
		this.positiveStatSpeed = positiveStatSpeed;
	}
	
	public void setPositiveStatAcceleration(int positiveStatAcceleration)
	{
		this.positiveStatAcceleration = positiveStatAcceleration;
	}
	
	public void setNegativeStatWeight(int negativeStatWeight)
	{
		this.negativeStatWeight = negativeStatWeight;
	}
	
	public void setEngineName(String engineName)
	{
		this.engineName = engineName;
	}
	
	public void setLevel(double level)
	{
		this.level = level;
	}
	
	public boolean equals(Engine obj) {
		
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Engine)) {
			return false;
		}
		Engine other = (Engine) obj;
		
		if (!(engineName.equals(other.getEngineName()))) {
			return false;
		}
		
		if (level != other.getLevel()) {
			return false;
		}
		
		return true;
	}
}
