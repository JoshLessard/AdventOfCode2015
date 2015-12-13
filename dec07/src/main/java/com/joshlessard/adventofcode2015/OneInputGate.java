package com.joshlessard.adventofcode2015;

import java.util.List;

public abstract class OneInputGate extends Gate {
	
	public OneInputGate( String name ) {
		super( name, 1 );
	}
	
	@Override
	protected int createOutputSignal( List<Integer> inputSignals ) {
		return createOutputSignal( inputSignals.get( 0 ) );
	}

	protected abstract int createOutputSignal( int inputSignal );
}
