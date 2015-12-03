package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StaircaseClimberTest {
	
	private StaircaseClimber climber = new StaircaseClimber();
	
	@Test( expected = NullPointerException.class )
	public void inputStringCannotBeNullWhenClimbingStairs() {
		climber.climbStairs( null );
	}
	
	@Test
	public void emptyStairsClimbsToFloor0() {
		assertEquals( 0, climber.climbStairs( "" ) );
	}
	
	@Test
	public void leftParenthesisGoesToFloor1() {
		assertEquals( 1, climber.climbStairs( "(" ) );
	}
	
	@Test
	public void rightParenthesisGoesToFloorNegative1() {
		assertEquals( -1, climber.climbStairs( ")" ) );
	}
	
	@Test
	public void twoLeftParenthesesGoToFloor2() {
		assertEquals( 2, climber.climbStairs( "((" ) );
	}
	
	@Test
	public void twoRightParenthesesGoToFloorNegative2() {
		assertEquals( -2, climber.climbStairs( "))" ) );
	}
	
	@Test
	public void handlesTestInputForPuzzle1() {
		assertEquals( 0, climber.climbStairs( "(())" ) );
		assertEquals( 0, climber.climbStairs( "()()" ) );
		assertEquals( 3, climber.climbStairs( "(((" ) );
		assertEquals( 3, climber.climbStairs( "(()(()(" ) );
		assertEquals( 3, climber.climbStairs( "))(((((" ) );
		assertEquals( -1, climber.climbStairs( "())" ) );
		assertEquals( -1, climber.climbStairs( "))(" ) );
		assertEquals( -3, climber.climbStairs( ")))" ) );
		assertEquals( -3, climber.climbStairs( ")())())" ) );
	}
	
	@Test( expected = NullPointerException.class )
	public void inputCannotBeNullWhenClimbingToAStep() {
		climber.climbToStep( 0, null );
	}
	
	@Test( expected = Error.class )
	public void throwsErrorIfNeverReachesTargetStep() {
		climber.climbToStep( 10, "((((" );
	}
	
	@Test
	public void leftParenthesisWithTargetStep1StopsAt1() {
		assertEquals( 1, climber.climbToStep( 1, "(" ) );
	}
	
	@Test
	public void rightParenthesisWithTargetStepNegative1StopsAt1() {
		assertEquals( 1, climber.climbToStep( -1,  ")" ) );
	}
	
	@Test
	public void twoLeftParenthesesWithTargetStep2StopsAt2() {
		assertEquals( 2, climber.climbToStep( 2,  "((" ) );
	}
	
	@Test
	public void twoRightParenthesesWithTargetStepNegative2StopsAt2() {
		assertEquals( 2, climber.climbToStep( -2,  "))" ) );
	}
	
	@Test
	public void stopsAtFirstVisitToTargetStep() {
		assertEquals( 1, climber.climbToStep( 1,  "(((((" ) );
		assertEquals( 1, climber.climbToStep( -1,  ")))))))" ) );
	}
	
	@Test
	public void handlesTestInputForPuzzle2() {
		assertEquals( 1, climber.climbToStep( -1, ")" ) );
		assertEquals( 5, climber.climbToStep( -1, "()())" ) );
	}
}
