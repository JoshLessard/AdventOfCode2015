package com.joshlessard.adventofcode2015.command;

import static com.joshlessard.adventofcode2015.TestUtilities.generateRandomString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.javatuples.Pair;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.joshlessard.adventofcode2015.circuit.CircuitComponent;

public class CompositeCommandParserTest {
	
	private CommandParser mockCommandParser1 = mock( CommandParser.class );
	private CommandParser mockCommandParser2 = mock( CommandParser.class );
	private CommandParser mockCommandParser3 = mock( CommandParser.class );
	private String randomInput = generateRandomString();
	private List<Pair<CircuitComponent, CircuitComponent>> mockGeneratedEdges = Lists.newArrayList();
	
	private CompositeCommandParser parser = new CompositeCommandParser(
		mockCommandParser1,
		mockCommandParser2,
		mockCommandParser3
	);
	
	@Before
	public void setUp() {
		when( mockCommandParser1.matches( any() ) ).thenReturn( false );
		when( mockCommandParser2.matches( any() ) ).thenReturn( false );
		when( mockCommandParser3.matches( any() ) ).thenReturn( false );
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void atLeastOneCommandParserMustMatchInput() {
		parser.parse( randomInput );
	}
	
	@Test
	public void firstCommandParserToMatchInputHandlesParsing() {
		when( mockCommandParser2.matches( randomInput ) ).thenReturn( true );
		when( mockCommandParser2.parse( randomInput ) ).thenReturn( mockGeneratedEdges );

		List<Pair<CircuitComponent, CircuitComponent>> expectedGeneratedEdges = mockGeneratedEdges;
		List<Pair<CircuitComponent, CircuitComponent>> actualGeneratedEdges = parser.parse( randomInput );
		assertEquals( expectedGeneratedEdges, actualGeneratedEdges );
		verify( mockCommandParser1 ).matches( randomInput );
		verify( mockCommandParser2 ).matches( randomInput );
		verify( mockCommandParser2 ).parse( randomInput );
		verifyNoMoreInteractions( mockCommandParser3 );
	}
}
