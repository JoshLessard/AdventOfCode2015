package com.joshlessard.adventofcode2015;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	private static final Point ORIGIN = new Point( 0, 0 );
	
	public static void main( String[] args ) throws FileNotFoundException, IOException {
		System.out.println( "Number of houses visited (part 1): " + partOne() );
		System.out.println( "Number of houses visited (part 2): " + partTwo() );
	}

	private static int partOne() throws FileNotFoundException, IOException {
		Grid grid = new Grid();
		runVisitors( new GridVisitor( grid, ORIGIN ) );
		return grid.getNumberOfVisitedPoints();
	}
	
	private static int partTwo() throws FileNotFoundException, IOException {
		Grid grid = new Grid();
		runVisitors( new GridVisitor( grid, ORIGIN ), new GridVisitor( grid, ORIGIN ) );
		return grid.getNumberOfVisitedPoints();
	}

	private static void runVisitors( GridVisitor... visitors ) throws FileNotFoundException, IOException {
		int visitorIndex = 0;
		for ( char move : getInput().toCharArray() ) {
			visitors[visitorIndex].moveAndVisit( move );
			visitorIndex = (visitorIndex + 1) % visitors.length;
		}
	}

	private static String getInput() throws FileNotFoundException, IOException {
		try ( BufferedReader reader = new BufferedReader( new FileReader( "src/main/resources/input.txt" ) ) ) {
			return reader.readLine();
		}
	}
}
