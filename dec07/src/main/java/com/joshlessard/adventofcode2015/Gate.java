package com.joshlessard.adventofcode2015;

import java.util.ArrayList;
import java.util.List;

public abstract class Gate implements CircuitComponent {
	
	private final int requiredNumberOfInputSignals;
	private final List<Integer> inputSignals;
	
	public Gate( int requiredNumberOfInputSignals ) {
		this.requiredNumberOfInputSignals = requiredNumberOfInputSignals;
		this.inputSignals = new ArrayList<>( requiredNumberOfInputSignals );
	}

	@Override
	public void addInputSignal( int inputSignal ) {
		checkState( ! isOutputSignalReady() );
		checkSignal( inputSignal );
		inputSignals.add( inputSignal );
	}
	
	private void checkState( boolean stateCheck ) {
		if ( ! stateCheck ) {
			throw new IllegalStateException();
		}
	}
	
	private void checkSignal( int signal ) {
		if ( signal < 0 || signal > MAXIMUM_SIGNAL ) {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public boolean isOutputSignalReady() {
		return inputSignals.size() == requiredNumberOfInputSignals;
	}
	
	@Override
	public int getOutputSignal() {
		checkState( isOutputSignalReady() );
		return createOutputSignal( inputSignals );
	}

	protected abstract int createOutputSignal( List<Integer> inputSignals );
}
