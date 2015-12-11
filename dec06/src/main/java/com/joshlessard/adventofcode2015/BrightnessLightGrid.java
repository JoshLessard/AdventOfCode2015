package com.joshlessard.adventofcode2015;

public class BrightnessLightGrid extends LightGrid {
	
	private int[][] grid;
	private int brightness;

	public BrightnessLightGrid( int rows, int columns ) {
		grid = new int[rows][columns];
	}

	public int getBrightness() {
		return brightness;
	}

	@Override
	protected void turnOn( int x, int y ) {
		brightness += 1;
		grid[x][y] += 1;
	}

	@Override
	protected void turnOff( int x, int y ) {
		if ( grid[x][y] > 0 ) {
			brightness -= 1;
			grid[x][y] -= 1;
		}
	}

	@Override
	protected void toggle( int x, int y ) {
		brightness += 2;
		grid[x][y] += 2;
	}
}
