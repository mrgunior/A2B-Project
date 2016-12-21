package manager.model;

public class AI_Template {

	public static void main(String args[]) {
	
		Car mercedesC = new Car(0, 0, 0, 0, 750);
		Team mercedesT = new Team("Mercedes AMG Petronas", 0, 200, null, null, mercedesC);
		
		boolean newGame = true;
		
		int teamID = 1;
		runAI(teamID, newGame);
		
	}

	private static void runAI(int teamID, boolean newGame) {

	   /* 	Team is object with:
		* 	- Unique team ID
		*	- 2 Drivers
		*	- A balance
		*	- Unique car with upgrades
		*/
		
		if (newGame) {
			
			buyDrivers();
			
		}
		
	}	
	
}
