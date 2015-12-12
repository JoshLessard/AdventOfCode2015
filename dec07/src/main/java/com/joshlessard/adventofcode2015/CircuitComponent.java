package com.joshlessard.adventofcode2015;

import java.util.ArrayList;
import java.util.List;

public abstract class CircuitComponent {
	
	public static final int MAXIMUM_SIGNAL = 0xffff;
	
	private int requiredumberOfInputSignals;
	private List<Integer> inputSignals;
	
	protected CircuitComponent( int requiredNumberOfInputSignals ) {
		this.requiredumberOfInputSignals = requiredNumberOfInputSignals;
		this.inputSignals = new ArrayList<>( requiredNumberOfInputSignals );
	}
	
	public void addInputSignal( int signal ) {
		checkState( ! isOutputSignalReady() );
		checkSignal( signal );
		inputSignals.add( signal );
	}

	private void checkState(boolean stateCheck) {
		if ( ! stateCheck ) {
			throw new IllegalStateException();
		}
	}
	
	private void checkSignal( int signal ) {
		if ( signal < 0 || signal > MAXIMUM_SIGNAL ) {
			throw new IllegalArgumentException();
		}
	}
	
	public boolean isOutputSignalReady() {
		return inputSignals.size() == requiredumberOfInputSignals;
	}
	
	public int getOutputSignal() {
		checkState( isOutputSignalReady() );
		return 0;
	}
}
