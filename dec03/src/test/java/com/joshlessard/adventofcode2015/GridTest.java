package com.joshlessard.adventofcode2015;

import static com.joshlessard.adventofcode2015.TestUtilities.createRandomCoordinate;
import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class GridTest {
	
	private Random random = new Random();
	
	private Point randomPoint = new Point( createRandomCoordinate(), createRandomCoordinate() );
	
	private Grid grid = new Grid();
	
	@Test
	public void hasNotVisitedAnyPointsByDefault() {
		assertEquals( 0, grid.getNumberOfVisitedPoints() );
	}
	
	@Test( expected = NullPointerException.class )
	public void visitedPointCannotBeNull() {
		grid.visit( null );
	}
	
	@Test
	public void visitingAPointIncreasesNumberOfVisitedPointsByOne() {
		grid.visit( randomPoint );
		assertEquals( 1, grid.getNumberOfVisitedPoints() );
	}
	
	@Test
	public void visitingTheSamePointMoreThanOnceDoesNotIncreaseTheNumberOfVisitedPoints() {
		grid.visit( randomPoint );
		grid.visit( randomPoint );
		assertEquals( 1, grid.getNumberOfVisitedPoints() );
	}
	
	@Test
	public void visitingManyPointsAlongTheXAxisIncreasesTheNumberOfVisitedPointsAccordingly() {
		int numberOfPointsPerDirection = random.nextInt( 100 ) + 1; // 1-100
		moveAndVisit( '>', numberOfPointsPerDirection );
		moveAndVisit( '<', numberOfPointsPerDirection );
		assertEquals( 2 * numberOfPointsPerDirection, grid.getNumberOfVisitedPoints() );
	}
	
	@Test
	public void visitingManyPointsAlongTheYAxisIncreasesTheNumberOfVisitedPointsAccordingly() {
		int numberOfPointsPerDirection = random.nextInt( 100 ) + 1; // 1-100
		moveAndVisit( '^', numberOfPointsPerDirection );
		moveAndVisit( 'v', numberOfPointsPerDirection );
		assertEquals( 2 * numberOfPointsPerDirection, grid.getNumberOfVisitedPoints() );
	}

	private void moveAndVisit(char move, int numberOfPoints) {
		Point currentPoint = randomPoint;
		for ( int i = 0; i < numberOfPoints; ++i ) {
			currentPoint = currentPoint.move( move );
			grid.visit( currentPoint );
		}
	}
}
