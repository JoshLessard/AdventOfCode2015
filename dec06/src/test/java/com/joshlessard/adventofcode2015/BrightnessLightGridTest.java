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
	public void turningOnLightIncreasesBrightnessBy1() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.turnOn( x, y );
		assertEquals( 1, grid.getBrightness() );
		
		grid.turnOn( x, y );
		assertEquals( 2, grid.getBrightness() );
	}
	
	@Test
	public void turningOffLightDecreasesBrightnessBy1() {
		turnOnAllLights();
		turnOnAllLights();
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.turnOff( x, y );
		assertEquals( 2 * ROWS * COLUMNS - 1, grid.getBrightness() );
		
		grid.turnOff( x, y );
		assertEquals( 2 * ROWS * COLUMNS - 2, grid.getBrightness() );
	}
	
	@Test
	public void turningOffUnlitLightDoesNothing() {
		turnOnAllLights();
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.turnOff( x, y );
		assertEquals( ROWS * COLUMNS - 1, grid.getBrightness() );
		
		grid.turnOff( x, y );
		assertEquals( ROWS * COLUMNS - 1, grid.getBrightness() );
	}
	
	@Test
	public void togglingLightIncreasesBrightnessBy2() {
		int x = getRandomCoordinate();
		int y = getRandomCoordinate();
		
		grid.toggle( x, y );
		assertEquals( 2, grid.getBrightness() );
		
		grid.toggle( x, y );
		assertEquals( 4, grid.getBrightness() );
	}

	private int getRandomCoordinate() {
		return random.nextInt( 10 );
	}

	private void turnOnAllLights() {
		grid.changeLights( Command.TURN_ON, new Point( 0, 0 ), new Point( ROWS - 1, COLUMNS - 1 ) );
	}
}
