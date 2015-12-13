package com.joshlessard.adventofcode2015.circuit.component;

public class RightShiftGate extends OneInputGate {

	private int bitShift;

	public RightShiftGate( int bitShift, String name ) {
		super( name );
		this.bitShift = bitShift;
	}

	@Override
	protected int createOutputSignal( int inputSignal ) {
		return (inputSignal >> bitShift) & MAXIMUM_SIGNAL;
	}
}
