package com.joshlessard.adventofcode2015;

import static com.joshlessard.adventofcode2015.circuit.CircuitComponent.MAXIMUM_SIGNAL;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import com.google.common.collect.Lists;

public class TestUtilities {
	
	private static final Random RANDOM = new Random();
	
	public static String generateRandomName() {
		return generateRandomStringWithSupplier( () -> (char) (RANDOM.nextInt( 26 ) + 97) );
	}

	private static String generateRandomStringWithSupplier( Supplier<Character> characterSupplier ) {
		int numberOfCharacters = RANDOM.nextInt( 6 ) + 5; // 5-10
		StringBuilder builder = new StringBuilder();
		for ( int i = 0; i < numberOfCharacters; ++i ) {
			builder.append( characterSupplier.get() );
		}
		return builder.toString();
	}
	
	public static String generateRandomString() {
		return generateRandomStringWithSupplier( () -> (char) RANDOM.nextInt( Character.MAX_CODE_POINT ) );
	}

	public static int generateRandomSignal() {
		return RANDOM.nextInt( MAXIMUM_SIGNAL + 1 );
	}
	
	public static List<Integer> generateRandomSignals() {
		return generateRandomSignals( RANDOM.nextInt( 6 ) + 5 ); // 5-10
	}

	public static List<Integer> generateRandomSignals( int numberOfSignals ) {
		List<Integer> randomSignals = Lists.newArrayListWithCapacity( numberOfSignals );
		for ( int i = 0; i < numberOfSignals; ++i ) {
			randomSignals.add( generateRandomSignal() );
		}
		return randomSignals;
	}
	
	public static int generateRandomBitShift() {
		return RANDOM.nextInt( 5 ) + 1; // 1-5
	}
}
