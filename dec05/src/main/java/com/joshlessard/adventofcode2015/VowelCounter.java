package com.joshlessard.adventofcode2015;

import java.util.Arrays;
import java.util.List;

public class VowelCounter {
	
	private static final List<Integer> VOWELS = Arrays.asList(
		Integer.valueOf( 'a' ),
		Integer.valueOf( 'e' ),
		Integer.valueOf( 'i' ),
		Integer.valueOf( 'o' ),
		Integer.valueOf( 'u' )
	);

	public int countVowels( String string ) {
		return string.chars()
			.filter( VOWELS::contains )
			.map( c -> 1 )
			.sum();
	}
}
