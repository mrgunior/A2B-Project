package Templates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import manager.model.DriverResult;
import manager.model.Results;

public class RaceSimulationTemplates
{

	/*
	 * Using drivers: Max Verstappen: Average 96 Nico Rosberg: Average 95 Lewis
	 * Hamilton: Average 94.7 Sebastian Vettel: Average 94 Daniel Ricciardo:
	 * Average 92.3 Kimi Raikkonnen: Average 90.7 Sergio Pérez: Average 85.7
	 * Fernando Alonso: Average 84 Valtteri Bottas: Average 82.3 Nicolas
	 * Hulkenberg: Average 79.7 Carloz Sainz Junior: Average 79 Kevin Magnussen:
	 * Average 78.7 Felipe Massa: Average 77.7 Jensen Button: Average 77.3
	 * Felipe Nasr: Average 77 Romain Grosjean Average 76.7 Pascal Wehrlein
	 * Average 75.3 Marcus Ericsson Average 75 Daniil Kvyat Average 74 Jolyon
	 * Palmer Average 72 Rio Haryanto Average 71 Esteban Gutierrez Average 70
	 * 
	 * Using Cars: Stock car: Average 50.0 Average car: Average 70.6 Max car:
	 * Average 91.3
	 * 
	 * Using tracks: Baku City Circuit, AZ: Difficulty: 2.33 Spa-Francorchamps,
	 * BE: Difficulty: 1.33 Silverstone, UK: Difficulty: 4.00 Monza, IT:
	 * Difficulty: 2.78 Monte Carlo, MO: Difficulty: 5.32
	 */

	// Filling the lists with driver names and their averages
	static List<String>	drivers		= getDriverList();
	static double[]		driverAvg	= getDriverAvg();
	static double[]		carAvg		= getDefaultCarAvg();
	static int[]		scores		= getEmptyScores();
	// static String simulation = "N";
	static int seasons = 1;

	public static void main(String args[])
	{

		// for (int j = 0; j < seasons; j++) {
		// if (!(simulation.equals("Y") || seasons == 1)) {
		// System.out.println("\nSeason " + (j+1) + " of " + seasons);
		// } else {
		// }
		// for (int i = 1; i <= races; i++) {
		// if (simulation.equals("Y")) {
		// System.out.println("Result of race " + i + "\n");
		// }
		//
		// if (i%5 == 0) {
		// System.out.print("Racing on Baku City Circuit, Azerbaijan\n");
		// testVersion(2.33);
		// } else if (i%5 == 1) {
		// System.out.print("Racing on Spa-Francorchamps, Belgium\n");
		// testVersion(1.33);
		// } else if (i%5 == 2) {
		// System.out.print("Racing on Silverstone, United Kingdom\n");
		// testVersion(4);
		// } else if (i%5 == 3) {
		// System.out.print("Racing on Monza, Italy\n");
		// testVersion(2.78);
		// } else {
		// System.out.print("Racing on Monte Carlo, Monaco\n");
		// testVersion(5.32);
		// }
		//
		// }
		//
		//

		// getSeasonResults();

		Results results = runSimulation(5.32);
		results.sortResultsByTime();
		System.out.println("Result: " + results.toString());

		// }
	}

	private static double[] getDefaultCarAvg()
	{
		// TODO Read averages from JSON
		double[] carAvg = new double[22];

		for (int i = 0; i < 22; i++)
		{
			carAvg[i] = 50;
		}

		return carAvg;

	}

	private static double[] getDriverAvg()
	{

		// Creating an array with all driver stat averages
		double[] avarages = new double[22];

		// TODO Read driver average from JSON
		// Adding all driver stat averages, this will be in an external file
		// later
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

	private static List<String> getDriverList()
	{

		// Creating an ArrayList that holds the driver names
		List<String> drivers = new ArrayList<String>();

		// TODO Read drivers from JSON
		// Adding the driver names manually (This will be in external files
		// later on)
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

	public static double calculateResult(double avgCar, double avgDriver, double trackDiff, double random)
	{

		// The higher the result, the faster the driver has finished
		double result = 0;

		/*
		 * The race results depend on the driver stat average and the car he/she
		 * is driving. We multiply the result by 2 over the track difficulty,
		 * later we will add more factors like weather etc. Lastly we multiply
		 * it by the random value generated by the random function to make it
		 * more realistic. Drivers can have a good or bad day and this affects
		 * the driver his race results
		 */
		result = (avgCar + avgDriver);
		result = result * (2 / trackDiff);
		result = result * random;

		return result;

	}

	private static double random()
	{
		// Generating a random value between 1.1 and 0.9
		Random value = new Random();
		double random = 0.9 + (1.1 - 0.9) * value.nextDouble();

		return random;
	}

	public static Results runSimulation(double trackDiff)
	{
		Results simulationResults = new Results();
		double results[] = new double[22];

		for (int i = 0; i < 22; i++)
		{
			double random = random();
			double avgDriver = driverAvg[i];
			double avgCar = carAvg[i];
			results[i] = calculateResult(avgCar, avgDriver, trackDiff, random);

			// Normalize time for simulation
			double time = 200 / (results[i] - 30);

			// Create result for the driver and add to the results
			DriverResult resultForLoop = new DriverResult(i + 1, drivers.get(i), time * 1000);
			simulationResults.addResult(resultForLoop);
		}

		return simulationResults;
	}

	private static int[] getEmptyScores()
	{

		int[] scores = new int[22];

		for (int i = 0; i < 22; i++)
		{
			scores[i] = 0;
		}

		return scores;
	}
}