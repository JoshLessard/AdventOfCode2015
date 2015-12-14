package com.joshlessard.adventofcode2015;

import java.util.List;
import java.util.regex.Matcher;

import org.javatuples.Pair;

import com.google.common.collect.ImmutableList;
import com.joshlessard.adventofcode2015.circuit.CircuitComponent;
import com.joshlessard.adventofcode2015.circuit.component.RightShiftGate;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class RightShiftCommandParser extends RegexCommandParser {
	
	private static final String PATTERN = "([a-z]+) RSHIFT (\\d+) -> ([a-z]+)";
	
	private int nextSuffix = 1;

	protected RightShiftCommandParser() {
		super( PATTERN );
	}

	@Override
	protected List<Pair<CircuitComponent, CircuitComponent>> generateEdges( Matcher matcher ) {
		int bitShift = Integer.parseInt( matcher.group( 2 ) );
		RightShiftGate rightShiftGate = new RightShiftGate( "~~~rshift" + nextSuffix++, bitShift );
		return ImmutableList.of(
			new Pair<>( new Wire( matcher.group( 1 ) ), rightShiftGate ),
			new Pair<>( rightShiftGate, new Wire( matcher.group( 3 ) ) )
		);
	}
}
