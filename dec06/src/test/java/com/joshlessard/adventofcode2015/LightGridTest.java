package com.joshlessard.adventofcode2015;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.Random;
import java.util.function.BiConsumer;

import org.junit.Test;

import com.joshlessard.adventofcode2015.LightGrid.Command;

public class LightGridTest {
	
	private Random random = new Random();
	
	private LightGrid grid = spy( new TestingLightGrid() );
	
	@Test
	public void executesTurnOnCommand() {
		Point topLeft = new Point( getRandomCoordinate(), getRandomCoordinate() );
		Point bottomRight = new Point( topLeft.x + getRandomCoordinate(), topLeft.y + getRandomCoordinate() );
		
		grid.changeLights( Command.TURN_ON, topLeft, bottomRight );
		verifyCommands( topLeft, bottomRight, (x, y) -> verify( grid ).turnOn( x, y ) );
	}

	@Test
	public void executesTurnOffCommand() {
		Point topLeft = new Point( getRandomCoordinate(), getRandomCoordinate() );
		Point bottomRight = new Point( topLeft.x + getRandomCoordinate(), topLeft.y + getRandomCoordinate() );
		
		grid.changeLights( Command.TURN_OFF, topLeft, bottomRight );
		verifyCommands( topLeft, bottomRight, (x, y) -> verify( grid ).turnOff( x, y ) );
	}
	
	@Test
	public void executesToggleCommand() {
		Point topLeft = new Point( getRandomCoordinate(), getRandomCoordinate() );
		Point bottomRight = new Point( topLeft.x + getRandomCoordinate(), topLeft.y + getRandomCoordinate() );
		
		grid.changeLights( Command.TOGGLE, topLeft, bottomRight );
		verifyCommands( topLeft, bottomRight, (x, y) -> verify( grid ).toggle( x, y ) );
	}
	
	private int getRandomCoordinate() {
		return random.nextInt( 10 );
	}
	
	private void verifyCommands( Point topLeft, Point bottomRight, BiConsumer<Integer, Integer> verifier ) {
		for ( int x = topLeft.x; x <= bottomRight.x; ++x ) {
			for ( int y = topLeft.y; y <= bottomRight.y; ++y ) {
				verifier.accept( x, y );
			}
		}
	}

	private static class TestingLightGrid extends LightGrid {

		@Override
		protected void turnOn( int x, int y ) {
		}

		@Override
		protected void turnOff( int x, int y ) {
		}

		@Override
		protected void toggle( int x, int y ) {
		}
	}
}
