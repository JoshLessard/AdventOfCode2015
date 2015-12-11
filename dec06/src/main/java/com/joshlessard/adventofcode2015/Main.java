package com.joshlessard.adventofcode2015;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	private static final int ROWS = 1000;
	private static final int COLUMNS = 1000;
	
	public static void main( String[] args ) throws FileNotFoundException, IOException {
		OnOffLightGrid onOffGrid = new OnOffLightGrid( ROWS, COLUMNS );
		BrightnessLightGrid brightnessGrid = new BrightnessLightGrid( ROWS, COLUMNS );
		manipulateGrid( onOffGrid );
		manipulateGrid( brightnessGrid );
		
		System.out.println( "Number of lit lights: " + onOffGrid.getNumberOfLitLights() );
		System.out.println( "Total brightness: " + brightnessGrid.getBrightness() );
	}

	private static void manipulateGrid( LightGrid grid ) throws FileNotFoundException, IOException {
		CommandParser parser = new CommandParser();
		getInput()
			.stream()
			.map( parser::parse )
			.forEach( c -> grid.changeLights( c.getValue0(), c.getValue1(), c.getValue2() ) );
	}

	private static List<String> getInput() throws FileNotFoundException, IOException {
		try ( BufferedReader reader = new BufferedReader( new FileReader( "src/main/resources/input.txt" ) ) ) {
			return reader.lines().collect( Collectors.toList() );
		}
	}
}
