package com.joshlessard.adventofcode2015;

public class NotGate extends OneInputGate {

	@Override
	protected int createOutputSignal( int inputSignal ) {
		return ~inputSignal & MAXIMUM_SIGNAL;
	}
}
