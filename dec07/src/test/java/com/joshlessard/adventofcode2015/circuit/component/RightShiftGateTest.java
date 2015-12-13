package com.joshlessard.adventofcode2015.circuit.component;

import static com.joshlessard.adventofcode2015.circuit.CircuitComponent.MAXIMUM_SIGNAL;
import static com.joshlessard.adventofcode2015.circuit.component.TestUtilities.generateRandomBitShift;
import static com.joshlessard.adventofcode2015.circuit.component.TestUtilities.generateRandomName;
import static com.joshlessard.adventofcode2015.circuit.component.TestUtilities.generateRandomSignal;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RightShiftGateTest {
	
	private int randomBitShift = generateRandomBitShift();
	private int randomInputSignal = generateRandomSignal();
	
	private RightShiftGate gate = new RightShiftGate( randomBitShift, generateRandomName() );
	
	@Test
	public void outputSignalIsLeftInputSignalShiftedRightByRightInputSignal() {
		gate.addInputSignal( randomInputSignal );
		assertEquals( (randomInputSignal >> randomBitShift) & MAXIMUM_SIGNAL, gate.getOutputSignal() );
		assertEquals( (randomInputSignal >> randomBitShift) & MAXIMUM_SIGNAL, gate.createOutputSignal( randomInputSignal ) );
	}
	
	@Test
	public void mostSignificantBitsArePaddedWith0() {
		RightShiftGate gate = new RightShiftGate( 3, generateRandomName() );
		assertEquals( 0x1000, gate.createOutputSignal( 0x8000 ) );
	}
}
