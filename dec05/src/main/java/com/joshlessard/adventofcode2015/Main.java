package com.joshlessard.adventofcode2015;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main( String[] args ) throws FileNotFoundException, IOException {
		List<String> input = getInput();
		System.out.println( "Nice strings 1: " + countNiceStrings( input, createChecker1() ) );
		System.out.println( "Nice strings 2: " + countNiceStrings( input, createChecker2() ) );
	}
	
	private static List<String> getInput() throws FileNotFoundException, IOException {
		try ( BufferedReader reader = new BufferedReader( new FileReader( "src/main/resources/input.txt" ) ) ) {
			return reader.lines().collect( Collectors.toList() );
		}
	}

	private static CompositeStringChecker createChecker1() {
		return new CompositeStringChecker(
			s -> new VowelCounter().countVowels( s ) >= 3,
			new DoubleCharacterChecker()::containsDoubleCharacter,
			s -> ! new StringFinder( "ab", "cd", "pq", "xy" ).containsStringToFind( s )
		);
	}
	
	private static CompositeStringChecker createChecker2() {
		return new CompositeStringChecker(
			new DoubleCharacterPairChecker()::containsDoubleCharacterPair,
			new SandwichStringChecker()::containsSandwich
		);
	}

	private static int countNiceStrings( List<String> input, CompositeStringChecker checker ) {
		return
			input
			.stream()
			.filter( checker::accept )
			.mapToInt( s -> 1 )
			.sum();
	}
}
