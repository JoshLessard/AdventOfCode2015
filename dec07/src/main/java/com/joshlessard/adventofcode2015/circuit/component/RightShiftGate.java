package com.joshlessard.adventofcode2015.circuit.component;

public class RightShiftGate extends OneInputGate {

	private int bitShift;

	public RightShiftGate( String name, int bitShift ) {
		super( name );
		this.bitShift = bitShift;
	}

	@Override
	protected int createOutputSignal( int inputSignal ) {
		return (inputSignal >> bitShift) & MAXIMUM_SIGNAL;
	}
}
