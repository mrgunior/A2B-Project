package manager.model;

import java.text.DecimalFormat;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.org.glassfish.external.statistics.TimeStatistic;

public class Stopwatch
{
	// Start time
	private double start;

	public Stopwatch()
	{
		start = System.currentTimeMillis();
	}

	/**
	 * Return the amount of time that has passed since the creation of the
	 * stopwatch object
	 * 
	 * @return double - Elapsed time since creation
	 */
	public double elapsedTime()
	{
		double current = System.currentTimeMillis();
		return (current - start);
	}

	/**
	 * Return the amount of time that has passed since the creation of the
	 * stopwatch object in a string format
	 * 
	 * @return double - Elapsed time since creation
	 */
	public String elapsedTimeString()
	{
		double elapsed = System.currentTimeMillis() - start;

		double millisecondsDouble = (int) (elapsed % 1000);
		double secondsDouble = (int) (elapsed / 1000) % 60;
		double minutesDouble = (int) (elapsed / (1000 * 60)) % 60;

		DecimalFormat dfMilli = new DecimalFormat("000.#");
		DecimalFormat dfSeconds = new DecimalFormat("00.#");
		DecimalFormat dfMinutes = new DecimalFormat("00.#");

		String milliseconds = dfMilli.format(millisecondsDouble);
		String seconds = dfSeconds.format(secondsDouble);
		String minutes = dfMinutes.format(minutesDouble);

		String timeString = minutes + ":" + seconds + "." + milliseconds;
		
		return timeString;
	}
}
