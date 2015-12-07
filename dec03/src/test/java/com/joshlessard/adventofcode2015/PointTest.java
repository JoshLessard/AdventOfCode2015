package com.joshlessard.adventofcode2015;

import static com.joshlessard.adventofcode2015.TestUtilities.createRandomCoordinate;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith( Parameterized.class )
public class PointTest {
	
	private int randomX = createRandomCoordinate();
	private int randomY = createRandomCoordinate();
	
	private char move; // injected by test runner
	
	private Point point = new Point( randomX, randomY );
	
	public PointTest( char move ) {
		this.move = move;
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void moveMustBeValid() {
		assumeThat( move, is( not( '^' ) ) );
		assumeThat( move, is( not( '>' ) ) );
		assumeThat( move, is( not( 'v' ) ) );
		assumeThat( move, is( not( '<' ) ) );
		point.move( move );
	}
	
	@Test
	public void movingUpIncreasesYCoordinateByOne() {
		Point newPoint = point.move( '^' );
		assertEquals( randomX, newPoint.getX() );
		assertEquals( randomY + 1, newPoint.getY() );
	}
	
	@Test
	public void movingRightIncreasesXCoordinateByOne() {
		Point newPoint = point.move( '>' );
		assertEquals( randomX + 1, newPoint.getX() );
		assertEquals( randomY, newPoint.getY() );
	}
	
	@Test
	public void movingDownDecreasesYCoordinateByOne() {
		Point newPoint = point.move( 'v' );
		assertEquals( randomX, newPoint.getX() );
		assertEquals( randomY - 1, newPoint.getY() );
	}
	
	@Test
	public void movingLeftDecreasesXCoordinateByOne() {
		Point newPoint = point.move( '<' );
		assertEquals( randomX - 1, newPoint.getX() );
		assertEquals( randomY, newPoint.getY() );
	}
	
	@Parameters
	public static Iterable<Object[]> parameters() {
		List<Object[]> parameters = new ArrayList<>();
		for ( char c = 0; c < 256; ++c ) {
			parameters.add( new Object[] { new Character( c ) } );
		}
		return parameters;
	}
}
