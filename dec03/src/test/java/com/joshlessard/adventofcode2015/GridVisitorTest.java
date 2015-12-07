package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class GridVisitorTest {
	
	private Random random = new Random();
	
	private Point mockStartingPoint = mock( Point.class );
	private char randomMove1 = (char) random.nextInt( 256 );
	private char randomMove2 = (char) random.nextInt( 256 );
	private Point mockNextPoint1 = mock( Point.class );
	private Point mockNextPoint2 = mock( Point.class );
	
	private Grid mockGrid = mock( Grid.class );
	
	private GridVisitor visitor = new GridVisitor( mockGrid, mockStartingPoint );
	
	@Before
	public void setUp() {
		when( mockStartingPoint.move( randomMove1 ) ).thenReturn( mockNextPoint1 );
		when( mockNextPoint1.move( randomMove2 ) ).thenReturn( mockNextPoint2 );
	}
	
	@Test( expected = NullPointerException.class )
	public void gridCannotBeNull() {
		new GridVisitor( null, mockStartingPoint );
	}
	
	@Test( expected = NullPointerException.class )
	public void startingPointCannotBeNull() {
		new GridVisitor( mockGrid, null );
	}
	
	@Test
	public void visitorImmediatelyVisitsStartingPoint() {
		ArgumentCaptor<Point> pointArgument = ArgumentCaptor.forClass( Point.class );
		verify( mockGrid ).visit( pointArgument.capture() );
		assertEquals( mockStartingPoint, pointArgument.getValue() );
	}
	
	@Test
	public void visitorMovesPointAndVisitsIt() {
		ArgumentCaptor<Point> pointArgument = ArgumentCaptor.forClass( Point.class );
		
		visitor.moveAndVisit( randomMove1 );
		visitor.moveAndVisit( randomMove2 );
		
		verify( mockStartingPoint ).move( randomMove1 );
		verify( mockGrid, times( 3 ) ).visit( pointArgument.capture() );
		assertEquals(
			Arrays.asList( mockStartingPoint, mockNextPoint1, mockNextPoint2 ),
			pointArgument.getAllValues()
		);
	}
}
