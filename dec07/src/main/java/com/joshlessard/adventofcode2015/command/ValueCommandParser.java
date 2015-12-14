package com.joshlessard.adventofcode2015.command;

import java.util.List;
import java.util.regex.Matcher;

import org.javatuples.Pair;

import com.google.common.collect.ImmutableList;
import com.joshlessard.adventofcode2015.circuit.CircuitComponent;
import com.joshlessard.adventofcode2015.circuit.component.ValueComponent;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class ValueCommandParser extends RegexCommandParser {
	
	private static final String PATTERN = "(\\d+) -> ([a-z]+)";
	
	private int nextSuffix = 1;

	public ValueCommandParser() {
		super( PATTERN );
	}

	@Override
	protected List<Pair<CircuitComponent, CircuitComponent>> generateEdges( Matcher matcher ) {
		int outputSignal = Integer.parseInt( matcher.group( 1 ) );
		String wireName = matcher.group( 2 );
		return ImmutableList.of(
			new Pair<>( new ValueComponent( "~~~value" + nextSuffix++, outputSignal ), new Wire( wireName ) )
		);
	}
}
