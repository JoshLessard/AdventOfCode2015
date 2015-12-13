package com.joshlessard.adventofcode2015.circuit.component;

import static com.joshlessard.adventofcode2015.circuit.CircuitComponent.MAXIMUM_SIGNAL;
import static com.joshlessard.adventofcode2015.circuit.component.TestUtilities.generateRandomName;
import static com.joshlessard.adventofcode2015.circuit.component.TestUtilities.generateRandomSignal;
import static com.joshlessard.adventofcode2015.circuit.component.TestUtilities.generateRandomSignals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GateTest {
	
	private String randomName = generateRandomName();
	private List<Integer> randomInputSignals = generateRandomSignals();
	private int randomOutputSignal = generateRandomSignal();
	
	private Gate gate = spy( new TestingGate( randomName, randomInputSignals.size() ) );
	
	@Before
	public void setUp() {
		doReturn( randomOutputSignal ).when( gate ).createOutputSignal( randomInputSignals );
	}
	
	@Test
	public void nameIsNamePassedToConstructor() {
		assertEquals( randomName, gate.getName() );
	}
	
	@Test( expected = IllegalStateException.class )
	public void cannotAddInputSignalIfOutputSignalIsReady() {
		doReturn( true ).when( gate ).isOutputSignalReady();
		
		gate.addInputSignal( randomInputSignals.get( 0 ) );
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void inputSignalCannotBeLessThan0() {
		gate.addInputSignal( 0 - 1 );
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void inputSignalCannotBeGreaterThanMaximumSignal() {
		gate.addInputSignal( MAXIMUM_SIGNAL + 1 );
	}
	
	@Test
	public void outputSignalIsNotReadyWhenNotAllInputSignalsHaveBeenAdded() {
		for ( int inputSignal : randomInputSignals ) {
			assertFalse( gate.isOutputSignalReady() );
			gate.addInputSignal( inputSignal );
		}
	}
	
	@Test
	public void outputSignalIsReadyWhenAllInputSignalsHaveBeenAdded() {
		for ( int inputSignal : randomInputSignals ) {
			gate.addInputSignal( inputSignal );
		}
		assertTrue( gate.isOutputSignalReady() );
	}
	
	@Test( expected = IllegalStateException.class )
	public void cannotRetrieveOutputSignalIfOutputSignalIsNotReady() {
		doReturn( false ).when( gate ).isOutputSignalReady();
		gate.getOutputSignal();
	}
	
	@Test
	public void outputSignalDelegatedToSubclass() {
		for ( int inputSignal : randomInputSignals ) {
			gate.addInputSignal( inputSignal );
		}
		
		assertEquals( randomOutputSignal, gate.getOutputSignal() );
		verify( gate ).createOutputSignal( randomInputSignals );
	}
	
	private static class TestingGate extends Gate {

		public TestingGate( String name, int requiredNumberOfInputSignals ) {
			super( name, requiredNumberOfInputSignals );
		}

		@Override
		protected int createOutputSignal( List<Integer> inputSignals ) {
			throw new UnsupportedOperationException();
		}
	}
}
