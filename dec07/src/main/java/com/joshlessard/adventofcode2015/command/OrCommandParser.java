package com.joshlessard.adventofcode2015.command;

import java.util.List;
import java.util.regex.Matcher;

import org.javatuples.Pair;

import com.google.common.collect.ImmutableList;
import com.joshlessard.adventofcode2015.circuit.CircuitComponent;
import com.joshlessard.adventofcode2015.circuit.component.OrGate;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class OrCommandParser extends RegexCommandParser {
	
	private static final String PATTERN = "([a-z]+) OR ([a-z]+) -> ([a-z]+)";
	
	private int nextSuffix = 1;
	
	public OrCommandParser() {
		super( PATTERN );
	}
	
	@Override
	protected List<Pair<CircuitComponent, CircuitComponent>> generateEdges( Matcher matcher ) {
		OrGate orGate = new OrGate( "~~~or" + nextSuffix++ );
		return ImmutableList.of(
			new Pair<>( new Wire( matcher.group( 1 ) ), orGate ),
			new Pair<>( new Wire( matcher.group( 2 ) ), orGate ),
			new Pair<>( orGate, new Wire( matcher.group( 3 ) ) )
		);
	}
}
