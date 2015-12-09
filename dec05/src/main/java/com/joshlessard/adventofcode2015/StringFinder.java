package com.joshlessard.adventofcode2015;

import java.util.regex.Pattern;

public class StringFinder {
	
	private final Pattern pattern;

	public StringFinder( String... stringsToFind ) {
		pattern = Pattern.compile( ".*" + createRegex( stringsToFind ) + ".*" );
	}

	private String createRegex( String... stringsToFind ) {
		StringBuilder builder = new StringBuilder().append( '(' );
		for ( String stringToFind : stringsToFind ) {
			builder.append( stringToFind ).append( '|' );
		}
		builder.setCharAt( builder.length() - 1, ')' );
		return builder.toString();
	}

	public boolean containsStringToFind( String string ) {
		return pattern.matcher( string ).matches();
	}
}
