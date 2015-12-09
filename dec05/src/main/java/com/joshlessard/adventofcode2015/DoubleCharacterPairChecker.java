package com.joshlessard.adventofcode2015;

import java.util.regex.Pattern;

public class DoubleCharacterPairChecker {
	
	private static final Pattern PATTERN = Pattern.compile( ".*(..).*\\1.*" );

	public boolean containsDoubleCharacterPair( String string ) {
		return PATTERN.matcher( string ).matches();
	}
}
