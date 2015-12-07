package com.joshlessard.adventofcode2015;

import java.util.Random;

public class TestUtilities {

	private static Random random = new Random();
	
	public static int createRandomCoordinate() {
		return random.nextInt( Integer.MAX_VALUE ) - Integer.MAX_VALUE / 2;
	}
}
