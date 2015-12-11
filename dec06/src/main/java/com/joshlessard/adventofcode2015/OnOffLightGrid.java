package com.joshlessard.adventofcode2015;

public class OnOffLightGrid extends LightGrid {
	
	private boolean[][] grid;
	private int numberOfLitLights;

	public OnOffLightGrid( int rows, int columns ) {
		grid = new boolean[rows][columns];
	}

	public int getNumberOfLitLights() {
		return numberOfLitLights;
	}

	@Override
	protected void turnOn( int x, int y ) {
		if ( grid[x][y] == false ) {
			numberOfLitLights += 1;
		}
		grid[x][y] = true;
	}

	@Override
	protected void turnOff( int x, int y ) {
		if ( grid[x][y] == true ) {
			numberOfLitLights -= 1;
		}
		grid[x][y] = false;
	}

	@Override
	protected void toggle( int x, int y ) {
		numberOfLitLights += grid[x][y] == true ? -1 : 1;
		grid[x][y] = ! grid[x][y];
	}
}
