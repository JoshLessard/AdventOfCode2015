package com.joshlessard.adventofcode2015;

import java.util.Random;

public class TestUtilities {
	
	private static final Random RANDOM = new Random();
	private static final int MAXIMUM_SIGNAL = 65535;

	public static int getRandomSignal() {
		return RANDOM.nextInt( MAXIMUM_SIGNAL + 1 );
	}
}
