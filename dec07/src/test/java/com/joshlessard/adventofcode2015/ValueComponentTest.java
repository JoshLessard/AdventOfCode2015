package com.joshlessard.adventofcode2015;

import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomSignal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValueComponentTest {
	
	private int randomSignal = generateRandomSignal();
	
	private ValueComponent component = new ValueComponent( randomSignal );
	
	@Test( expected = IllegalStateException.class )
	public void cannotAddInputSignals() {
		component.addInputSignal( generateRandomSignal() );
	}
	
	@Test
	public void outputSignalIsReady() {
		assertTrue( component.isOutputSignalReady() );
	}
	
	@Test
	public void outputSignalIsSignalPassedToConstructor() {
		assertEquals( randomSignal, component.getOutputSignal() );
	}
}
