package manager.model;

import java.util.Random;
import java.util.ArrayList;

public class AI_Template {	
	
	public static void main(String args[]) {
		
		boolean newGame = true;

		ArrayList<Team> teams = getTeamsList();

		for (int i = 0; i < teams.size(); i++) {
			runAI(teams.get(i), newGame);
		}
		
	}

	private static ArrayList<Team> getTeamsList() {

		ArrayList<Team> teams = new ArrayList<Team>();

		Upgrades mercedesU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car mercedesC = new Car(0, 0, 0, 0, 750, mercedesU);
		Team mercedesT = new Team("Mercedes AMG Petronas", 0, 200, null, null, mercedesC);
		
		Upgrades mercedesU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car mercedesC = new Car(0, 0, 0, 0, 750, mercedesU);
		Team mercedesT = new Team("Mercedes AMG Petronas", 0, 200, null, null, mercedesC);
		
		Upgrades mercedesU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car mercedesC = new Car(0, 0, 0, 0, 750, mercedesU);
		Team mercedesT = new Team("Mercedes AMG Petronas", 0, 200, null, null, mercedesC);
		
		Upgrades mercedesU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car mercedesC = new Car(0, 0, 0, 0, 750, mercedesU);
		Team mercedesT = new Team("Mercedes AMG Petronas", 0, 200, null, null, mercedesC);
		
		Upgrades mercedesU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car mercedesC = new Car(0, 0, 0, 0, 750, mercedesU);
		Team mercedesT = new Team("Mercedes AMG Petronas", 0, 200, null, null, mercedesC);
		
		Upgrades mercedesU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car mercedesC = new Car(0, 0, 0, 0, 750, mercedesU);
		Team mercedesT = new Team("Mercedes AMG Petronas", 0, 200, null, null, mercedesC);
		
		Upgrades mercedesU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car mercedesC = new Car(0, 0, 0, 0, 750, mercedesU);
		Team mercedesT = new Team("Mercedes AMG Petronas", 0, 200, null, null, mercedesC);
		
		Upgrades mercedesU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car mercedesC = new Car(0, 0, 0, 0, 750, mercedesU);
		Team mercedesT = new Team("Mercedes AMG Petronas", 0, 200, null, null, mercedesC);
		
		Upgrades mercedesU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car mercedesC = new Car(0, 0, 0, 0, 750, mercedesU);
		Team mercedesT = new Team("Mercedes AMG Petronas", 0, 200, null, null, mercedesC);
		
		Upgrades mercedesU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car mercedesC = new Car(0, 0, 0, 0, 750, mercedesU);
		Team mercedesT = new Team("Mercedes AMG Petronas", 0, 200, null, null, mercedesC);
		
		Upgrades mercedesU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car mercedesC = new Car(0, 0, 0, 0, 750, mercedesU);
		Team mercedesT = new Team("Mercedes AMG Petronas", 0, 200, null, null, mercedesC);
		
		Upgrades mercedesU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car mercedesC = new Car(0, 0, 0, 0, 750, mercedesU);
		Team mercedesT = new Team("Mercedes AMG Petronas", 0, 200, null, null, mercedesC);
		
		teams.add(mercedesT);
		
		return teams;
		
	}

	private static void runAI(Team team, boolean newGame) {

	   /* 	Team is object with:
		* 	- Unique team ID
		*	- 2 Drivers
		*	- A balance
		*	- Unique car with upgrades
		*/
		
		Team currentT = team;
		Car currentC = currentT.getCar();
		
		if (newGame) {
			
			//TODO create buyDrivers class
			//buyDrivers();
			
		}
		
		while (currentT.getBalance() > 25) {
			
			//Buy random upgrade if possible, we have 7 upgrade possibilities so random number between 0 and 6
			//TODO Create buyable upgrade method
			
			switch (random()) {
			case 0:
				//Upgrade Downforce
//				if (upgradePrice < currentT.getBalance() && currentC.getUpgrades().getDown() != 5) {
//					buyUpgrade(0);
//				}
				currentC.getUpgrades().setDown((currentC.getUpgrades().getDown() + 1));
				break;
			case 1:
				//Upgrade Aerodynamics
//				if (upgradePrice < currentT.getBalance() && currentC.getUpgrades().getAero() != 5) {
//					buyUpgrade(0);
//				}
				currentC.getUpgrades().setAero((currentC.getUpgrades().getAero() + 1));
				break;
			case 2:
				//Upgrade Gearbox
//				if (upgradePrice < currentT.getBalance() && currentC.getUpgrades().getGearbox() != 5) {
//					buyUpgrade(0);
//				}
				currentC.getUpgrades().setGearbox((currentC.getUpgrades().getGearbox() + 1));
				break;
			case 3:
				//Upgrade Engine
//				if (upgradePrice < currentT.getBalance() && currentC.getUpgrades().getEngine() != 5) {
//					buyUpgrade(0);
//				}
				currentC.getUpgrades().setEngine((currentC.getUpgrades().getEngine() + 1));
				break;
			case 4:
				//Upgrade Suspension
//				if (upgradePrice < currentT.getBalance() && currentC.getUpgrades().getSusp() != 5) {
//					buyUpgrade(0);
//				}
				currentC.getUpgrades().setSusp((currentC.getUpgrades().getSusp() + 1));
				break;
			case 5:
				//Upgrade Tires
//				if (upgradePrice < currentT.getBalance() && currentC.getUpgrades().getTires() != 5) {
//					buyUpgrade(0);
//				}
				currentC.getUpgrades().setTires((currentC.getUpgrades().getTires() + 1));
				break;
			case 6:
				//Upgrade Weight Reduction
//				if (upgradePrice < currentT.getBalance() && currentC.getUpgrades().getWeightRed() != 5) {
//					buyUpgrade(0);
//				}
				currentC.getUpgrades().setWeightRed((currentC.getUpgrades().getWeightRed() + 1));
				break;
			}
			
		}
		
	}

	private static int random() {

		int randomI;
		
		Random value = new Random();
		double randomD = value.nextInt(7 - 0 + 1);
		
		if (randomD < 1) {
			randomI  = 0;
		} else if (randomD < 2) {
			randomI = 1;
		} else if (randomD < 3) {
			randomI = 2;
		} else if (randomD < 4) {
			randomI = 3;
		} else if (randomD < 5) {
			randomI = 4;
		} else if (randomD < 6) {
			randomI = 5;
		} else {
			randomI = 6;
		}
		
		return randomI;
		
	}	
	
}
