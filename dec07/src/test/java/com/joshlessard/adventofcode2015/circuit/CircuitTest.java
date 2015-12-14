package com.joshlessard.adventofcode2015.circuit;

import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomName;
import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomSignal;
import static com.joshlessard.adventofcode2015.circuit.CircuitComponent.MAXIMUM_SIGNAL;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.joshlessard.adventofcode2015.circuit.component.AndGate;
import com.joshlessard.adventofcode2015.circuit.component.LeftShiftGate;
import com.joshlessard.adventofcode2015.circuit.component.NotGate;
import com.joshlessard.adventofcode2015.circuit.component.OrGate;
import com.joshlessard.adventofcode2015.circuit.component.RightShiftGate;
import com.joshlessard.adventofcode2015.circuit.component.ValueComponent;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class CircuitTest {
	
	private String randomName = generateRandomName();
	private int randomValueSignal1 = generateRandomSignal();
	private int randomValueSignal2 = generateRandomSignal();
	private int randomOutputSignal = generateRandomSignal();
	
	private Circuit circuit = new Circuit();
	
	@Test( expected = IllegalArgumentException.class )
	public void differentComponentsWithTheSameNameCannotBeAddedToCircuit() {
		circuit.addDirectedEdge(
			new ValueComponent( randomName, randomOutputSignal ),
			new Wire( randomName )
		);
	}
	
	@Test
	public void valueComponentToWireProducesValueComponentOutputSignalAtWire() {
		circuit.addDirectedEdge(
			new ValueComponent( generateRandomName(), randomOutputSignal ),
			new Wire( randomName )
		);
		
		circuit.complete();
		assertEquals( randomOutputSignal, circuit.getComponentByName( randomName ).getOutputSignal() );
	}
	
	@Test
	public void valueComponentsToAndGateToWireProducesAndGateOuputSignalAtWire() {
		AndGate andGate = new AndGate( generateRandomName() );
		circuit.addDirectedEdge(
			new ValueComponent( generateRandomName(), randomValueSignal1 ),
			andGate
		);
		circuit.addDirectedEdge(
			new ValueComponent( generateRandomName(), randomValueSignal2 ),
			andGate
		);
		circuit.addDirectedEdge(
			andGate,
			new Wire( randomName )
		);
		
		circuit.complete();
		assertEquals(
			(randomValueSignal1 & randomValueSignal2) & MAXIMUM_SIGNAL,
			circuit.getComponentByName( randomName ).getOutputSignal()
		);
	}
	
	@Test
	public void testSampleInput() {
		circuit.addDirectedEdge(
			new ValueComponent( "~~~value1", 123 ),
			new Wire( "x" )
		);
		circuit.addDirectedEdge(
			new ValueComponent( "~~~value2", 456 ),
			new Wire( "y" )
		);
		circuit.addDirectedEdge(
			new Wire( "x" ),
			new AndGate( "~~~and1" )
		);
		circuit.addDirectedEdge(
			new Wire( "y" ),
			new AndGate( "~~~and1" )
		);
		circuit.addDirectedEdge(
			new AndGate( "~~~and1" ),
			new Wire( "d" )
		);
		circuit.addDirectedEdge(
			new Wire( "x" ),
			new OrGate( "~~~or1" )
		);
		circuit.addDirectedEdge(
			new Wire( "y" ),
			new OrGate( "~~~or1" )
		);
		circuit.addDirectedEdge(
			new OrGate( "~~~or1" ),
			new Wire( "e" )
		);
		circuit.addDirectedEdge(
			new Wire( "x" ),
			new LeftShiftGate( "~~~lshift1", 2 ) 
		);
		circuit.addDirectedEdge(
			new LeftShiftGate( "~~~lshift1", 2 ),
			new Wire( "f" )
		);
		circuit.addDirectedEdge(
			new Wire( "y" ),
			new RightShiftGate( "~~~rshift1", 2 )
		);
		circuit.addDirectedEdge(
			new RightShiftGate( "~~~rshift1", 2 ),
			new Wire( "g" )
		);
		circuit.addDirectedEdge(
			new Wire( "x" ),
			new NotGate( "~~~not1" )
		);
		circuit.addDirectedEdge(
			new NotGate( "~~~not1" ),
			new Wire( "h" )
		);
		circuit.addDirectedEdge(
			new Wire( "y" ),
			new NotGate( "~~~not2" )
		);
		circuit.addDirectedEdge(
			new NotGate( "~~~not2" ),
			new Wire( "i" )
		);
		
		circuit.complete();
		assertEquals( 72, circuit.getComponentByName( "d" ).getOutputSignal() );
		assertEquals( 507, circuit.getComponentByName( "e" ).getOutputSignal() );
		assertEquals( 492, circuit.getComponentByName( "f" ).getOutputSignal() );
		assertEquals( 114, circuit.getComponentByName( "g" ).getOutputSignal() );
		assertEquals( 65412, circuit.getComponentByName( "h" ).getOutputSignal() );
		assertEquals( 65079, circuit.getComponentByName( "i" ).getOutputSignal() );
		assertEquals( 123, circuit.getComponentByName( "x" ).getOutputSignal() );
		assertEquals( 456, circuit.getComponentByName( "y" ).getOutputSignal() );
	}
}
