package com.joshlessard.adventofcode2015;

public interface LightGrid {
	
	public static enum Command {
		TURN_ON,
		TURN_OFF,
		TOGGLE
	}
	
	public void changeLights( Command command, Point topLeft, Point bottomRight );
}
