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
		
		Upgrades redBullU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car redBullC = new Car(0, 0, 0, 0, 750, redBullU);
		Team redBullT = new Team("Red Bull Racing", 0, 200, null, null, redBullC);
		
		Upgrades ferrariU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car ferrariC = new Car(0, 0, 0, 0, 750, ferrariU);
		Team ferrariT = new Team("Scuderia Ferrari", 0, 200, null, null, ferrariC);
		
		Upgrades saharaU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car saharaC = new Car(0, 0, 0, 0, 750, saharaU);
		Team saharaT = new Team("Sahara Force India F1", 0, 200, null, null, saharaC);
		
		Upgrades martiniU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car martiniC = new Car(0, 0, 0, 0, 750, martiniU);
		Team martiniT = new Team("Williams Martini Racing", 0, 200, null, null, martiniC);
		
		Upgrades mcLarenU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car mcLarenC = new Car(0, 0, 0, 0, 750, mcLarenU);
		Team mcLarenT = new Team("McLaren Honda", 0, 200, null, null, mcLarenC);
		
		Upgrades torroRossoU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car torroRossoC = new Car(0, 0, 0, 0, 750, torroRossoU);
		Team torroRossoT = new Team("Scuderia Toro Rosso", 0, 200, null, null, torroRossoC);
		
		Upgrades haasU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car haasC = new Car(0, 0, 0, 0, 750, haasU);
		Team haasT = new Team("Haas F1 Team", 0, 200, null, null, haasC);
		
		Upgrades renaultU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car renaultC = new Car(0, 0, 0, 0, 750, renaultU);
		Team renaultT = new Team("Renault", 0, 200, null, null, renaultC);
		
		Upgrades sauberU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car sauberC = new Car(0, 0, 0, 0, 750, sauberU);
		Team sauberT = new Team("Sauber F1 Team", 0, 200, null, null, sauberC);
		
		Upgrades manorU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car manorC = new Car(0, 0, 0, 0, 750, manorU);
		Team manorT = new Team("Manor Racing", 0, 200, null, null, manorC);
		
		Upgrades customU = new Upgrades(0, 0, 0, 0, 0, 0, 0);
		Car customC = new Car(0, 0, 0, 0, 750, customU);
		Team customT = new Team("Custom team name here", 0, 200, null, null, customC);
		
		teams.add(mercedesT);
		teams.add(redBullT);
		teams.add(ferrariT);
		teams.add(saharaT);
		teams.add(martiniT);
		teams.add(mcLarenT);
		teams.add(torroRossoT);
		teams.add(haasT);
		teams.add(renaultT);
		teams.add(sauberT);
		teams.add(manorT);
		teams.add(customT);
		
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
