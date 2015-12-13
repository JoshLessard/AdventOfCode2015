package com.joshlessard.adventofcode2015.circuit.component;

import java.util.List;

public abstract class TwoInputGate extends Gate {
	
	public TwoInputGate( String name ) {
		super( name, 2 );
	}
	
	@Override
	protected int createOutputSignal( List<Integer> inputSignals ) {
		return createOutputSignal( inputSignals.get( 0 ), inputSignals.get( 1 ) );
	}

	protected abstract int createOutputSignal( int inputSignal1, int inputSignal2 );
}
