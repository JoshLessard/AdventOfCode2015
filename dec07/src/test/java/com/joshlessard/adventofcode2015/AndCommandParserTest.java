package com.joshlessard.adventofcode2015;

import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomName;
import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomSignal;
import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.javatuples.Pair;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.joshlessard.adventofcode2015.circuit.CircuitComponent;
import com.joshlessard.adventofcode2015.circuit.component.AndGate;
import com.joshlessard.adventofcode2015.circuit.component.ValueComponent;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class AndCommandParserTest {
	
	private String randomWireName1 = generateRandomName();
	private String randomWireName2 = generateRandomName();
	private String randomWireName3 = generateRandomName();
	private int randomInputSignal = generateRandomSignal();
	private String randomAndCommandWithWireInputs = randomWireName1 + " AND " + randomWireName2 + " -> " + randomWireName3;
	private String randomAndCommandWithValueAndWireInputs = randomInputSignal + " AND " + randomWireName1 + " -> " + randomWireName2;
	
	private AndCommandParser parser = new AndCommandParser();
	
	@Test
	public void doesNotMatchRandomString() {
		assertFalse( parser.matches( generateRandomString() ) );
	}
	
	@Test
	public void doesNotMatchMalformedAndCommand() {
		assertFalse( parser.matches( "blah blah AND blah -> blah" ) );
	}
	
	@Test
	public void matchesAndCommandWithWireInputs() {
		assertTrue( parser.matches( randomAndCommandWithWireInputs ) );
	}
	
	@Test
	public void matchesAndCommandWithValueAndWireInputs() {
		assertTrue( parser.matches( randomAndCommandWithValueAndWireInputs ) );
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void parsesAndCommandWithWireInputsIntoExpectedEdges() {
		List<Pair<CircuitComponent, CircuitComponent>> expectedEdges = Lists.newArrayList(
			new Pair<>( new Wire( randomWireName1 ), new AndGate( "~~~and1" ) ),
			new Pair<>( new Wire( randomWireName2 ), new AndGate( "~~~and1" ) ),
			new Pair<>( new AndGate( "~~~and1" ), new Wire( randomWireName3 ) )
		);
		
		assertEquals( expectedEdges, parser.generateEdges( randomAndCommandWithWireInputs ) );
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void parsesAndCommandWithValueAndWireInputsIntoExpectedEdges() {
		List<Pair<CircuitComponent, CircuitComponent>> expectedEdges = Lists.newArrayList(
			new Pair<>( new ValueComponent( "~~~andvalue1", randomInputSignal ), new AndGate( "~~~and1" ) ),
			new Pair<>( new Wire( randomWireName1 ), new AndGate( "~~~and1" ) ),
			new Pair<>( new AndGate( "~~~and1" ), new Wire( randomWireName2 ) )
		);
		
		assertEquals( expectedEdges, parser.generateEdges( randomAndCommandWithValueAndWireInputs ) );
	}
	
	@Test
	public void eachParseGeneratesUniquelyNamedValueComponentAndAndGateWithIncreasingSuffixes() {
		List<Pair<CircuitComponent, CircuitComponent>> edges1 = parser.generateEdges( randomAndCommandWithValueAndWireInputs );
		List<Pair<CircuitComponent, CircuitComponent>> edges2 = parser.generateEdges( randomAndCommandWithWireInputs );
		List<Pair<CircuitComponent, CircuitComponent>> edges3 = parser.generateEdges( randomAndCommandWithValueAndWireInputs );
		
		assertEquals( "~~~andvalue1", edges1.get( 0 ).getValue0().getName() );
		assertEquals( "~~~and1", edges1.get( 0 ).getValue1().getName() );
		assertEquals( "~~~and1", edges1.get( 1 ).getValue1().getName() );
		assertEquals( "~~~and1", edges1.get( 2 ).getValue0().getName() );
		assertEquals( "~~~and2", edges2.get( 0 ).getValue1().getName() );
		assertEquals( "~~~and2", edges2.get( 1 ).getValue1().getName() );
		assertEquals( "~~~and2", edges2.get( 2 ).getValue0().getName() );
		assertEquals( "~~~andvalue2", edges3.get( 0 ).getValue0().getName() );
		assertEquals( "~~~and3", edges3.get( 0 ).getValue1().getName() );
		assertEquals( "~~~and3", edges3.get( 1 ).getValue1().getName() );
		assertEquals( "~~~and3", edges3.get( 2 ).getValue0().getName() );
	}
}
