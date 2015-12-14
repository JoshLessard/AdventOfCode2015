package com.joshlessard.adventofcode2015.command;

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
import com.joshlessard.adventofcode2015.circuit.component.ValueComponent;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class TunnelCommandParserTest {
	
	private int randomOutputSignal = generateRandomSignal();
	private String randomWireName1 = generateRandomName();
	private String randomWireName2 = generateRandomName();
	
	private String randomValueTunnelCommand = randomOutputSignal + " -> " + randomWireName1;
	private String randomWireTunnelCommand = randomWireName1 + " -> " + randomWireName2;
	
	private TunnelCommandParser parser = new TunnelCommandParser();
	
	@Test
	public void doesNotMatchRandomString() {
		assertFalse( parser.matches( generateRandomString() ) );
	}
	
	@Test
	public void doesNotMatchMalformedTunnelCommand() {
		assertFalse( parser.matches( "blah blah -> blah" ) );
	}
	
	@Test
	public void matchesValueTunnelCommand() {
		assertTrue( parser.matches( randomValueTunnelCommand ) );
	}
	
	@Test
	public void matchesWireTunnelCommand() {
		assertTrue( parser.matches( randomWireTunnelCommand ) );
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void parsesValueTunnelCommandIntoExpectedEdges() {
		List<Pair<CircuitComponent, CircuitComponent>> expectedEdges = Lists.newArrayList(
			new Pair<>( new ValueComponent( "~~~value1", randomOutputSignal ), new Wire( randomWireName1 ) )
		);
		
		assertEquals( expectedEdges, parser.generateEdges( randomValueTunnelCommand ) );
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void parsesWireTunnelCommandIntoExpectedEdges() {
		List<Pair<CircuitComponent, CircuitComponent>> expectedEdges = Lists.newArrayList(
			new Pair<>( new Wire( randomWireName1 ), new Wire( randomWireName2 ) )
		);
		
		assertEquals( expectedEdges, parser.generateEdges( randomWireTunnelCommand ) );
	}
	
	@Test
	public void eachParseGeneratesUniquelyNamedValueComponentWithIncreasingSuffix() {
		List<Pair<CircuitComponent, CircuitComponent>> edges1 = parser.generateEdges( randomValueTunnelCommand );
		List<Pair<CircuitComponent, CircuitComponent>> edges2 = parser.generateEdges( randomValueTunnelCommand );

		assertEquals( "~~~value1", edges1.get( 0 ).getValue0().getName() );
		assertEquals( "~~~value2", edges2.get( 0 ).getValue0().getName() );
	}
}
