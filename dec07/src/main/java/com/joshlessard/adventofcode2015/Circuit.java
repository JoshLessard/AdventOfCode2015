package com.joshlessard.adventofcode2015;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Circuit {
	
	private final Map<String, CircuitComponent> componentsByName;
	private final Map<CircuitComponent, List<CircuitComponent>> directedEdges;
	
	public Circuit() {
		componentsByName = new HashMap<>();
		directedEdges = new HashMap<>();
	}
	
	public void addDirectedEdge( CircuitComponent source, CircuitComponent destination ) {
		source = ensureComponentMappedByName( source );
		destination = ensureComponentMappedByName( destination );
		getDestinationComponents( source ).add( destination );
	}

	private CircuitComponent ensureComponentMappedByName( CircuitComponent component ) {
		ensureNoNamingCollision( component );
		return mapByNameIfNecessary( component );
		
	}

	private void ensureNoNamingCollision( CircuitComponent component ) {
		String name = component.getName();
		if ( componentsByName.containsKey( name ) && ! componentsByName.get( name ).equals( component ) ) {
			throw new IllegalArgumentException( "Already have a component named " + name );
		}
	}
	
	private CircuitComponent mapByNameIfNecessary( CircuitComponent component ) {
		if ( ! componentsByName.containsKey( component.getName() ) ) {
			componentsByName.put( component.getName(), component );
		}
		return componentsByName.get( component.getName() );
	}

	private List<CircuitComponent> getDestinationComponents( CircuitComponent source ) {
		return directedEdges.computeIfAbsent( source, k -> new ArrayList<>() );
	}

	public CircuitComponent getComponentByName( String name ) {
		return componentsByName.get( name );
	}

	public void complete() {
		List<CircuitComponent> queue = getComponentsWhoseOuputSignalIsReady();
		while ( ! queue.isEmpty() ) {
			CircuitComponent source = queue.remove( 0 );
			for ( CircuitComponent destination : getDestinationComponents( source ) ) {
				destination.addInputSignal( source.getOutputSignal() );
				if ( destination.isOutputSignalReady() ) {
					queue.add( destination );
				}
			}
		}
	}

	private List<CircuitComponent> getComponentsWhoseOuputSignalIsReady() {
		return componentsByName
			.values()
			.stream()
			.filter( CircuitComponent::isOutputSignalReady )
			.collect( toList() );
	}
}
