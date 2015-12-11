package com.joshlessard.adventofcode2015;

public class OnOffLightGrid implements LightGrid {
	
	private boolean[][] grid;
	private int numberOfLitLights;

	public OnOffLightGrid( int rows, int columns ) {
		grid = new boolean[rows][columns];
	}

	public int getNumberOfLitLights() {
		return numberOfLitLights;
	}

	@Override
	public void changeLights( Command command, Point topLeft, Point bottomRight ) {
		for ( int x = topLeft.x; x <= bottomRight.x; ++x ) {
			for ( int y = topLeft.y; y <= bottomRight.y; ++y ) {
				switch ( command ) {
					case TURN_ON:
						if ( grid[x][y] == false ) {
							numberOfLitLights += 1;
						}
						grid[x][y] = true;
						break;
					case TURN_OFF:
						if ( grid[x][y] == true ) {
							numberOfLitLights -= 1;
						}
						grid[x][y] = false;
						break;
					case TOGGLE:
						numberOfLitLights += grid[x][y] == true ? -1 : 1;
						grid[x][y] = ! grid[x][y];
						break;
				}
			}
		}
	}
}
