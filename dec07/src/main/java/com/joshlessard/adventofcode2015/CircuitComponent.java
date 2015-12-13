package com.joshlessard.adventofcode2015;

public interface CircuitComponent {
	
	public static final int MAXIMUM_SIGNAL = 0xffff;
	
	public void addInputSignal( int inputSignal );
	public boolean isOutputSignalReady();
	public int getOutputSignal();
}
