package com.joshlessard.adventofcode2015;

public abstract class LightGrid {
	
	public static enum Command {
		TURN_ON {
			@Override
			void execute( LightGrid grid, int x, int y ) {
				grid.turnOn( x, y );
			}
		},
		TURN_OFF {
			@Override
			void execute( LightGrid grid, int x, int y ) {
				grid.turnOff( x, y );
			}
		},
		TOGGLE {
			@Override
			void execute( LightGrid grid, int x, int y ) {
				grid.toggle( x, y );
			}
		};
		
		abstract void execute( LightGrid grid, int x, int y );
	}

	public void changeLights( Command command, Point topLeft, Point bottomRight ) {
		for ( int x = topLeft.x; x <= bottomRight.x; ++x ) {
			for ( int y = topLeft.y; y <= bottomRight.y; ++y ) {
				command.execute( this, x, y );
			}
		}
	}
	
	protected abstract void turnOn( int x, int y );
	protected abstract void turnOff( int x, int y );
	protected abstract void toggle( int x, int y );
}
