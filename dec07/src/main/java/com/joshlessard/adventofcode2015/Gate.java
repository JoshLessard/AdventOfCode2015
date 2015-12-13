package com.joshlessard.adventofcode2015;

import java.util.ArrayList;
import java.util.List;

public abstract class Gate implements CircuitComponent {
	
	private final String name;
	private final int requiredNumberOfInputSignals;
	private final List<Integer> inputSignals;
	
	public Gate( String name, int requiredNumberOfInputSignals ) {
		this.name = name;
		this.requiredNumberOfInputSignals = requiredNumberOfInputSignals;
		this.inputSignals = new ArrayList<>( requiredNumberOfInputSignals );
	}
	
	@Override
	public String getName() {
		return name;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + name.hashCode();
		result = prime * result + requiredNumberOfInputSignals;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Gate other = (Gate) obj;
		if (!name.equals(other.name)) {
			return false;
		}
		if (requiredNumberOfInputSignals != other.requiredNumberOfInputSignals) {
			return false;
		}
		return true;
	}
}
