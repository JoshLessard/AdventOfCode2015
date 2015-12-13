package com.joshlessard.adventofcode2015;

public class ValueComponent implements CircuitComponent {

	private final int outputSignal;

	public ValueComponent( int outputSignal ) {
		this.outputSignal = outputSignal;
	}

	@Override
	public void addInputSignal( int inputSignal ) {
		throw new IllegalStateException();
	}

	@Override
	public boolean isOutputSignalReady() {
		return true;
	}

	@Override
	public int getOutputSignal() {
		return outputSignal;
	}
}
