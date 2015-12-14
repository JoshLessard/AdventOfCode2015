package com.joshlessard.adventofcode2015;

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
import com.joshlessard.adventofcode2015.circuit.component.NotGate;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class NotCommandParserTest {
	
	private String randomWireName1 = generateRandomName();
	private String randomWireName2 = generateRandomName();
	private String randomNotCommand = "NOT " + randomWireName1 + " -> " + randomWireName2;
	
	private NotCommandParser parser = new NotCommandParser();
	
	@Test
	public void doesNotMatchRandomString() {
		assertFalse( parser.matches( generateRandomString() ) );
	}
	
	@Test
	public void doesNotMatchMalformedNotCommand() {
		assertFalse( parser.matches( "NOT blah blah -> blah" ) );
	}
	
	@Test
	public void matchesNotCommandWithWireNameAsInput() {
		assertTrue( parser.matches( randomNotCommand ) );
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void parsesNotCommandIntoExpectedCircuitEdges() {
		List<Pair<CircuitComponent, CircuitComponent>> expectedEdges = Lists.newArrayList(
			new Pair<>( new Wire( randomWireName1 ), new NotGate( "~~~not1" ) ),
			new Pair<>( new NotGate( "~~~not1" ), new Wire( randomWireName2 ) )
		);
		
		assertEquals( expectedEdges, parser.generateEdges( randomNotCommand ) );
	}
	
	@Test
	public void eachParseGeneratesUniquelyNamedNotGateWithIncreasingSuffix() {
		List<Pair<CircuitComponent, CircuitComponent>> edges1 = parser.generateEdges( randomNotCommand );
		List<Pair<CircuitComponent, CircuitComponent>> edges2 = parser.generateEdges( randomNotCommand );

		assertEquals( "~~~not1", edges1.get( 0 ).getValue1().getName() );
		assertEquals( "~~~not1", edges1.get( 1 ).getValue0().getName() );
		assertEquals( "~~~not2", edges2.get( 0 ).getValue1().getName() );
		assertEquals( "~~~not2", edges2.get( 1 ).getValue0().getName() );
	}
}
