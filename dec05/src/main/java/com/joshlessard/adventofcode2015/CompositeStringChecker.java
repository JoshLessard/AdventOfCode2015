package com.joshlessard.adventofcode2015;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class CompositeStringChecker {

	private List<Function<String, Boolean>> stringCheckers;

	@SafeVarargs
	public CompositeStringChecker( Function<String, Boolean>... stringCheckers ) {
		this.stringCheckers = Arrays.asList( stringCheckers );
	}

	public boolean accept( String string ) {
		for ( Function<String, Boolean> stringChecker : stringCheckers ) {
			if ( stringChecker.apply( string ) == false ) {
				return false;
			}
		}
		return true;
	}
}
