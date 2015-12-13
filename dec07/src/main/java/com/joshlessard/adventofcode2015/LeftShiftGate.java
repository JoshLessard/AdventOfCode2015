package com.joshlessard.adventofcode2015;

public class LeftShiftGate extends TwoInputGate {

	public LeftShiftGate( String name ) {
		super( name );
	}

	@Override
	protected int createOutputSignal( int inputSignal1, int inputSignal2 ) {
		return (inputSignal1 << inputSignal2) & MAXIMUM_SIGNAL;
	}
}
