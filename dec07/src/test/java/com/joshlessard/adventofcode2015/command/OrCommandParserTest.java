package com.joshlessard.adventofcode2015.command;

import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomName;
import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.javatuples.Pair;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.joshlessard.adventofcode2015.circuit.CircuitComponent;
import com.joshlessard.adventofcode2015.circuit.component.OrGate;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class OrCommandParserTest {
	
	private String randomWireName1 = generateRandomName();
	private String randomWireName2 = generateRandomName();
	private String randomWireName3 = generateRandomName();
	private String randomOrCommand = randomWireName1 + " OR " + randomWireName2 + " -> " + randomWireName3;
	
	private OrCommandParser parser = new OrCommandParser();
	
	@Test
	public void doesNotMatchRandomString() {
		assertFalse( parser.matches( generateRandomString() ) );
	}
	
	@Test
	public void doesNotMatchMalformedOrCommand() {
		assertFalse( parser.matches( "OR blah blah -> blah" ) );
	}
	
	@Test
	public void matchesOrCommandWithWireNamesAsInput() {
		assertTrue( parser.matches( randomOrCommand ) );
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void parsesOrCommandIntoExpectedCircuitEdges() {
		List<Pair<CircuitComponent, CircuitComponent>> expectedEdges = Lists.newArrayList(
			new Pair<>( new Wire( randomWireName1 ), new OrGate( "~~~or1" ) ),
			new Pair<>( new Wire( randomWireName2 ), new OrGate( "~~~or1" ) ),
			new Pair<>( new OrGate( "~~~or1" ), new Wire( randomWireName3 ) )
		);
		
		assertEquals( expectedEdges, parser.generateEdges( randomOrCommand ) );
	}
	
	@Test
	public void eachParseGeneratesUniquelyNamedOrGateWithIncreasingSuffix() {
		List<Pair<CircuitComponent, CircuitComponent>> edges1 = parser.generateEdges( randomOrCommand );
		List<Pair<CircuitComponent, CircuitComponent>> edges2 = parser.generateEdges( randomOrCommand );

		assertEquals( "~~~or1", edges1.get( 0 ).getValue1().getName() );
		assertEquals( "~~~or1", edges1.get( 1 ).getValue1().getName() );
		assertEquals( "~~~or1", edges1.get( 2 ).getValue0().getName() );
		assertEquals( "~~~or2", edges2.get( 0 ).getValue1().getName() );
		assertEquals( "~~~or2", edges2.get( 1 ).getValue1().getName() );
		assertEquals( "~~~or2", edges2.get( 2 ).getValue0().getName() );
	}
}
