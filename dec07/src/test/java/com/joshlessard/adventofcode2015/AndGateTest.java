package com.joshlessard.adventofcode2015;

import static com.joshlessard.adventofcode2015.CircuitComponent.MAXIMUM_SIGNAL;
import static com.joshlessard.adventofcode2015.TestUtilities.getRandomSignal;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AndGateTest {
	
	private int randomSignal1 = getRandomSignal();
	private int randomSignal2 = getRandomSignal();
	
	private AndGate gate = new AndGate();
	
	@Test
	public void outputSignalIsBitwiseAndOf2InputSignals() {
		gate.addInputSignal( randomSignal1 );
		gate.addInputSignal( randomSignal2 );
		assertEquals( (randomSignal1 & randomSignal2) & MAXIMUM_SIGNAL, gate.getOutputSignal() );
	}
	
	@Test
	public void handlesMostSignificantBitBeingSet() {
		gate.addInputSignal( 0x8000 );
		gate.addInputSignal( 0x8000 );
		assertEquals( 0x8000, gate.getOutputSignal() );
	}
}
