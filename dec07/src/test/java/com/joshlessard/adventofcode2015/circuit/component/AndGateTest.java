package com.joshlessard.adventofcode2015.circuit.component;

import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomName;
import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomSignal;
import static com.joshlessard.adventofcode2015.circuit.CircuitComponent.MAXIMUM_SIGNAL;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AndGateTest {
	
	private int randomInputSignal1 = generateRandomSignal();
	private int randomInputSignal2 = generateRandomSignal();
	
	private AndGate gate = new AndGate( generateRandomName() );
	
	@Test
	public void outputSignalIsBitwiseAndOf2InputSignals() {
		gate.addInputSignal( randomInputSignal1 );
		gate.addInputSignal( randomInputSignal2 );
		assertEquals( (randomInputSignal1 & randomInputSignal2) & MAXIMUM_SIGNAL, gate.getOutputSignal() );
		assertEquals( (randomInputSignal1 & randomInputSignal2) & MAXIMUM_SIGNAL, gate.createOutputSignal( randomInputSignal1, randomInputSignal2 ) );
	}
	
	@Test
	public void handlesMostSignificantBitBeingSet() {
		assertEquals( 0x8000, gate.createOutputSignal( 0x8000, 0x8000 ) );
	}
}
