package com.joshlessard.adventofcode2015;

import java.util.List;
import java.util.regex.Matcher;

import org.javatuples.Pair;

import com.google.common.collect.ImmutableList;
import com.joshlessard.adventofcode2015.circuit.CircuitComponent;
import com.joshlessard.adventofcode2015.circuit.component.AndGate;
import com.joshlessard.adventofcode2015.circuit.component.ValueComponent;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class AndCommandParser extends RegexCommandParser {
	
	private static final String PATTERN = "([a-z]+|\\d+) AND ([a-z]+) -> ([a-z]+)";
	
	private int nextAndSuffix = 1;
	private int nextValueSuffix = 1;

	protected AndCommandParser() {
		super( PATTERN );
	}

	@Override
	protected List<Pair<CircuitComponent, CircuitComponent>> generateEdges( Matcher matcher ) {
		AndGate andGate = new AndGate( "~~~and" + nextAndSuffix++ );
		return ImmutableList.of(
			new Pair<>( createFirstInputComponent( matcher ), andGate ),
			new Pair<>( new Wire( matcher.group( 2 ) ), andGate ),
			new Pair<>( andGate, new Wire( matcher.group( 3 ) ) )
		);
	}

	private CircuitComponent createFirstInputComponent( Matcher matcher ) {
		String group = matcher.group( 1 );
		return Character.isDigit( group.charAt( 0 ) )
			? new ValueComponent( "~~~andvalue" + nextValueSuffix++, Integer.parseInt( group ) )
			: new Wire( group );
	}
}
