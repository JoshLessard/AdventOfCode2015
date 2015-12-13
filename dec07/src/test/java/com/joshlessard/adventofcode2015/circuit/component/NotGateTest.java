package com.joshlessard.adventofcode2015.circuit.component;

import static com.joshlessard.adventofcode2015.circuit.CircuitComponent.MAXIMUM_SIGNAL;
import static com.joshlessard.adventofcode2015.circuit.component.TestUtilities.generateRandomName;
import static com.joshlessard.adventofcode2015.circuit.component.TestUtilities.generateRandomSignal;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NotGateTest {
	
	private int randomInputSignal = generateRandomSignal();
	
	private NotGate gate = new NotGate( generateRandomName() );
	
	@Test
	public void outputSignalIsOnesCompementOfInputSignal() {
		gate.addInputSignal( randomInputSignal );
		assertEquals( ~randomInputSignal & MAXIMUM_SIGNAL, gate.getOutputSignal() );
		assertEquals( ~randomInputSignal & MAXIMUM_SIGNAL, gate.createOutputSignal( randomInputSignal ) );
	}
	
	@Test
	public void handlesMostSignificantBitBeingSet() {
		assertEquals( 0xf058, gate.createOutputSignal( 0x0fa7 ) );
	}
}
