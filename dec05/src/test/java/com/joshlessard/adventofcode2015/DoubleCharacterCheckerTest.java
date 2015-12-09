package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DoubleCharacterCheckerTest {
	
	private DoubleCharacterChecker checker = new DoubleCharacterChecker();
	
	@Test
	public void singleCharacterStringDoesNotContainDoubleCharacter() {
		assertFalse( checker.containsDoubleCharacter( "a" ) );
	}
	
	@Test
	public void stringOfTwoDifferentCharactersDoesNotContainDoubleCharacter() {
		assertFalse( checker.containsDoubleCharacter( "cd" ) );
	}
	
	@Test
	public void stringOfTwoIdenticalCharactersContainsDoubleCharacter() {
		assertTrue( checker.containsDoubleCharacter( "gg" ) );
	}
	
	@Test
	public void stringOfTwoIdenticalCharactersSeparatedByDifferentCharacterDoesNotContainDoubleCharacter() {
		assertFalse( checker.containsDoubleCharacter( "yuy" ) );
	}
	
	@Test
	public void stringOfTwoIdenticalCharactersFollowedByDifferentCharacterContainsDoubleCharacter() {
		assertTrue( checker.containsDoubleCharacter( "zzt" ) );
	}
	
	@Test
	public void stringOfThreeIdenticalCharactersContainsDoubleCharacter() {
		assertTrue( checker.containsDoubleCharacter( "vvv" ) );
	}
	
	@Test
	public void stringOfEntireAlphabetDoesNotContainDoubleCharacter() {
		assertFalse( checker.containsDoubleCharacter( "abcdefghijklmnopqrstuvwxyz" ) );
	}
	
	@Test
	public void stringOfEntireAlphabetWithDoubleCharacterNearTheMiddleContainsDoubleCharacter() {
		assertTrue( checker.containsDoubleCharacter( "abcdefghijklmnoopqrstuvwxyz" ) );
	}
}
