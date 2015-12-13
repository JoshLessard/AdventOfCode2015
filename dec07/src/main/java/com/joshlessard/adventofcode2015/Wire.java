package com.joshlessard.adventofcode2015;

public class Wire extends OneInputGate {

	public Wire( String name ) {
		super( name );
	}

	@Override
	protected int createOutputSignal( int inputSignal ) {
		return inputSignal;
	}
}
