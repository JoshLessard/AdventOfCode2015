package com.joshlessard.adventofcode2015;

// TODO: Change me to a one-signal gate with shift specified in constructor
public class RightShiftGate extends TwoInputGate {

	public RightShiftGate( String name ) {
		super( name );
	}

	@Override
	protected int createOutputSignal( int inputSignal1, int inputSignal2 ) {
		return (inputSignal1 >> inputSignal2) & MAXIMUM_SIGNAL;
	}
}
