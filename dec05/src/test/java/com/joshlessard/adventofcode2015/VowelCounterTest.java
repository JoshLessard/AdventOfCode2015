package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VowelCounterTest {
	
	private VowelCounter counter = new VowelCounter();
	
	@Test
	public void stringOfOneConsonantReturns0() {
		assertEquals( 0, counter.countVowels( "b" ) );
	}
	
	@Test
	public void stringOfOneVowelReturns1() {
		assertEquals( 1, counter.countVowels( "a" ) );
		assertEquals( 1, counter.countVowels( "e" ) );
		assertEquals( 1, counter.countVowels( "i" ) );
		assertEquals( 1, counter.countVowels( "o" ) );
		assertEquals( 1, counter.countVowels( "u" ) );
	}
	
	@Test
	public void stringOfTwoConsonantsReturns0() {
		assertEquals( 0, counter.countVowels( "bz" ) );
	}
	
	@Test
	public void stringOfTwoVowelsReturns2() {
		assertEquals( 2, counter.countVowels( "ui" ) );
	}
	
	@Test
	public void stringWithEveryConsonantReturns0() {
		assertEquals( 0, counter.countVowels( "bcdfghjklmnpqrstvwxyz" ) );
	}
	
	@Test
	public void stringWithEveryConsonantAnd7VowelsReturns7() {
		assertEquals( 7, counter.countVowels( "bocdfgahjkulmnpiqrestuvwxayz" ) );
	}
}
