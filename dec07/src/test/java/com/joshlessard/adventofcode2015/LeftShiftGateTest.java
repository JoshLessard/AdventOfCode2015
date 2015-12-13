package com.joshlessard.adventofcode2015;

import static com.joshlessard.adventofcode2015.CircuitComponent.MAXIMUM_SIGNAL;
import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomBitShift;
import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomSignal;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeftShiftGateTest {
	
	private int randomInputSignal1 = generateRandomSignal();
	private int randomInputSignal2 = generateRandomBitShift();
	
	private LeftShiftGate gate = new LeftShiftGate();
	
	@Test
	public void outputSignalIsLeftInputSignalShiftedLeftByRightInputSignal() {
		gate.addInputSignal( randomInputSignal1 );
		gate.addInputSignal( randomInputSignal2 );
		assertEquals( (randomInputSignal1 << randomInputSignal2) & MAXIMUM_SIGNAL, gate.getOutputSignal() );
		assertEquals( (randomInputSignal1 << randomInputSignal2) & MAXIMUM_SIGNAL, gate.createOutputSignal( randomInputSignal1, randomInputSignal2 ) );
	}
	
	@Test
	public void handlesMostSignificantBitBeingSet() {
		assertEquals( 0x8000, gate.createOutputSignal( 0x2000, 2 ) );
	}
	
	@Test
	public void setBitsLeftShiftedPastMostSignificantBitAreDropped() {
		assertEquals( 0x9620, gate.createOutputSignal( 0x72c4, 3 ) );
	}
	
	@Test
	public void leastSignificantBitsArePaddedWith0() {
		assertEquals( 0x0010, gate.createOutputSignal( 0x0001, 4 ) );
	}
}
