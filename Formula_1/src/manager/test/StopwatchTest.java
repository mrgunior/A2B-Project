package manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import manager.model.Stopwatch;

public class StopwatchTest {

	static Stopwatch stopwatch;
	static double start;
	
	@Before
	public void setUp() throws Exception 
	{
		start = System.currentTimeMillis();
		stopwatch = new Stopwatch();
		stopwatch.setStart(start);
	}

	@Test
	public void testGetStart() {
		assertEquals(start, stopwatch.getStart(), 1);
	}

	@Test
	public void testSetStart() {
		double startValue = 1000000;
		stopwatch.setStart(startValue);
		assertEquals(startValue, stopwatch.getStart(), 1);
	}

	@Test
	public void testSetGetEnd() {
		double endValue = 19039;
		stopwatch.setEnd(endValue);
		assertEquals(endValue, stopwatch.getEnd(), 1);
	}


	@Test
	public void testIsRunningTrue() {
		stopwatch.start();
		assertTrue(stopwatch.isRunning());
	}
	
	@Test
	public void testIsRunningFalse() {
		stopwatch.stop();
		assertFalse(stopwatch.isRunning());
	}
	
	@Test
	public void testSetRunningTrue() {
		stopwatch.setRunning(true);
		assertTrue(stopwatch.isRunning());
	}
	
	@Test
	public void testSetRunningFalse() {
		stopwatch.setRunning(false);
		assertFalse(stopwatch.isRunning());
	}

	@Test
	public void testStart() {
		stopwatch.start();
		assertTrue(stopwatch.isRunning());
	}

	@Test
	public void testStop() {
		stopwatch.stop();
		assertFalse(stopwatch.isRunning());
	}

	@Test
	public void testElapsedTimeRunning() throws InterruptedException {
		stopwatch.stop();
		stopwatch.start();
		double time = 23;
		Thread.sleep((long) time);
		stopwatch.stop();
		assertEquals(time, stopwatch.elapsedTime(), 2);
	}
	
	@Test
	public void testElapsedTimeNotRunning() throws InterruptedException {
		stopwatch.start();
		double time = 100;
		Thread.sleep((long) time);
		stopwatch.setRunning(true);
		assertEquals(time, stopwatch.elapsedTime(), 2);
	}
	
	@Test
	public void testElapsedTimeStringNoTime() {
		stopwatch.stop();
		stopwatch.setRunning(true);
		double elapsed = 0;
		assertEquals("00:00:00.000", stopwatch.elapsedTimeString(elapsed));
	}
	
	@Test
	public void testElapsedTimeStringNormalTime() {
		stopwatch.stop();
		stopwatch.setRunning(true);
		double elapsed = 1000;
		assertEquals("00:00:01.000", stopwatch.elapsedTimeString(elapsed));
	}
	
	@Test
	public void testElapsedTimeStringTooMuchTime() {
		stopwatch.stop();
		stopwatch.setRunning(true);
		double elapsed = 216000001;
		assertEquals("00:00:00.001", stopwatch.elapsedTimeString(elapsed));
	}
	
	@Test
	public void testElapsedTimeStringNotRunning() {
		stopwatch.stop();
		stopwatch.setRunning(false);
		double elapsed = 123456789;
		assertEquals("00:00:00.000", stopwatch.elapsedTimeString(elapsed));
	}
	
	@Test
	public void testFormatMilli() {		
		double elapsed = 216000001;
		assertEquals("00:00:00.001", Stopwatch.formatMilli(elapsed));
	}

}
