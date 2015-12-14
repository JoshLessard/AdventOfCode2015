package com.joshlessard.adventofcode2015.command;

import java.util.List;

import org.javatuples.Pair;

import com.joshlessard.adventofcode2015.circuit.CircuitComponent;

public class CompositeCommandParser {
	
	private final CommandParser[] commandParsers;

	public CompositeCommandParser( CommandParser... commandParsers ) {
		this.commandParsers = commandParsers;
	}

	public List<Pair<CircuitComponent, CircuitComponent>> parse( String input ) {
		return getMatchingCommandParser( input ).parse( input );
	}

	private CommandParser getMatchingCommandParser( String input ) {
		for ( CommandParser commandParser : commandParsers ) {
			if ( commandParser.matches( input ) ) {
				return commandParser;
			}
		}
		throw new IllegalArgumentException( "No matching parser for: " + input );
	}
}
