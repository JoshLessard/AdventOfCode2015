package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class RibbonCalculatorTest {
	
	private Random random = new Random();
	
	private int randomSmallestPerimeter = random.nextInt( 1000 ) + 1;
	private int randomVolume = random.nextInt( 1000 ) + 1;
	private BoxDimensions mockBoxDimensions = mock( BoxDimensions.class );
	
	private RibbonCalculator calculator = new RibbonCalculator();
	
	@Before
	public void setUp() {
		when( mockBoxDimensions.getPerimeterOfSmallestSide() ).thenReturn( randomSmallestPerimeter );
		when( mockBoxDimensions.getVolume() ).thenReturn( randomVolume );
	}
	
	@Test( expected = NullPointerException.class )
	public void boxDimensionsCannotBeNullWhenCalculatingRequiredRibbon() {
		calculator.calculate( null );
	}
	
	@Test
	public void requiredRibbonIsPerimeterOfSmallestAreaPlusVolume() {
		assertEquals( randomSmallestPerimeter + randomVolume, calculator.calculate( mockBoxDimensions ) );
	}
}
