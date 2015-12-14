package com.joshlessard.adventofcode2015;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.javatuples.Pair;

import com.google.common.collect.ImmutableList;
import com.joshlessard.adventofcode2015.circuit.CircuitComponent;
import com.joshlessard.adventofcode2015.circuit.component.OrGate;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class OrCommandParser extends CommandParser {
	
	private static final Pattern PATTERN = Pattern.compile(
		"([a-z]+) OR ([a-z]+) -> ([a-z]+)"
	);
	
	private int nextSuffix = 1;

	public boolean matches( String input ) {
		return PATTERN.matcher( input ).matches();
	}

	@Override
	protected List<Pair<CircuitComponent, CircuitComponent>> generateEdges( String input ) {
		Matcher matcher = createMatcher( input );
		return generateEdges( matcher );
	}
	
	private Matcher createMatcher( String input ) {
		Matcher matcher = PATTERN.matcher( input );
		matcher.matches();
		return matcher;
	}

	private List<Pair<CircuitComponent, CircuitComponent>> generateEdges( Matcher matcher ) {
		OrGate orGate = new OrGate( "~~~or" + nextSuffix++ );
		return ImmutableList.of(
			new Pair<>( new Wire( matcher.group( 1 ) ), orGate ),
			new Pair<>( new Wire( matcher.group( 2 ) ), orGate ),
			new Pair<>( orGate, new Wire( matcher.group( 3 ) ) )
		);
	}
}
