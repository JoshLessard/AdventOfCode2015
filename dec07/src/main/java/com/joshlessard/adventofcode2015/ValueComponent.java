package com.joshlessard.adventofcode2015;

public class ValueComponent implements CircuitComponent {

	private final String name;
	private final int outputSignal;

	public ValueComponent( String name, int outputSignal ) {
		this.name = name;
		this.outputSignal = outputSignal;
	}
	
	@Override
	public String getName() {
		return name;
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
