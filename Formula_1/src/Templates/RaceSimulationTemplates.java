package Templates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RaceSimulationTemplates {

	/* Using drivers:
	 * Max Verstappen: 		Average 96
	 * Nico Rosberg:		Average 95
	 * Lewis Hamilton:  	Average 94.7
	 * Sebastian Vettel: 	Average 94
	 * Daniel Ricciardo:	Average 92.3
	 * Kimi Raikkonnen:		Average 90.7
	 * Sergio Pérez:		Average 85.7
	 * Fernando Alonso: 	Average 84
	 * Valtteri Bottas:		Average 82.3
	 * Nicolas Hulkenberg:	Average 79.7
	 * Carloz Sainz Junior:	Average 79
	 * Kevin Magnussen:		Average 78.7
	 * Felipe Massa:		Average 77.7
	 * Jensen Button:		Average 77.3
	 * Felipe Nasr: 		Average 77
	 * Romain Grosjean		Average 76.7
	 * Pascal Wehrlein		Average 75.3
	 * Marcus Ericsson		Average 75
	 * Daniil Kvyat			Average 74
	 * Jolyon Palmer		Average 72
	 * Rio Haryanto			Average 71
	 * Esteban Gutierrez	Average 70 
	 * 
	 * Using Cars:
	 * Stock car:	Average 50.0
	 * Average car:	Average 70.6
	 * Max car:		Average 91.3
	 * 
	 * Using tracks:
	 * Baku City Circuit, 	AZ: Difficulty: 2.33
	 * Spa-Francorchamps,	BE: Difficulty: 1.33
	 * Silverstone, 		UK: Difficulty: 4.00
	 * Monza,				IT: Difficulty:	2.78
	 * Monte Carlo, 		MO: Difficulty: 5.32
	 */

	//Filling the lists with driver names and their averages
	static List<String> drivers = getDriverList();
	static double[] driverAvg = getDriverAvg();
	static double[] carAvg = getCarAvg();
	static int[] scores = getEmptyScores();
	static String simulation = "N";
	static int seasons = 1;

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Would you like to test with simulation? (Timeout between finishing): ");
		simulation = sc.nextLine().toUpperCase();

		while (!(simulation.equals("Y") || simulation.equals("N"))) {
			System.out.print("Incorrect input: ");
			simulation = sc.nextLine().toUpperCase();
		}

		int races = 1;
		System.out.print("How much races do you want to race? Between 1 and 21, higher will be set to 21, lower to 1: ");
		races = sc.nextInt();
		if (simulation.equals("N")) {
			System.out.print("How much seasons would you like to play? (1-10): ");
			seasons = sc.nextInt();
			System.out.print("\n");
		} else {
			System.out.println("With simulation, multiple seasons will take too long, doing 1 season...\n");
		}

		if (races <= 1) {
			races = 1;
			System.out.println("Playing 1 Race");
		} else if (races > 21) {
			races = 21;
			System.out.println("Playing 21 Races");
		} else {
			System.out.println("Playing " + races + " Races");
		}

		for (int j = 0; j < seasons; j++) {
			if (!(simulation.equals("Y") || seasons == 1)) {
				System.out.println("\nSeason " + (j+1) + " of " + seasons);
			} else {
			}
			for (int i = 1; i <= races; i++) {
				if (simulation.equals("Y")) {
					System.out.println("Result of race " + i + "\n");
				}

				if (i%5 == 0) {
					System.out.print("Racing on Baku City Circuit, Azerbaijan\n");
					testVersion(2.33);
				} else if (i%5 == 1) {
					System.out.print("Racing on Spa-Francorchamps, Belgium\n");
					testVersion(1.33);
				} else if (i%5 == 2) {
					System.out.print("Racing on Silverstone, United Kingdom\n");
					testVersion(4);
				} else if (i%5 == 3) {
					System.out.print("Racing on Monza, Italy\n");
					testVersion(2.78);
				} else {
					System.out.print("Racing on Monte Carlo, Monaco\n");
					testVersion(5.32);
				}

			}

			if (simulation.equals("N")) {
				System.out.println();
			}

			getSeasonResults();

		}

		if (simulation.equals("Y")) {
			System.out.print("\n");
		}

		sc.close();

	}

	private static void getSeasonResults() {

		for (int j = 0; j < 22; j++) {

			int biggest = 0;

			for (int k = 0; k < 22; k++) {
				if (scores[k] > scores[biggest]) {
					biggest = k;
				}
			}

			if (scores[biggest] != 0) {
				System.out.println(drivers.get(biggest) + " ended the season with " + scores[biggest] + " points.");
				scores[biggest] = 0;
			}

		}

		System.out.println("The rest ended with 0 points\n");

	}

	private static int[] getEmptyScores() {

		int[] scores = new int[22];

		for (int i = 0; i < 22; i++) {
			scores[i] = 0;
		}

		return scores;

	}

	private static double[] getCarAvg() {

		double[] carAvg = new double[22];

		for (int i = 0; i < 22; i++) {
			carAvg[i] = 50;
		}

		return carAvg;

	}

	private static double[] getDriverAvg() {

		//Creating an array with all driver stat averages
		double[] avarages = new double[22];

		//Adding all driver stat averages, this will be in an external file later
		avarages[0] = 96;
		avarages[1] = 95;
		avarages[2] = 94.7;
		avarages[3] = 94;
		avarages[4] = 92.3;
		avarages[5] = 90.7;
		avarages[6] = 85.7;
		avarages[7] = 84;
		avarages[8] = 82.3;
		avarages[9] = 79.7;
		avarages[10] = 79;
		avarages[11] = 78.7;
		avarages[12] = 77.7;
		avarages[13] = 77.3;
		avarages[14] = 77;
		avarages[15] = 76.7;
		avarages[16] = 75.3;
		avarages[17] = 75;
		avarages[18] = 74;
		avarages[19] = 72;
		avarages[20] = 71;
		avarages[21] = 70;

		return avarages;

	}

	private static List<String> getDriverList() {

		//Creating an ArrayList that holds the driver names
		List<String> drivers= new ArrayList<String>();

		//Adding the driver names manually (This will be in external files later on)
		drivers.add("M. Verstappen"); //
		drivers.add("N. Rosberg"); //
		drivers.add("L. Hamilton"); //
		drivers.add("S. Vettel"); //
		drivers.add("D. Ricciardo"); //
		drivers.add("K. Räikkönnen"); //
		drivers.add("S. Pérez"); //
		drivers.add("F. Alonso"); //
		drivers.add("V. Bottas"); //
		drivers.add("N. Hülkenberg"); //
		drivers.add("C. Sainz Jr."); //
		drivers.add("K. Magnussen"); //
		drivers.add("F. Massa"); //
		drivers.add("J. Button"); //
		drivers.add("F. Nasr"); //
		drivers.add("R. Grosjean"); //
		drivers.add("P. Wehrlein"); //
		drivers.add("M. Ericsson"); //
		drivers.add("D. Kvyat"); //
		drivers.add("J. Palmer"); //
		drivers.add("R. Haryanto"); //
		drivers.add("E. Guttiérrez"); //

		return drivers;
	}

	public static double calculateResult(double avgCar, double avgDriver, double trackDiff, double random) {

		//The higher the result, the faster the driver has finished
		double result = 0;

		/* The race results depend on the driver stat average and the car he/she is driving.
		 * We multiply the result by 2 over the track difficulty, later we will add more factors like weather etc.
		 * Lastly we multiply it by the random value generated by the random function to make it more realistic.
		 * Drivers can have a good or bad day and this affects the driver his race results
		 */
		result = (avgCar + avgDriver);
		result = result * (2/trackDiff);
		result = result * random;

		return result;

	}

	private static double random() {

		//Generating a random value between 1.1 and 0.9
		Random value = new Random();
		double random = 0.9 + (1.1 - 0.9) * value.nextDouble();

		return random;

	}

	public static void testVersion(double trackDiff) {
		double results[] = new double[22];


		for (int i = 0; i < 22; i++) {
			double random = random();
			double avgDriver = driverAvg[i];
			double avgCar = carAvg[i];
			results[i] = calculateResult(avgCar, avgDriver, trackDiff, random);
		}

		if (simulation.equals("Y")) {
			System.out.print("Racing");
			for (int l = 0; l < 5; l++) {
				System.out.print(".");
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		if (simulation.equals("Y")) {
			System.out.print("\n");
		}

		for (int k = 0; k < 22; k ++) {

			int biggest = 0;

			for (int j = 0; j < 22; j++) {
				if (results[j] > results[biggest]) {
					biggest = j;
				}
			}

			if (simulation.equals("Y")) {
				if (k == 0) {
					System.out.println("Finished 1st: " + drivers.get(biggest));
					results[biggest] = 0;
					scores[biggest] = scores[biggest] + 25;
				} else if (k == 1) {
					System.out.println("Finished 2nd: " + drivers.get(biggest));
					results[biggest] = 0;
					scores[biggest] = scores[biggest] + 18;
				} else if (k == 2) {
					System.out.println("Finished 3rd: " + drivers.get(biggest));
					results[biggest] = 0;
					scores[biggest] = scores[biggest] + 15;
				} else if (k == 20) {
					System.out.println("Finished 21st: " + drivers.get(biggest));
					results[biggest] = 0;
				} else if (k == 21) {
					System.out.println("Finished 22nd: " + drivers.get(biggest) + "\n");
					results[biggest] = 0;
				} else {
					System.out.println("Finished " + (k+1) + "th: " + drivers.get(biggest));
					results[biggest] = 0;
					switch (k) {
					case 3:
						scores[biggest] = scores[biggest] + 12;
						break;
					case 4:
						scores[biggest] = scores[biggest] + 10;
						break;
					case 5:
						scores[biggest] = scores[biggest] + 8;
						break;
					case 6:
						scores[biggest] = scores[biggest] + 6;
						break;
					case 7:
						scores[biggest] = scores[biggest] + 4;
						break;
					case 8:
						scores[biggest] = scores[biggest] + 2;
						break;
					case 9:
						scores[biggest] = scores[biggest] + 1;
						break;
					default:
						break;
					}
				}
			} else {
				if (k == 0) {
					results[biggest] = 0;
					scores[biggest] = scores[biggest] + 25;
				} else if (k == 1) {
					results[biggest] = 0;
					scores[biggest] = scores[biggest] + 18;
				} else if (k == 2) {
					results[biggest] = 0;
					scores[biggest] = scores[biggest] + 15;
				} else if (k == 20) {
					results[biggest] = 0;
				} else if (k == 21) {
					results[biggest] = 0;
				} else {
					results[biggest] = 0;
					switch (k) {
					case 3:
						scores[biggest] = scores[biggest] + 12;
						break;
					case 4:
						scores[biggest] = scores[biggest] + 10;
						break;
					case 5:
						scores[biggest] = scores[biggest] + 8;
						break;
					case 6:
						scores[biggest] = scores[biggest] + 6;
						break;
					case 7:
						scores[biggest] = scores[biggest] + 4;
						break;
					case 8:
						scores[biggest] = scores[biggest] + 2;
						break;
					case 9:
						scores[biggest] = scores[biggest] + 1;
						break;
					default:
						break;
					}
				}
			}

			if (simulation.equals("Y")) {
				for (int l = 0; l < 4; l++) {
					try {
						TimeUnit.MILLISECONDS.sleep(40);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}

	}

}