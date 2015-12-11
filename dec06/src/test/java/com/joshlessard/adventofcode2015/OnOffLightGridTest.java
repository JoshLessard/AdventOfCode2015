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
	public void turningOn1x1GridTurnsOn1Light() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.changeLights( Command.TURN_ON, new Point( x, y ), new Point( x, y ) );
		assertEquals( 1, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void turningOn2x2GridTurnsOn4Lights() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.changeLights( Command.TURN_ON, new Point( x, y ), new Point( x + 1, y + 1 ) );
		assertEquals( 4, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void turningOnLightsThatAreAlreadyOnDoesNotDoubleCount() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.changeLights( Command.TURN_ON, new Point( x, y ), new Point( x + 5, y + 5 ) );
		assertEquals( 36, grid.getNumberOfLitLights() );
		
		grid.changeLights( Command.TURN_ON, new Point( x + 3, y + 3 ), new Point( x + 6, y + 5 ) );
		assertEquals( 39, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void turningOff1x1GridTurnsOff1Light() {
		turnOnAllLights();
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.changeLights( Command.TURN_OFF, new Point( x, y ), new Point( x, y ) );
		assertEquals( ROWS * COLUMNS - 1, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void turningOff2x2GridTurnsOff4Lights() {
		turnOnAllLights();
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.changeLights( Command.TURN_OFF, new Point( x, y ), new Point( x + 1, y + 1 ) );
		assertEquals( ROWS * COLUMNS - 4, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void turningOffLightsThatAreAlreadyOffDoesNotDoubleCount() {
		turnOnAllLights();
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.changeLights( Command.TURN_OFF, new Point( x, y ), new Point( x + 5, y + 5 ) );
		assertEquals( ROWS * COLUMNS - 36, grid.getNumberOfLitLights() );
		
		grid.changeLights( Command.TURN_OFF, new Point( x + 3, y + 3 ), new Point( x + 6, y + 5 ) );
		assertEquals( ROWS * COLUMNS - 39, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void toggling3x3GridOfLightsThatAreOffTurnsOn9Lights() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.changeLights( Command.TOGGLE, new Point( x, y ), new Point( x + 2, y + 2 ) );
		assertEquals( 9, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void toggling4x4GridOfLightsThatAreOnTurnsOff16Lights() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.changeLights( Command.TURN_ON, new Point( x, y ), new Point( x + 10, y + 10 ) );
		assertEquals( 121, grid.getNumberOfLitLights() );
		
		grid.changeLights( Command.TOGGLE, new Point( x, y ), new Point( x + 3, y + 3 ) );
		assertEquals( 121 - 16, grid.getNumberOfLitLights() );
	}
	
	@Test
	public void togglingLightsTurnsLitLightsOffAndUnlitLightsOn() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.changeLights( Command.TURN_ON, new Point( x, y ), new Point( x + 4, y + 4 ) );
		assertEquals( 25, grid.getNumberOfLitLights() );
		
		grid.changeLights( Command.TOGGLE, new Point( x, y ), new Point( x + 6, y + 6 ) );
		assertEquals( 25 - 25 + 24, grid.getNumberOfLitLights() );
	}

	private int getRandomCoordinate() {
		return random.nextInt( 10 );
	}

	private void turnOnAllLights() {
		grid.changeLights( Command.TURN_ON, new Point( 0, 0 ), new Point( ROWS - 1, COLUMNS - 1 ) );
	}
}
