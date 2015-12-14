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
		Circuit circuit = createCircuit();
		circuit.complete();

		System.out.println( "a: " + circuit.getComponentByName( "a" ).getOutputSignal() );
	}
	
	private static Circuit createCircuit() throws FileNotFoundException, IOException {
		Circuit circuit = new Circuit();
		CompositeCommandParser parser = createCommandParser();
		for ( String input : getInput() ) {
			List<Pair<CircuitComponent, CircuitComponent>> edges = parser.parse( input );
			for ( Pair<CircuitComponent, CircuitComponent> edge : edges ) {
				circuit.addDirectedEdge( edge.getValue0(), edge.getValue1() );
			}
		}
		return circuit;
	}

	private static List<String> getInput() throws FileNotFoundException, IOException {
		try ( BufferedReader reader = new BufferedReader( new FileReader( "src/main/resources/input.txt" ) ) ) {
			return reader.lines().collect( toList() );
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
