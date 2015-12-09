package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DoubleCharacterPairCheckerTest {
	
	private DoubleCharacterPairChecker checker = new DoubleCharacterPairChecker();
	
	@Test
	public void stringWithoutRepeatedCharacterPairReturnsFalse() {
		assertFalse( checker.containsDoubleCharacterPair( "lfsbftalvls" ) );
	}
	
	@Test
	public void stringWithRepeatedCharacterPairReturnsTrue() {
		assertTrue( checker.containsDoubleCharacterPair( "aabaa" ) );
	}
	
	@Test
	public void doubleCharacterPairReturnsTrue() {
		assertTrue( checker.containsDoubleCharacterPair( "dcdc" ) );
	}
	
	@Test
	public void stringWithTripleCharacterReturnsFalse() {
		assertFalse( checker.containsDoubleCharacterPair( "jtaqsoaaajlfsei" ) );
	}
	
	@Test
	public void stringWithDoubleCharacterPairNearTheMiddleReturnsTrue() {
		assertTrue( checker.containsDoubleCharacterPair( "abcdtgdcbatgqwer" ) );
	}
}
