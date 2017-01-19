package manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import manager.model.Standings;

public class StandingsTest {

	Standings standings;

	@Before
	public void initialize() {
		standings = new Standings();
		

	}

	@Test
	public void testStandings() {
		assertTrue("Standings is of type Stadings", standings instanceof Standings);
	}

	@Test
	public void testGetStandings() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxScore() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
