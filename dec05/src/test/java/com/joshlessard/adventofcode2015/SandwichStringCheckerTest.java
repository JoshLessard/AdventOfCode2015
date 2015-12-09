package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SandwichStringCheckerTest {
	
	private SandwichStringChecker checker = new SandwichStringChecker();
	
	@Test
	public void stringWithoutSandwichReturnsFalse() {
		assertFalse( checker.containsSandwich( "abcdef" ) );
	}
	
	@Test
	public void sandwichStringReturnsTrue() {
		assertTrue( checker.containsSandwich( "ydy" ) );
	}
	
	@Test
	public void tripleCharacterReturnsTrue() {
		assertTrue( checker.containsSandwich( "uuu" ) );
	}
	
	@Test
	public void stringWithSandwichNearMiddleReturnsTrue() {
		assertTrue( checker.containsSandwich( "jlfaesijlnnlhdhfdhklfil;ds" ) );
	}
}
