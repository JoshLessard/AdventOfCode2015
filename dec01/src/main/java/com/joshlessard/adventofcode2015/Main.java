package com.joshlessard.adventofcode2015;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main( String[] args ) throws FileNotFoundException, IOException {
		String input = getInput();
		StaircaseClimber climber = new StaircaseClimber();
		int finishingStep = climber.climbStairs( input );
		int positionOfFirstBasementStep = climber.climbToStep( -1, input );
		System.out.println( "Climbed to step " + finishingStep + '.' );
		System.out.println( "Reached the basement after " + positionOfFirstBasementStep + " steps." );
	}

	private static String getInput() throws IOException, FileNotFoundException {
		try ( BufferedReader reader = new BufferedReader( new FileReader( "src/main/resources/input.txt" ) ) ) {
			return reader.readLine();
		}
	}
}
