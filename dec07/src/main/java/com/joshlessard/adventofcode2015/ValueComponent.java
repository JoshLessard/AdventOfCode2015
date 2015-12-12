package com.joshlessard.adventofcode2015;

public class ValueComponent extends CircuitComponent {

	private int signal;

	public ValueComponent( int signal ) {
		this.signal = signal;
	}

	@Override
	public void addInputSignal( int signal ) {
		throw new IllegalStateException();
	}

	@Override
	public boolean isOutputSignalReady() {
		return true;
	}

	@Override
	public int getOutputSignal() {
		return signal;
	}
}
