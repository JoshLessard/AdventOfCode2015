package com.joshlessard.adventofcode2015.circuit.component;

public class NotGate extends OneInputGate {

	public NotGate( String name ) {
		super( name );
	}

	@Override
	protected int createOutputSignal( int inputSignal ) {
		return ~inputSignal & MAXIMUM_SIGNAL;
	}
}
