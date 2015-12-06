package com.joshlessard.adventofcode2015;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	
	public static void main( String[] args ) throws FileNotFoundException, IOException {
		int requiredWrappingPaper = calculateWith( new WrappingPaperCalculator() );
		int requiredRibbon = calculateWith( new RibbonCalculator() );
		System.out.println( "Required wrapping paper: " + requiredWrappingPaper + " square feet." );
		System.out.println( "Required ribbon: " + requiredRibbon + " feet." );
	}

	private static int calculateWith( Calculator<BoxDimensions> calculator ) throws IOException, FileNotFoundException {
		try ( BufferedReader reader = new BufferedReader( new FileReader( "src/main/resources/input.txt" ) ) ) {
			return reader.lines()
				.map( s -> new StringTokenizer( s, "x" ) )
				.map( Main::createBoxDimensions )
				.map( calculator::calculate )
				.reduce( 0, (a, b) -> a + b );
		}
	}
	
	private static BoxDimensions createBoxDimensions( StringTokenizer tokenizer ) {
		int length = Integer.valueOf( tokenizer.nextToken() );
		int width = Integer.valueOf( tokenizer.nextToken() );
		int height = Integer.valueOf( tokenizer.nextToken() );
		return new BoxDimensions( length, width, height );
	}
}
