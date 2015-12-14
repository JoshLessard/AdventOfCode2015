package com.joshlessard.adventofcode2015;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.javatuples.Pair;

import com.joshlessard.adventofcode2015.circuit.Circuit;
import com.joshlessard.adventofcode2015.circuit.CircuitComponent;
import com.joshlessard.adventofcode2015.command.AndCommandParser;
import com.joshlessard.adventofcode2015.command.CompositeCommandParser;
import com.joshlessard.adventofcode2015.command.LeftShiftCommandParser;
import com.joshlessard.adventofcode2015.command.NotCommandParser;
import com.joshlessard.adventofcode2015.command.OrCommandParser;
import com.joshlessard.adventofcode2015.command.RightShiftCommandParser;
import com.joshlessard.adventofcode2015.command.TunnelCommandParser;

public class Main {
	
	public static void main( String[] args ) throws FileNotFoundException, IOException {
		Circuit circuit = createCircuit( getInput( 44430 ) );
		circuit.complete();
		int wireAOutputSignal = circuit.getComponentByName( "a" ).getOutputSignal();
		System.out.println( "Part A: " + wireAOutputSignal );
		
		circuit = createCircuit( getInput( wireAOutputSignal ) );
		circuit.complete();
		wireAOutputSignal = circuit.getComponentByName( "a" ).getOutputSignal();
		System.out.println( "Part B: " + wireAOutputSignal );
	}
	
	private static Circuit createCircuit( List<String> commands ) throws FileNotFoundException, IOException {
		Circuit circuit = new Circuit();
		CompositeCommandParser parser = createCommandParser();
		for ( String command : commands ) {
			List<Pair<CircuitComponent, CircuitComponent>> edges = parser.parse( command );
			for ( Pair<CircuitComponent, CircuitComponent> edge : edges ) {
				circuit.addDirectedEdge( edge.getValue0(), edge.getValue1() );
			}
		}
		return circuit;
	}

	private static List<String> getInput( int wireBInputSignal ) throws FileNotFoundException, IOException {
		try ( BufferedReader reader = new BufferedReader( new FileReader( "src/main/resources/input.txt" ) ) ) {
			return reader
				.lines()
				.map( l -> l.replace( "{wireBInput}", Integer.toString( wireBInputSignal ) ) )
				.collect( toList() );
		}
	}
	
	private static CompositeCommandParser createCommandParser() {
		return new CompositeCommandParser(
			new AndCommandParser(),
			new LeftShiftCommandParser(),
			new NotCommandParser(),
			new OrCommandParser(),
			new RightShiftCommandParser(),
			new TunnelCommandParser()
		);
	}
}
