package com.joshlessard.adventofcode2015.circuit.component;

import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomName;
import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomSignal;
import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomSignals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TwoInputGateTest {
	
	private List<Integer> randomInputSignals = generateRandomSignals( 2 );
	private int randomOutputSignal = generateRandomSignal();
	
	private TwoInputGate gate = spy( new TestingTwoInputGate() );
	
	@Before
	public void setUp() {
		doReturn( randomOutputSignal ).when( gate ).createOutputSignal( randomInputSignals.get( 0 ), randomInputSignals.get( 1 ) );
	}
	
	@Test
	public void createOutputSignalExtractsTwoInputSignalsAndDelegatesToSubclass() {
		assertEquals( randomOutputSignal, gate.createOutputSignal( randomInputSignals ) );
		verify( gate ).createOutputSignal( randomInputSignals.get( 0 ), randomInputSignals.get( 1 ) );
	}
	
	private static class TestingTwoInputGate extends TwoInputGate {

		public TestingTwoInputGate() {
			super( generateRandomName() );
		}

		@Override
		protected int createOutputSignal( int inputSignal1, int inputSignal2 ) {
			throw new UnsupportedOperationException();
		}
	}
}
