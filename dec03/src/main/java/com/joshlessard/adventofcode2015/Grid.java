package com.joshlessard.adventofcode2015;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Grid {
	
	private final Map<Integer, SortedSet<Integer>> visits = new HashMap<>();
	
	public Grid() {
	}

	public int getNumberOfVisitedPoints() {
		return visits.values()
			.stream()
			.map( Set::size )
			.reduce( 0, (a, b) -> a + b );
	}

	public void visit( Point point ) {
		requireNonNull( point );
		ensureXCoordinateIsMapped( point );
		visits.get( point.getX() ).add( point.getY() );
	}

	private void ensureXCoordinateIsMapped(Point point) {
		if ( ! visits.containsKey( point.getX() ) ) {
			visits.put( point.getX(), new TreeSet<>() );
		}
	}
}
