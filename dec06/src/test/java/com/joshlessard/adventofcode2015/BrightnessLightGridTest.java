package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import static com.joshlessard.adventofcode2015.LightGrid.Command;

import org.junit.Test;

public class BrightnessLightGridTest {
	
	private static final int ROWS = 50;
	private static final int COLUMNS = 50;
	
	private Random random = new Random();
	
	private BrightnessLightGrid grid = new BrightnessLightGrid( ROWS, COLUMNS );
	
	@Test
	public void gridBeginsWithTotalBrightnessOf0() {
		assertEquals( 0, grid.getBrightness() );
	}
	
	@Test
	public void turningOn2x2GridOfLightsIncreasesBrightnessBy4() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.changeLights( Command.TURN_ON, new Point( x, y ), new Point( x + 1, y + 1 ) );
		assertEquals( 4, grid.getBrightness() );
	}
	
	@Test
	public void turningOff5x5GridOfLightsDecreasesBrightnessBy4() {
		turnOnAllLights();
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.changeLights( Command.TURN_OFF, new Point( x, y ), new Point( x + 4, y + 4 ) );
		assertEquals( ROWS * COLUMNS - 25, grid.getBrightness() );
	}
	
	@Test
	public void turningOffUnlitLightsDoesNotDecreaseBrightness() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.changeLights( Command.TURN_ON, new Point( x, y ), new Point( x + 4, y + 4 ) );
		assertEquals( 25, grid.getBrightness() );
		
		grid.changeLights( Command.TURN_OFF, new Point( x + 3, y + 3 ), new Point( x + 5, y + 5 ) );
		assertEquals( 25 - 4, grid.getBrightness() );
	}
	
	@Test
	public void toggling3x3GridOfLightsIncreasesBrightnessBy18() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.changeLights( Command.TOGGLE, new Point( x, y ), new Point( x + 2, y + 2 ) );
		assertEquals( 18, grid.getBrightness() );
	}

	private int getRandomCoordinate() {
		return random.nextInt( 10 );
	}

	private void turnOnAllLights() {
		grid.changeLights( Command.TURN_ON, new Point( 0, 0 ), new Point( ROWS - 1, COLUMNS - 1 ) );
	}
}
