package com.joshlessard.adventofcode2015;

import static com.joshlessard.adventofcode2015.CircuitComponent.MAXIMUM_SIGNAL;
import static com.joshlessard.adventofcode2015.TestUtilities.getRandomSignal;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.Random;

import org.junit.Test;

public class CircuitComponentTest {
	
	private Random random = new Random();
	
	private int randomNumberOfInputSignals = random.nextInt( 6 ) + 5; // 5-10
	private CircuitComponent component = spy( new TestingCircuitComponent( randomNumberOfInputSignals ) );
	
	@Test( expected = IllegalStateException.class )
	public void cannotAddInputSignalIfOutputSignalIsReady() {
		doReturn( true ).when( component ).isOutputSignalReady();
		component.addInputSignal( getRandomSignal() );
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void inputSignalCannotBeLessThan0() {
		component.addInputSignal( 0 - 1 );
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void inputSignalCannotBeGreaterThanMaximumSignal() {
		component.addInputSignal( MAXIMUM_SIGNAL + 1 );
	}
	
	@Test
	public void outputSignalIsReadyByDefaultForComponentWith0InputSignals() {
		CircuitComponent component = new TestingCircuitComponent( 0 );
		assertTrue( component.isOutputSignalReady() );
	}
	
	@Test
	public void outputSignalIsNotReadyByDefaultForComponentWithAtLeast1InputSignal() {
		CircuitComponent component = new TestingCircuitComponent( 1 );
		assertFalse( component.isOutputSignalReady() );
	}
	
	@Test
	public void outputSignalIsNotReadyIfNotAllInputSignalsReceived() {
		for ( int i = 0; i < randomNumberOfInputSignals - 1; ++i ) {
			component.addInputSignal( getRandomSignal() );			
			assertFalse( component.isOutputSignalReady() );
		}
	}
	
	@Test
	public void outputSignalIsReadyIfAllInputSignalsReceived() {
		for ( int i = 0; i < randomNumberOfInputSignals; ++i ) {
			component.addInputSignal( getRandomSignal() );			
		}
		assertTrue( component.isOutputSignalReady() );
	}
	
	@Test( expected = IllegalStateException.class )
	public void cannotRetrieveOutputSignalIfItIsNotReady() {
		doReturn( false ).when( component ).isOutputSignalReady();
		component.getOutputSignal();
	}
	
	@Test
	public void canRetrieveOuputSignalIfItIsReady() {
		doReturn( true ).when( component ).isOutputSignalReady();
		component.getOutputSignal();
	}
	
	tests for retrieving actual output signal
	
	private static class TestingCircuitComponent extends CircuitComponent {

		private TestingCircuitComponent( int numberOfInputSignals ) {
			super( numberOfInputSignals );
		}
	}
}
