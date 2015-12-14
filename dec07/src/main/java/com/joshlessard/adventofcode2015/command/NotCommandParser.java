package com.joshlessard.adventofcode2015.command;

import java.util.List;
import java.util.regex.Matcher;

import org.javatuples.Pair;

import com.google.common.collect.ImmutableList;
import com.joshlessard.adventofcode2015.circuit.CircuitComponent;
import com.joshlessard.adventofcode2015.circuit.component.NotGate;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class NotCommandParser extends RegexCommandParser {
	
	private static final String PATTERN = "NOT ([a-z]+) -> ([a-z]+)";
	
	private int nextSuffix = 1;
	
	public NotCommandParser() {
		super( PATTERN );
	}
	
	@Override
	protected List<Pair<CircuitComponent, CircuitComponent>> generateEdges( Matcher matcher ) {
		NotGate notGate = new NotGate( "~~~not" + nextSuffix++ );
		return ImmutableList.of(
			new Pair<>( new Wire( matcher.group( 1 ) ), notGate ),
			new Pair<>( notGate, new Wire( matcher.group( 2 ) ) )
		);
	}
}
