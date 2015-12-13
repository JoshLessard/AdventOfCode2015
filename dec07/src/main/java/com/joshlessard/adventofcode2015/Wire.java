package com.joshlessard.adventofcode2015;

public class Wire extends OneInputGate {

	@Override
	protected int createOutputSignal( int inputSignal ) {
		return inputSignal;
	}
}
