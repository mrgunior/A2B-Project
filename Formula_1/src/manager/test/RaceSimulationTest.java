package manager.test;

import org.junit.Assert.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import manager.model.RaceSimulation;

public class RaceSimulationTest {

	private RaceSimulation raceSim;
	
	@Before
	public void initialize() {
		raceSim = new RaceSimulation();
	}
	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculateResult() {
		assertEquals(RaceSimulation.calculateResult(10, 10, 10, 5), 20, 0.000000001);
	}

	@Test
	public void testRunSimulation() {
		fail("Not yet implemented");
	}

}
