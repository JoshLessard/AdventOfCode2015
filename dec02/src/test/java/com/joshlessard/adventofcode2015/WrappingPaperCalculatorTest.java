package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class WrappingPaperCalculatorTest {
	
	private Random random = new Random();
	
	private int randomSurfaceArea = random.nextInt( 1000 ) + 1;
	private int randomSmallestSurfaceArea = random.nextInt( 100 ) + 1;
	private BoxDimensions mockBoxDimensions = mock( BoxDimensions.class );
	
	private WrappingPaperCalculator calculator = new WrappingPaperCalculator();
	
	@Before
	public void setUp() {
		when( mockBoxDimensions.getSurfaceArea() ).thenReturn( randomSurfaceArea );
		when( mockBoxDimensions.getAreaOfSmallestSide() ).thenReturn( randomSmallestSurfaceArea );
	}
	
	@Test( expected = NullPointerException.class )
	public void boxDimensionsCannotBeNullWhenCalculatingRequiredWrappingPaper() {
		calculator.calculate( null );
	}
	
	@Test
	public void requiredWrappingPaperIsSurfaceAreaPlusAreaOfSmallestSide() {
		assertEquals( randomSurfaceArea + randomSmallestSurfaceArea, calculator.calculate( mockBoxDimensions ) );
	}
}
