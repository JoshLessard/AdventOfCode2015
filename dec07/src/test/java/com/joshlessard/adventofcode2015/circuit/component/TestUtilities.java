package com.joshlessard.adventofcode2015.circuit.component;

import static com.joshlessard.adventofcode2015.circuit.CircuitComponent.MAXIMUM_SIGNAL;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestUtilities {
	
	private static final Random RANDOM = new Random();
	
	public static String generateRandomName() {
		int numberOfCharacters = RANDOM.nextInt( 6 ) + 5; // 5-10
		StringBuilder builder = new StringBuilder();
		for ( int i = 0; i < numberOfCharacters; ++i ) {
			builder.append( (char) RANDOM.nextInt( Character.MAX_VALUE ) );
		}
		return builder.toString();
	}

	public static int generateRandomSignal() {
		return RANDOM.nextInt( MAXIMUM_SIGNAL + 1 );
	}
	
	public static List<Integer> generateRandomSignals() {
		return generateRandomSignals( RANDOM.nextInt( 6 ) + 5 ); // 5-10
	}

	public static List<Integer> generateRandomSignals( int numberOfSignals ) {
		List<Integer> randomSignals = new ArrayList<>( numberOfSignals );
		for ( int i = 0; i < numberOfSignals; ++i ) {
			randomSignals.add( generateRandomSignal() );
		}
		return randomSignals;
	}
	
	public static int generateRandomBitShift() {
		return RANDOM.nextInt( 5 ) + 1; // 1-5
	}
}
