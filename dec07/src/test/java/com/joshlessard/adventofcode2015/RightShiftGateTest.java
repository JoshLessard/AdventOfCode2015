package com.joshlessard.adventofcode2015;

import static com.joshlessard.adventofcode2015.CircuitComponent.MAXIMUM_SIGNAL;
import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomBitShift;
import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomSignal;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RightShiftGateTest {
	
	private int randomInputSignal1 = generateRandomSignal();
	private int randomInputSignal2 = generateRandomBitShift();
	
	private RightShiftGate gate = new RightShiftGate();
	
	@Test
	public void outputSignalIsLeftInputSignalShiftedRightByRightInputSignal() {
		gate.addInputSignal( randomInputSignal1 );
		gate.addInputSignal( randomInputSignal2 );
		assertEquals( (randomInputSignal1 >> randomInputSignal2) & MAXIMUM_SIGNAL, gate.getOutputSignal() );
		assertEquals( (randomInputSignal1 >> randomInputSignal2) & MAXIMUM_SIGNAL, gate.createOutputSignal( randomInputSignal1, randomInputSignal2 ) );
	}
	
	@Test
	public void mostSignificantBitsArePaddedWith0() {
		assertEquals( 0x1000, gate.createOutputSignal( 0x8000, 3 ) );
	}
}
