package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertEquals;

import org.javatuples.Triplet;
import org.junit.Test;
import static com.joshlessard.adventofcode2015.LightGrid.Command;

public class CommandParserTest {
	
	private CommandParser parser = new CommandParser();
	
	@Test
	public void parsesTurnOnCommand() {
		Triplet<Command, Point, Point> command = parser.parse( "turn on 158,270 through 243,802" );
		assertEquals( Command.TURN_ON, command.getValue0() );
		assertEquals( new Point( 158, 270 ), command.getValue1() );
		assertEquals( new Point( 243, 802 ), command.getValue2() );
	}
	
	@Test
	public void parsesTurnOffCommand() {
		Triplet<Command, Point, Point> command = parser.parse( "turn off 660,55 through 986,197" );
		assertEquals( Command.TURN_OFF, command.getValue0() );
		assertEquals( new Point( 660, 55 ), command.getValue1() );
		assertEquals( new Point( 986, 197 ), command.getValue2() );
	}
	
	@Test
	public void parsesToggleCommand() {
		Triplet<Command, Point, Point> command = parser.parse( "toggle 352,432 through 628,550" );
		assertEquals( Command.TOGGLE, command.getValue0() );
		assertEquals( new Point( 352, 432 ), command.getValue1() );
		assertEquals( new Point( 628, 550 ), command.getValue2() );
	}
}
