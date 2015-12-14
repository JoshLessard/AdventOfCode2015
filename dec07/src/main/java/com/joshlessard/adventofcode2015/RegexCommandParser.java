package com.joshlessard.adventofcode2015;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.javatuples.Pair;

import com.joshlessard.adventofcode2015.circuit.CircuitComponent;

// TODO: Can this be tested?
// TODO: If so, could remove a few tests from the concrete parser test classes
public abstract class RegexCommandParser extends CommandParser {
	
	private final Pattern pattern;
	
	protected RegexCommandParser( String regex ) {
		this.pattern = Pattern.compile( regex );
	}

	@Override
	public boolean matches( String input ) {
		return pattern.matcher( input ).matches();
	}

	@Override
	protected List<Pair<CircuitComponent, CircuitComponent>> generateEdges( String input ) {
		Matcher matcher = createMatcher( input );
		return generateEdges( matcher );
	}
	
	private Matcher createMatcher( String input ) {
		Matcher matcher = pattern.matcher( input );
		matcher.matches();
		return matcher;
	}
	
	protected abstract List<Pair<CircuitComponent, CircuitComponent>> generateEdges( Matcher matcher );
}
