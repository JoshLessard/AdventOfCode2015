package com.joshlessard.adventofcode2015;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.javatuples.Pair;

import com.google.common.collect.ImmutableList;
import com.joshlessard.adventofcode2015.circuit.CircuitComponent;
import com.joshlessard.adventofcode2015.circuit.component.NotGate;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class NotCommandParser {
	
	private static final Pattern PATTERN = Pattern.compile(
		"NOT ([a-z]+) -> ([a-z]+)"
	);
	
	private int nextSuffix = 1;

	public boolean matches( String input ) {
		return PATTERN.matcher( input ).matches();
	}

	public List<Pair<CircuitComponent, CircuitComponent>> parse( String input ) {
		Matcher matcher = createMatcher( input );
		return generateEdges( matcher );
	}
	
	private Matcher createMatcher( String input ) {
		checkInput( input );
		Matcher matcher = PATTERN.matcher( input );
		matcher.matches();
		return matcher;
	}

	private void checkInput( String input ) {
		if ( ! matches( input ) ) {
			throw new IllegalArgumentException();
		}
	}

	private List<Pair<CircuitComponent, CircuitComponent>> generateEdges( Matcher matcher ) {
		NotGate notGate = new NotGate( "~~~not" + nextSuffix++ );
		return ImmutableList.of(
			new Pair<>( new Wire( matcher.group( 1 ) ), notGate ),
			new Pair<>( notGate, new Wire( matcher.group( 2 ) ) )
		);
	}
}
