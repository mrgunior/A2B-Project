package manager.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import manager.controller.GameController;
import manager.model.Profile;

public class GameControllerTest 
{
	GameController gamecontroller;
	Profile testProfile;
	String teamname ="TestTeam", jsonFile = "src/manager/test/dataTest.dat";
	double highScore = 50.0, budget = 200.0;
	
	@Before
	public void setUp() throws IOException
	{	
		gamecontroller = new GameController(jsonFile);
		testProfile = new Profile(highScore, budget, teamname);
	}
	
	@After
	public void tearDown() throws IOException
	{
		//need to do this otherwise after time you run a test it use recourse and not close it.
		gamecontroller.stopAutoSave();
	}
	
	//need fixing.
	@Test(timeout=2*60*1000)
	public void testAutoSaveItItSavesEvery2Minutes()
	{
		//gamecontroller.autoSave();
	}
	
	//need fixing.
	@Test
	public void testStopAutoSave() throws IOException
	{
		//gamecontroller.stopAutoSave();
	}
	
	@Test
	public void testReadJsonObjectAndInitializeDifferentHighScore()
	{
		//highScore is 50 in the jsonFile
		assertFalse("After readJsonObjectAndInitialize has been called profile should have been created", gamecontroller.getProfile().equals(testProfile));
	}
	
	@Test
	public void testReadJsonObjectAndInitializeSameHighScore()
	{
		//highScore is 50 in the jsonFile
		testProfile.setHighScore(50.0);
		assertTrue("After readJsonObjectAndInitialize has been called profile should have been created", gamecontroller.getProfile().equals(testProfile));
	}
	
	
}
