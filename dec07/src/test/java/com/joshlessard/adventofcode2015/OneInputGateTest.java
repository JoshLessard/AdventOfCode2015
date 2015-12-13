package com.joshlessard.adventofcode2015;

import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomSignal;
import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomSignals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class OneInputGateTest {
	
	private List<Integer> randomInputSignals = generateRandomSignals( 1 );
	private int randomOutputSignal = generateRandomSignal();
	
	private OneInputGate gate = spy( new TestingOneInputGate() );
	
	@Before
	public void setUp() {
		doReturn( randomOutputSignal ).when( gate ).createOutputSignal( randomInputSignals.get( 0 ) );
	}
	
	@Test
	public void createOutputSignalExtractsInputSignalAndDelegatesToSubclass() {
		assertEquals( randomOutputSignal, gate.createOutputSignal( randomInputSignals ) );
		verify( gate ).createOutputSignal( randomInputSignals.get( 0 ) );
	}
	
	private static class TestingOneInputGate extends OneInputGate {

		@Override
		protected int createOutputSignal( int inputSignal ) {
			throw new UnsupportedOperationException();
		}
	}
}
