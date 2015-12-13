package com.joshlessard.adventofcode2015.circuit.component;

import static com.joshlessard.adventofcode2015.circuit.CircuitComponent.MAXIMUM_SIGNAL;
import static com.joshlessard.adventofcode2015.circuit.component.TestUtilities.generateRandomBitShift;
import static com.joshlessard.adventofcode2015.circuit.component.TestUtilities.generateRandomName;
import static com.joshlessard.adventofcode2015.circuit.component.TestUtilities.generateRandomSignal;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeftShiftGateTest {
	
	private int randomBitShift = generateRandomBitShift();
	private int randomInputSignal = generateRandomSignal();
	
	private LeftShiftGate gate = new LeftShiftGate( randomBitShift, generateRandomName() );
	
	@Test
	public void outputSignalIsLeftInputSignalShiftedLeftByRightInputSignal() {
		gate.addInputSignal( randomInputSignal );
		assertEquals( (randomInputSignal << randomBitShift) & MAXIMUM_SIGNAL, gate.getOutputSignal() );
		assertEquals( (randomInputSignal << randomBitShift) & MAXIMUM_SIGNAL, gate.createOutputSignal( randomInputSignal ) );
	}
	
	@Test
	public void handlesMostSignificantBitBeingSet() {
		LeftShiftGate gate = new LeftShiftGate( 2, generateRandomName() );
		assertEquals( 0x8000, gate.createOutputSignal( 0x2000 ) );
	}
	
	@Test
	public void setBitsLeftShiftedPastMostSignificantBitAreDropped() {
		LeftShiftGate gate = new LeftShiftGate( 3, generateRandomName() );
		assertEquals( 0x9620, gate.createOutputSignal( 0x72c4 ) );
	}
	
	@Test
	public void leastSignificantBitsArePaddedWith0() {
		LeftShiftGate gate = new LeftShiftGate( 4, generateRandomName() );
		assertEquals( 0x0010, gate.createOutputSignal( 0x0001 ) );
	}
}
