package com.joshlessard.adventofcode2015;

import static java.util.Objects.requireNonNull;

public class GridVisitor {

	private Grid grid;
	private Point currentPoint;

	public GridVisitor( Grid grid, Point startingPoint ) {
		this.grid = requireNonNull( grid );
		this.currentPoint = requireNonNull( startingPoint );
		grid.visit( startingPoint );
	}

	public void moveAndVisit( char move ) {
		currentPoint = currentPoint.move( move );
		grid.visit( currentPoint );
	}
}
