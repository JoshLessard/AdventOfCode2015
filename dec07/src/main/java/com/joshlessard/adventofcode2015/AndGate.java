package com.joshlessard.adventofcode2015;

import java.util.ArrayList;
import java.util.List;

public class AndGate extends CircuitComponent {
	
	private static final int REQUIRED_NUMBER_OF_INPUTS = 2;
	
	private List<Integer> inputSignals = new ArrayList<>();

	public void addInputSignal( int signal ) {
		checkState( ! isOutputSignalReady() );
		checkSignal( signal );
		inputSignals.add( signal );
	}
	
	private void checkSignal( int signal ) {
		if ( signal < 0 || signal > MAXIMUM_SIGNAL ) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isOutputSignalReady() {
		return inputSignals.size() == REQUIRED_NUMBER_OF_INPUTS;
	}

	private void checkState(boolean stateCheck) {
		if ( ! stateCheck ) {
			throw new IllegalStateException();
		}
	}

	public int getOutputSignal() {
		checkState( isOutputSignalReady() );
		return inputSignals
			.stream()
			.reduce( ~0, (a, b) -> (a & b) & MAXIMUM_SIGNAL );
	}
}
