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

public class ValueCommandParserTest {
	
	private int randomOutputSignal = generateRandomSignal();
	private String randomWireName = generateRandomName();
	private String randomValueCommand = randomOutputSignal + " -> " + randomWireName;
	
	private ValueCommandParser parser = new ValueCommandParser();
	
	@Test
	public void doesNotMatchRandomString() {
		assertFalse( parser.matches( generateRandomString() ) );
	}
	
	@Test
	public void doesNotMatchMalformedValueCommand() {
		assertFalse( parser.matches( "blah -> blah" ) );
	}
	
	@Test
	public void matchesValueCommand() {
		assertTrue( parser.matches( randomValueCommand ) );
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void parsesValueCommandIntoExpectedEdges() {
		List<Pair<CircuitComponent, CircuitComponent>> expectedEdges = Lists.newArrayList(
			new Pair<>( new ValueComponent( "~~~value1", randomOutputSignal ), new Wire( randomWireName ) )
		);
		
		assertEquals( expectedEdges, parser.generateEdges( randomValueCommand ) );
	}
	
	@Test
	public void eachParseGeneratesUniquelyNamedValueComponentWithIncreasingSuffix() {
		List<Pair<CircuitComponent, CircuitComponent>> edges1 = parser.generateEdges( randomValueCommand );
		List<Pair<CircuitComponent, CircuitComponent>> edges2 = parser.generateEdges( randomValueCommand );

		assertEquals( "~~~value1", edges1.get( 0 ).getValue0().getName() );
		assertEquals( "~~~value2", edges2.get( 0 ).getValue0().getName() );
	}
}
