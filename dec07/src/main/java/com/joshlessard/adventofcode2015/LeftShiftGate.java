package com.joshlessard.adventofcode2015;

public class LeftShiftGate extends TwoInputGate {

	@Override
	protected int createOutputSignal( int inputSignal1, int inputSignal2 ) {
		return (inputSignal1 << inputSignal2) & MAXIMUM_SIGNAL;
	}
}
