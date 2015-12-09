package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class CompositeStringCheckerTest {
	
	private String randomString = "jklfasjlifsdajlijf;dsal;s";

	private Function<String, Boolean> mockStringChecker1 = mock( Function.class );
	private Function<String, Boolean> mockStringChecker2 = mock( Function.class );
	private Function<String, Boolean> mockStringChecker3 = mock( Function.class );
	
	private CompositeStringChecker checker = new CompositeStringChecker( mockStringChecker1, mockStringChecker2, mockStringChecker3 );
	
	@Before
	public void setUp() {
		when( mockStringChecker1.apply( randomString ) ).thenReturn( true );
		when( mockStringChecker2.apply( randomString ) ).thenReturn( true );
		when( mockStringChecker3.apply( randomString ) ).thenReturn( true );
	}
	
	@Test
	public void ifFirstCheckerFailsThenCompositeCheckerFails() {
		when( mockStringChecker1.apply( randomString ) ).thenReturn( false );
		assertFalse( checker.accept( randomString ) );
	}
	
	@Test
	public void ifSecondCheckerFailsThenCompositeCheckerFails() {
		when( mockStringChecker2.apply( randomString ) ).thenReturn( false );
		assertFalse( checker.accept( randomString ) );
	}
	
	@Test
	public void ifThirdCheckerFailsThenCompositeCheckerFails() {
		when( mockStringChecker3.apply( randomString ) ).thenReturn( false );
		assertFalse( checker.accept( randomString ) );
	}
	
	@Test
	public void ifAllCheckersPassThenCompositeCheckerPasses() {
		assertTrue( checker.accept( randomString ) );
	}
}
