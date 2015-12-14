package com.joshlessard.adventofcode2015;

import java.util.List;

import org.javatuples.Pair;

import com.joshlessard.adventofcode2015.circuit.CircuitComponent;

public abstract class CommandParser {

	public abstract boolean matches( String input );

	public List<Pair<CircuitComponent, CircuitComponent>> parse( String input ) {
		checkInput( input );
		return generateEdges( input );
	}

	private void checkInput( String input ) {
		if ( ! matches( input ) ) {
			throw new IllegalArgumentException();
		}
	}

	protected abstract List<Pair<CircuitComponent, CircuitComponent>> generateEdges( String input );
}
