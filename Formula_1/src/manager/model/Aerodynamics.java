package manager.model;

public class Aerodynamics 
{		
	//when called with a parameter it will send back a price
	public static double priceAtCertainLevel(double level)
	{
		//standard level = 0
		if(level<=1)
		{
			return 5.0;
		}
			
		//if level > 1, then the total amount you'll have to pay would be
		return (level-0.5)*5.0; 
	}
}
