package com.joshlessard.adventofcode2015.command;

import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomBitShift;
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
import com.joshlessard.adventofcode2015.circuit.component.LeftShiftGate;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class LeftShiftCommandParserTest {
	
	private String randomWireName1 = generateRandomName();
	private String randomWireName2 = generateRandomName();
	private int randomBitShift = generateRandomBitShift();
	private String randomLeftShiftCommand = randomWireName1 + " LSHIFT " + randomBitShift + " -> " + randomWireName2;
	
	private LeftShiftCommandParser parser = new LeftShiftCommandParser();
	
	@Test
	public void doesNotMatchRandomString() {
		assertFalse( parser.matches( generateRandomString() ) );
	}
	
	@Test
	public void doesNotMatchMalformedLeftShiftCommand() {
		assertFalse( parser.matches( "blah LSHIFT blah -> blah" ) );
	}
	
	@Test
	public void matchesLeftShiftCommand() {
		assertTrue( parser.matches( randomLeftShiftCommand ) );
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void parsesLeftShiftCommandIntoExpectedEdges() {
		List<Pair<CircuitComponent, CircuitComponent>> expectedEdges = Lists.newArrayList(
			new Pair<>( new Wire( randomWireName1 ), new LeftShiftGate( "~~~lshift1", randomBitShift ) ),
			new Pair<>( new LeftShiftGate( "~~~lshift1", randomBitShift ), new Wire( randomWireName2 ) )
		);
		
		assertEquals( expectedEdges, parser.generateEdges( randomLeftShiftCommand ) );
	}
	
	@Test
	public void eachParseGeneratesUniquelyNamedLeftShiftGateWithIncreasingSuffix() {
		List<Pair<CircuitComponent, CircuitComponent>> edges1 = parser.generateEdges( randomLeftShiftCommand );
		List<Pair<CircuitComponent, CircuitComponent>> edges2 = parser.generateEdges( randomLeftShiftCommand );

		assertEquals( "~~~lshift1", edges1.get( 0 ).getValue1().getName() );
		assertEquals( "~~~lshift1", edges1.get( 1 ).getValue0().getName() );
		assertEquals( "~~~lshift2", edges2.get( 0 ).getValue1().getName() );
		assertEquals( "~~~lshift2", edges2.get( 1 ).getValue0().getName() );
	}
}
