package com.joshlessard.adventofcode2015;

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
import com.joshlessard.adventofcode2015.circuit.component.RightShiftGate;
import com.joshlessard.adventofcode2015.circuit.component.Wire;

public class RightShiftCommandParserTest {
	
	private String randomWireName1 = generateRandomName();
	private String randomWireName2 = generateRandomName();
	private int randomBitShift = generateRandomBitShift();
	private String randomRightShiftCommand = randomWireName1 + " RSHIFT " + randomBitShift + " -> " + randomWireName2;
	
	private RightShiftCommandParser parser = new RightShiftCommandParser();
	
	@Test
	public void doesNotMatchRandomString() {
		assertFalse( parser.matches( generateRandomString() ) );
	}
	
	@Test
	public void doesNotMatchMalformedRightShiftCommand() {
		assertFalse( parser.matches( "blah RSHIFT blah -> blah" ) );
	}
	
	@Test
	public void matchesRightShiftCommand() {
		assertTrue( parser.matches( randomRightShiftCommand ) );
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void parsesRightShiftCommandIntoExpectedEdges() {
		List<Pair<CircuitComponent, CircuitComponent>> expectedEdges = Lists.newArrayList(
			new Pair<>( new Wire( randomWireName1 ), new RightShiftGate( "~~~rshift1", randomBitShift ) ),
			new Pair<>( new RightShiftGate( "~~~rshift1", randomBitShift ), new Wire( randomWireName2 ) )
		);
		
		assertEquals( expectedEdges, parser.generateEdges( randomRightShiftCommand ) );
	}
	
	@Test
	public void eachParseGeneratesUniquelyNamedRightShiftGateWithIncreasingSuffix() {
		List<Pair<CircuitComponent, CircuitComponent>> edges1 = parser.generateEdges( randomRightShiftCommand );
		List<Pair<CircuitComponent, CircuitComponent>> edges2 = parser.generateEdges( randomRightShiftCommand );

		assertEquals( "~~~rshift1", edges1.get( 0 ).getValue1().getName() );
		assertEquals( "~~~rshift1", edges1.get( 1 ).getValue0().getName() );
		assertEquals( "~~~rshift2", edges2.get( 0 ).getValue1().getName() );
		assertEquals( "~~~rshift2", edges2.get( 1 ).getValue0().getName() );
	}
}
