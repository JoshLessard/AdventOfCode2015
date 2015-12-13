package com.joshlessard.adventofcode2015.circuit.component;

import static com.joshlessard.adventofcode2015.circuit.component.TestUtilities.generateRandomName;
import static com.joshlessard.adventofcode2015.circuit.component.TestUtilities.generateRandomSignal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValueComponentTest {
	
	private String randomName = generateRandomName();
	private int randomSignal = generateRandomSignal();
	
	private ValueComponent component = new ValueComponent( randomName, randomSignal );
	
	@Test
	public void nameIsNamePassedToConstructor() {
		assertEquals( randomName, component.getName() );
	}
	
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
