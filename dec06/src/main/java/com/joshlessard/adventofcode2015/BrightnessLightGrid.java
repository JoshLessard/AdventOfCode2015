package com.joshlessard.adventofcode2015;

public class BrightnessLightGrid implements LightGrid {
	
	private int[][] grid;
	private int brightness;

	public BrightnessLightGrid( int rows, int columns ) {
		grid = new int[rows][columns];
	}

	@Override
	public void changeLights( Command command, Point topLeft, Point bottomRight ) {
		for ( int x = topLeft.x; x <= bottomRight.x; ++x ) {
			for ( int y = topLeft.y; y <= bottomRight.y; ++y ) {
				switch ( command ) {
					case TURN_ON:
						brightness += 1;
						grid[x][y] += 1;
						break;
					case TURN_OFF:
						if ( grid[x][y] > 0 ) {
							brightness -= 1;
							grid[x][y] -= 1;
						}
						break;
					case TOGGLE:
						brightness += 2;
						grid[x][y] += 2;
						break;
				}
			}
		}
	}

	public int getBrightness() {
		return brightness;
	}
}
