package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringFinderTest {
	
	@Test
	public void stringThatDoesNotContainStringToFindReturnsFalse() {
		StringFinder finder = new StringFinder( "ed" );
		assertFalse( finder.containsStringToFind( "abcde" ) );
	}
	
	@Test
	public void stringThatContainsStringToFindReturnsTrue() {
		StringFinder finder = new StringFinder( "xns" );
		assertTrue( finder.containsStringToFind( "lxnsise" ) );
	}
	
	@Test
	public void stringThatDoesNotContainAnyStringToFindReturnsFalse() {
		StringFinder finder = new StringFinder( "abc", "123", "zis" );
		assertFalse( finder.containsStringToFind( "ab12zic3s" ) );
	}
	
	@Test
	public void stringThatContainsTwoStringsToFindReturnsTrue() {
		StringFinder finder = new StringFinder( "ezn", "281", "lidkn" );
		assertTrue( finder.containsStringToFind( "jklfdsajeznjklafsdjlidknl" ) );
	}
}
