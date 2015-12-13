package com.joshlessard.adventofcode2015;

import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomSignal;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WireTest {
	
	private int randomInputSignal = generateRandomSignal();
	
	private Wire wire = new Wire();
	
	@Test
	public void outputSignalIsInputSignal() {
		wire.addInputSignal( randomInputSignal );
		assertEquals( randomInputSignal, wire.getOutputSignal() );
		assertEquals( randomInputSignal, wire.createOutputSignal( randomInputSignal ) );
	}
}
