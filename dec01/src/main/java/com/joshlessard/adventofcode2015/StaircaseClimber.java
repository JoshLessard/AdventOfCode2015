package com.joshlessard.adventofcode2015;

import static java.util.Objects.requireNonNull;

public class StaircaseClimber {

	public int climbStairs( String stairs ) {
		requireNonNull( stairs );
		return stairs.chars()
			.reduce( 0, (a, b) -> a + climbStep( b ) );
	}

	private int climbStep( int instruction ) {
		switch ( instruction ) {
			case '(':
				return 1;
			case ')':
				return -1;
			default:
				return 0;
		}
	}

	public int climbToStep( int targetStep, String stairs ) {
		requireNonNull( stairs );
		int currentStep = 0;
		int index = 1;
		for ( int instruction : stairs.toCharArray() ) {
			currentStep += climbStep( instruction );
			if ( currentStep == targetStep ) {
				return index;
			}
			++index;
		}
		throw new Error( "Never reached step " + targetStep );
	}
}
