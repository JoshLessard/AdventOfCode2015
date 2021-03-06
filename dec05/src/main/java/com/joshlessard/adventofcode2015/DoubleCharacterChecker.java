package com.joshlessard.adventofcode2015;

import java.util.regex.Pattern;

public class DoubleCharacterChecker {
	
	private static final Pattern PATTERN = Pattern.compile( ".*(.)\\1.*" );
	
	public boolean containsDoubleCharacter( String string ) {
		return PATTERN.matcher( string ).matches();
	}
}
