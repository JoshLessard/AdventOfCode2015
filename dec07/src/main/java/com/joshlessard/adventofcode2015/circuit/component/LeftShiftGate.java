package com.joshlessard.adventofcode2015.circuit.component;

public class LeftShiftGate extends OneInputGate {

	private int bitShift;

	public LeftShiftGate( int bitShift, String name ) {
		super( name );
		this.bitShift = bitShift;
	}

	@Override
	protected int createOutputSignal( int inputSignal ) {
		return (inputSignal << bitShift) & MAXIMUM_SIGNAL;
	}
}
