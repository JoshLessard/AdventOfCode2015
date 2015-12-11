package com.joshlessard.adventofcode2015;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.javatuples.Triplet;

import com.joshlessard.adventofcode2015.LightGrid.Command;

public class CommandParser {
	
	private static final Pattern PATTERN = Pattern.compile(
		"(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)"
	);

	public Triplet<Command, Point, Point> parse( String commandString ) {
		Matcher matcher = PATTERN.matcher( commandString );
		if ( matcher.matches() ) {
			return new Triplet<>(
				parseCommand( matcher.group( 1 ) ),
				parsePoint( matcher.group( 2 ), matcher.group( 3 ) ),
				parsePoint( matcher.group( 4 ), matcher.group( 5 ) )
			);
		}
		throw new IllegalArgumentException();
	}

	private Command parseCommand( String commandString ) {
		if ( "turn on".equals( commandString ) ) {
			return Command.TURN_ON;
		}
		if ( "turn off".equals( commandString ) ) {
			return Command.TURN_OFF;
		}
		if ( "toggle".equals( commandString ) ) {
			return Command.TOGGLE;
		}
		throw new IllegalArgumentException();
	}

	private Point parsePoint( String x, String y ) {
		return new Point( Integer.parseInt( x ), Integer.parseInt( y ) );
	}
}
