package com.joshlessard.adventofcode2015.command;

import java.util.List;
import java.util.regex.Matcher;

import org.javatuples.Pair;

import com.google.common.collect.ImmutableList;
import com.joshlessard.adventofcode2015.circuit.CircuitComponent;
import com.joshlessard.adventofcode2015.circuit.component.LeftShiftGate;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class LeftShiftCommandParser extends RegexCommandParser {
	
	private static final String PATTERN = "([a-z]+) LSHIFT (\\d+) -> ([a-z]+)";
	
	private int nextSuffix = 1;

	protected LeftShiftCommandParser() {
		super( PATTERN );
	}

	@Override
	protected List<Pair<CircuitComponent, CircuitComponent>> generateEdges( Matcher matcher ) {
		int bitShift = Integer.parseInt( matcher.group( 2 ) );
		LeftShiftGate leftShiftGate = new LeftShiftGate( "~~~lshift" + nextSuffix++, bitShift );
		return ImmutableList.of(
			new Pair<>( new Wire( matcher.group( 1 ) ), leftShiftGate ),
			new Pair<>( leftShiftGate, new Wire( matcher.group( 3 ) ) )
		);
	}
}
