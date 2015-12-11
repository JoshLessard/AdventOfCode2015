package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import static com.joshlessard.adventofcode2015.LightGrid.Command;

import org.junit.Test;

public class OnOffLightGridTest {
	
	private static final int ROWS = 50;
	private static final int COLUMNS = 50;
	
	private Random random = new Random();
	
	private OnOffLightGrid grid = new OnOffLightGrid( ROWS, COLUMNS );
	
	@Test
	public void gridBeginsWithAllLightsOff() {
		assertEquals( 0, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void turningOnUnlitLightTurnsOn1Light() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.turnOn( x, y );
		assertEquals( 1, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void turningOnLitLightDoesNothing() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.turnOn( x, y );
		grid.turnOn( x, y );
		assertEquals( 1, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void turningOffLitLightTurnsOff1Light() {
		turnOnAllLights();
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.turnOff( x, y );
		assertEquals( ROWS * COLUMNS - 1, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void turningOffUnlitLightDoesNothing() {
		turnOnAllLights();
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();

		grid.turnOff( x, y );
		grid.turnOff( x, y );
		assertEquals( ROWS * COLUMNS - 1, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void togglingUnlitLightTurnsOn1Light() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.toggle( x, y );
		assertEquals( 1, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void togglingLitLightTurnsOff1Light() {
		turnOnAllLights();
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.toggle( x, y );
		assertEquals( ROWS * COLUMNS - 1, grid.getNumberOfLitLights() );
	}

	private int getRandomCoordinate() {
		return random.nextInt( 10 );
	}

	private void turnOnAllLights() {
		grid.changeLights( Command.TURN_ON, new Point( 0, 0 ), new Point( ROWS - 1, COLUMNS - 1 ) );
	}
}
