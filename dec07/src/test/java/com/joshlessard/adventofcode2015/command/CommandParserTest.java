package com.joshlessard.adventofcode2015.command;

import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.javatuples.Pair;
import org.junit.Before;
import org.junit.Test;

import com.joshlessard.adventofcode2015.circuit.CircuitComponent;

@SuppressWarnings("unchecked")
public class CommandParserTest {
	
	private String randomCommand = generateRandomString();
	private List<Pair<CircuitComponent, CircuitComponent>> mockGeneratedEdges = mock( List.class );
	
	private CommandParser parser = spy( new TestingCommandParser() );
	
	@Before
	public void setUp() {
		doReturn( true ).when( parser ).matches( randomCommand );
		doReturn( mockGeneratedEdges ).when( parser ).generateEdges( randomCommand );
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void cannotParseACommandThatThisParserDoesNotMatch() {
		doReturn( false ).when( parser ).matches( randomCommand );
		
		parser.parse( randomCommand );
	}
	
	@Test
	public void parseDelegatesEdgeGenerationToSubclass() {
		assertEquals( mockGeneratedEdges, parser.parse( randomCommand ) );
		verify( parser ).generateEdges( randomCommand );
	}
	
	private static class TestingCommandParser extends CommandParser {

		@Override
		public boolean matches( String input ) {
			throw new UnsupportedOperationException();
		}

		@Override
		protected List<Pair<CircuitComponent, CircuitComponent>> generateEdges( String input ) {
			throw new UnsupportedOperationException();
		}
	}
}
