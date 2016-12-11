package Templates;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RaceSimulationTemplates {

	/* Using drivers:
	 * Max Verstappen: 	Speed 96, Acceleration 96, Turning 96, Average 96
	 * Fernando Alonso: Speed 85, Acceleration 85, Turning 82, Average 84
	 * Felipe Nasr: 	Speed 76, Acceleration 76, Turning 79, Average 77
	 * 
	 * Using cars:
	 * Maxed car 	(everything lvl 5):	Speed 89, Acceleration 93, Handling 90, Braking 93, Weight 724kg, Average 91
	 * Average car 	(everything lvl 3): Speed 58, Acceleration 63, Handling 62, Braking 72, Weight 740kg, Average 64
	 * Stock car:	(everything lvl 0): Speed 50, Acceleration 50, Handling 50, Braking 50, Weight 750kg, Average 50
	 * 
	 * Using tracks:
	 * Silverstone, UK: 18 Turns, 5891km length, 11,3m height diff, 1,0km longest straight, difficulty: 2.6
	 * Monte Carlo, MO: 19 Turns, 3337km length, 42,0m height diff, 0,7km longest straight, difficulty: 4.7
	 */
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Want to test with our without randomzation? (Y/N): ");
		char choice = sc.next().charAt(0);
		
		while (!(choice == 'Y' || choice == 'N')) {
			System.out.println("Incorrect input: ");
		}
		
		
		System.out.println("Which version do you want to test? (1/2/3): ");
		int choice2 = sc.nextInt();
		
		switch (choice2) {
		case 1:
			if (choice == 'Y') {
				/* Version '1 Has the most difference in results between drivers
				 * Results lie between 8 and 60 when using randomizer
				 * Depending on driver, car and track difficulty
				 * Since we are adding a randomizer between 0.8 and 1.2 the results will be slightly modified by the randomization
				 */
				double random = random();
				System.out.println("Using random value " + random());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				testVersion1(random);
			} else {
				/* Version 1 has the least difference in results between drivers
				 * Results lie between 10 and 50
				 * Depending on driver, car and track difficulty
				 * Since we are adding a randomizer between 0.8 and 1.2 the results will be strongly modified by the randomization
				 */
				testVersion1(0);
			}
			break;
		case 2:
			if (choice == 'Y') {
				/* Version 1 Has the most difference in results between drivers
				 * Results lie between 40 and 230 when using randomizer
				 * Depending on driver, car and track difficulty
				 * Since we are adding a randomizer between 0.8 and 1.2 the results will be slightly modified by the randomization
				 */
				double random = random();
				System.out.println("Using random value " + random());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				testVersion2(random);
			} else {
				/* Version 2 Has more difference in results between drivers than version 1, but less than version 3
				 * Results lie between 50 and 190
				 * Depending on driver, car and track difficulty
				 * Since we are adding a randomizer between 0.8 and 1.2 the results will be moderately modified by the randomization
				 */
				testVersion2(0);
			}
			break;
		case 3:
			if (choice == 'Y') {
				/* Version 3 Has the most difference in results between drivers
				 * Results lie between 160 and 900 when using randomizer
				 * Depending on driver, car and track difficulty
				 * Since we are adding a randomizer between 0.8 and 1.2 the results will be slightly modified by the randomization
				 */
				double random = random();
				System.out.println("Using random value " + random());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				testVersion3(random);
			} else {
				/* Version 3 Has the most difference in results between drivers
				 * Results lie between 200 and 750
				 * Depending on driver, car and track difficulty
				 * Since we are adding a randomizer between 0.8 and 1.2 the results will be slightly modified by the randomization
				 */
				testVersion3(0);
			}
			break;
		default:
			System.out.println("Incorrect input, aborting.");
		}
		
	}
	
	public static double version1(int avgCar, int avgDriver, double trackDiff, double random) {
		
		//The higher the result, the faster the driver has finished
		double result = 0;
		
		result = (avgCar + avgDriver)/2;
		result = result * (1/trackDiff);
		result = result * random;
		
		return result;
		
	}
	
	public static double version2(int avgCar, int avgDriver, double trackDiff, double random) {
		
		//The higher the result, the faster the driver has finished
		double result = 0;
		
		result = (avgCar + avgDriver);
		result = result * (2/trackDiff);
		result = result * random;
		
		return result;
		
	}
	
	public static double version3(int avgCar, int avgDriver, double trackDiff, double random) {
		
		//The higher the result, the faster the driver has finished
		double result = 0;
		
		result = (avgCar + avgDriver)*2;
		result = result * (4/trackDiff);
		result = result * random;
		
		return result;
		
	}
	
	private static double random() {

		Random value = new Random();
		double random = 0.8 + (1.2 - 0.8) * value.nextDouble();
		
		return random;
		
	}
	
	public static void testVersion1(double randomInput) {
		
		double random = randomInput;
		
		if (random < 0.8 || random > 1.2) {
			random = 1;
		}
		
		System.out.println("Simulation version 1...\n");
		System.out.println("M. Verstappen, Maxed Car, Silverstone: " + version1(91, 96, 2.6, random));
		System.out.println("M. Verstappen, Average Car, Silverstone: " + version1(64, 96, 2.6, random));
		System.out.println("M. Verstappen, Stock Car, Silverstone: " + version1(50, 96, 2.6, random) + "\n");
		System.out.println("M. Verstappen, Maxed Car, Monte Carlo: " + version1(91, 96, 4.7, random));
		System.out.println("M. Verstappen, Average Car, Monte Carlo: " + version1(64, 96, 4.7, random));
		System.out.println("M. Verstappen, Stock Car, Monte Carlo: " + version1(50, 96, 4.7, random) + "\n");
		System.out.println("F. Alonso, Maxed Car, Silverstone: " + version1(91, 84, 2.6, random));
		System.out.println("F. Alonso, Average Car, Silverstone: " + version1(64, 84, 2.6, random));
		System.out.println("F. Alonso, Stock Car, Silverstone: " + version3(50, 84, 2.6, random) + "\n");
		System.out.println("F. Alonso, Maxed Car, Monte Carlo: " + version1(91, 84, 4.7, random));
		System.out.println("F. Alonso, Average Car, Monte Carlo: " + version1(64, 84, 4.7, random));
		System.out.println("F. Alonso, Stock Car, Monte Carlo: " + version1(50, 84, 4.7, random) + "\n");
		System.out.println("F. Nasr, Maxed Car, Silverstone: " + version1(91, 77, 2.6, random));
		System.out.println("F. Nasr, Average Car, Silverstone: " + version1(64, 77, 2.6, random));
		System.out.println("F. Nasr, Stock Car, Silverstone: " + version1(50, 77, 2.6, random) + "\n");
		System.out.println("F. Nasr, Maxed Car, Monte Carlo: " + version1(91, 77, 4.7, random));
		System.out.println("F. Nasr, Average Car, Monte Carlo: " + version1(64, 77, 4.7, random));
		System.out.println("F. Nasr, Stock Car, Monte Carlo: " + version1(50, 77, 4.7, random) + "\n\n\n");
		
	}
	
	public static void testVersion2(double randomInput) {
		
		double random = randomInput;
		
		if (random < 0.8 || random > 1.2) {
			random = 1;
		}
		
		System.out.println("Simulation version 2...\n");
		System.out.println("M. Verstappen, Maxed Car, Silverstone: " + version2(91, 96, 2.6, random));
		System.out.println("M. Verstappen, Average Car, Silverstone: " + version2(64, 96, 2.6, random));
		System.out.println("M. Verstappen, Stock Car, Silverstone: " + version2(50, 96, 2.6, random) + "\n");
		System.out.println("M. Verstappen, Maxed Car, Monte Carlo: " + version2(91, 96, 4.7, random));
		System.out.println("M. Verstappen, Average Car, Monte Carlo: " + version2(64, 96, 4.7, random));
		System.out.println("M. Verstappen, Stock Car, Monte Carlo: " + version2(50, 96, 4.7, random) + "\n");
		System.out.println("F. Alonso, Maxed Car, Silverstone: " + version2(91, 84, 2.6, random));
		System.out.println("F. Alonso, Average Car, Silverstone: " + version2(64, 84, 2.6, random));
		System.out.println("F. Alonso, Stock Car, Silverstone: " + version2(50, 84, 2.6, random) + "\n");
		System.out.println("F. Alonso, Maxed Car, Monte Carlo: " + version2(91, 84, 4.7, random));
		System.out.println("F. Alonso, Average Car, Monte Carlo: " + version2(64, 84, 4.7, random));
		System.out.println("F. Alonso, Stock Car, Monte Carlo: " + version2(50, 84, 4.7, random) + "\n");
		System.out.println("F. Nasr, Maxed Car, Silverstone: " + version2(91, 77, 2.6, random));
		System.out.println("F. Nasr, Average Car, Silverstone: " + version2(64, 77, 2.6, random));
		System.out.println("F. Nasr, Stock Car, Silverstone: " + version2(50, 77, 2.6, random) + "\n");
		System.out.println("F. Nasr, Maxed Car, Monte Carlo: " + version2(91, 77, 4.7, random));
		System.out.println("F. Nasr, Average Car, Monte Carlo: " + version2(64, 77, 4.7, random));
		System.out.println("F. Nasr, Stock Car, Monte Carlo: " + version2(50, 77, 4.7, random) + "\n\n\n");
		
	}
	
	public static void testVersion3(double randomInput) {
		
		double random = randomInput;
		
		if (random < 0.8 || random > 1.2) {
			random = 1;
		}
		
		System.out.println("Simulation version 3...\n");
		System.out.println("M. Verstappen, Maxed Car, Silverstone: " + version3(91, 96, 2.6, random));
		System.out.println("M. Verstappen, Average Car, Silverstone: " + version3(64, 96, 2.6, random));
		System.out.println("M. Verstappen, Stock Car, Silverstone: " + version3(50, 96, 2.6, random) + "\n");
		System.out.println("M. Verstappen, Maxed Car, Monte Carlo: " + version3(91, 96, 4.7, random));
		System.out.println("M. Verstappen, Average Car, Monte Carlo: " + version3(64, 96, 4.7, random));
		System.out.println("M. Verstappen, Stock Car, Monte Carlo: " + version3(50, 96, 4.7, random) + "\n");
		System.out.println("F. Alonso, Maxed Car, Silverstone: " + version3(91, 84, 2.6, random));
		System.out.println("F. Alonso, Average Car, Silverstone: " + version3(64, 84, 2.6, random));
		System.out.println("F. Alonso, Stock Car, Silverstone: " + version3(50, 84, 2.6, random) + "\n");
		System.out.println("F. Alonso, Maxed Car, Monte Carlo: " + version3(91, 84, 4.7, random));
		System.out.println("F. Alonso, Average Car, Monte Carlo: " + version3(64, 84, 4.7, random));
		System.out.println("F. Alonso, Stock Car, Monte Carlo: " + version3(50, 84, 4.7, random) + "\n");
		System.out.println("F. Nasr, Maxed Car, Silverstone: " + version3(91, 77, 2.6, random));
		System.out.println("F. Nasr, Average Car, Silverstone: " + version3(64, 77, 2.6, random));
		System.out.println("F. Nasr, Stock Car, Silverstone: " + version3(50, 77, 2.6, random) + "\n");
		System.out.println("F. Nasr, Maxed Car, Monte Carlo: " + version3(91, 77, 4.7, random));
		System.out.println("F. Nasr, Average Car, Monte Carlo: " + version3(64, 77, 4.7, random));
		System.out.println("F. Nasr, Stock Car, Monte Carlo: " + version3(50, 77, 4.7, random) + "\n\n\n");
		
	}
	
}