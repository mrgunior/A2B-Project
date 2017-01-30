package main.java.manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import main.java.manager.model.Standings;

public class StandingsTest {

	Standings standings;
	ArrayList<Integer> standing;

	@Before
	public void initialize() {
		standings = new Standings();
		standing = new ArrayList<Integer>();
		for (int i = 0; i < 12; i++){
			standing.add(i, i);
		}
		
		

	}

	@Test
	public void testStandings() {
		assertTrue("Standings is of type Stadings", standings instanceof Standings);
	}

	@Test
	public void testGetStandings() {
	
		assertEquals(1 ,1);
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
