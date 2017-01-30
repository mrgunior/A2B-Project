package main.java.manager.model;

import java.text.DecimalFormat;

public class Stopwatch
{
	// Start time
	private double start;
	private double end;
	
	private boolean running = false;

	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	public double getEnd() {
		return end;
	}

	public void setEnd(double end) {
		this.end = end;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Stopwatch()
	{
		start = System.currentTimeMillis();
		end = System.currentTimeMillis();
		stop();
	}
	
	/**
	 * Start stopwatch
	 */
	public void start()
	{
		start = System.currentTimeMillis();
		running = true;
	}
	
	/**
	 * Stop stopwatch
	 */
	public void stop()
	{
		end = System.currentTimeMillis();
		running = false;
	}

	/**
	 * Return the amount of time that has passed since the creation of the
	 * stopwatch object
	 * 
	 * @return double - Elapsed time since creation
	 */
	public double elapsedTime()
	{
//		System.out.println("### Running: " + running);
//		System.out.println("Start: " + start);
//		System.out.println("Current: " + System.currentTimeMillis());
//		System.out.println("End: " + end);
//		System.out.println("Elapsed: " + (System.currentTimeMillis()-start));
		
		if (running)
		{
			double current = System.currentTimeMillis();
			return (current - start);
		}
		else
		{
			return ((end - start)*1);
		}
		
	}

	/**
	 * Return the amount of time that has passed since the creation of the
	 * stopwatch object in a string format
	 * 
	 * @return double - Elapsed time since creation
	 */
	public String elapsedTimeString(double elapsedTime)
	{
		String timeString = "";
		
		if (running)
		{
			double elapsed = elapsedTime;

			double millisecondsDouble = (int) (elapsed % 1000);
			double secondsDouble = (int) (elapsed / 1000) % 60;
			double minutesDouble = (int) (elapsed / (1000 * 60)) % 60;
			double hoursDouble = (int) (elapsed / (1000 * 60 * 60)) % 60;

			DecimalFormat dfMilli = new DecimalFormat("000.#");
			DecimalFormat dfSeconds = new DecimalFormat("00.#");
			DecimalFormat dfMinutes = new DecimalFormat("00.#");
			DecimalFormat dfHours = new DecimalFormat("00.#");

			String milliseconds = dfMilli.format(millisecondsDouble);
			String seconds = dfSeconds.format(secondsDouble);
			String minutes = dfMinutes.format(minutesDouble);
			String hours = dfHours.format(hoursDouble);

			timeString = hours + ":" + minutes + ":" + seconds + "." + milliseconds;
		}
		else
		{
			DecimalFormat dfMilli = new DecimalFormat("000.#");
			DecimalFormat dfSeconds = new DecimalFormat("00.#");
			DecimalFormat dfMinutes = new DecimalFormat("00.#");
			DecimalFormat dfHours = new DecimalFormat("00.#");

			String milliseconds = dfMilli.format(0);
			String seconds = dfSeconds.format(0);
			String minutes = dfMinutes.format(0);
			String hours = dfHours.format(0);			

			timeString = hours + ":" + minutes + ":" + seconds + "." + milliseconds;
		}
		
		
		return timeString;
	}
	
	public static String formatMilli(double milli)
	{
		double millisecondsDouble = (int) (milli % 1000);
		double secondsDouble = (int) (milli / 1000) % 60;
		double minutesDouble = (int) (milli / (1000 * 60)) % 60;
		double hoursDouble = (int) (milli / (1000 * 60 * 60)) % 60;

		DecimalFormat dfMilli = new DecimalFormat("000.#");
		DecimalFormat dfSeconds = new DecimalFormat("00.#");
		DecimalFormat dfMinutes = new DecimalFormat("00.#");
		DecimalFormat dfHours = new DecimalFormat("00.#");

		String milliseconds = dfMilli.format(millisecondsDouble);
		String seconds = dfSeconds.format(secondsDouble);
		String minutes = dfMinutes.format(minutesDouble);
		String hours = dfHours.format(hoursDouble);

		return (hours + ":" + minutes + ":" + seconds + "." + milliseconds);
	}
}
