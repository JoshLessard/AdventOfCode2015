package com.joshlessard.adventofcode2015.command;

import java.util.List;
import java.util.regex.Matcher;

import org.javatuples.Pair;

import com.google.common.collect.ImmutableList;
import com.joshlessard.adventofcode2015.circuit.CircuitComponent;
import com.joshlessard.adventofcode2015.circuit.component.ValueComponent;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class TunnelCommandParser extends RegexCommandParser {
	
	private static final String PATTERN = "([a-z]+|\\d+) -> ([a-z]+)";
	
	private int nextSuffix = 1;

	public TunnelCommandParser() {
		super( PATTERN );
	}

	@Override
	protected List<Pair<CircuitComponent, CircuitComponent>> generateEdges( Matcher matcher ) {
		String wireName = matcher.group( 2 );
		return ImmutableList.of(
			new Pair<>( createSourceComponent( matcher ), new Wire( wireName ) )
		);
	}
	
	private CircuitComponent createSourceComponent( Matcher matcher ) {
		String outputSignal = matcher.group( 1 );
		return Character.isDigit( outputSignal.charAt( 0 ) )
			? new ValueComponent( "~~~value" + nextSuffix++, Integer.parseInt( outputSignal ) )
			: new Wire( outputSignal );
	}
}
