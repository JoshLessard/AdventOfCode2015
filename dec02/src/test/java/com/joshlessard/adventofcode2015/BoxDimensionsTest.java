package com.joshlessard.adventofcode2015;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class BoxDimensionsTest {
	
	private Random random = new Random();

	private int randomLength = random.nextInt( 100 ) + 1;
	private int randomWidth = random.nextInt( 100 ) + 1;
	private int randomHeight = random.nextInt( 100 ) + 1;
	
	private BoxDimensions dimensions = new BoxDimensions( randomLength, randomWidth, randomHeight );
	
	@Test( expected = IllegalArgumentException.class )
	public void lengthCannotBeNegative() {
		new BoxDimensions( -1, 1, 1 );
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void lengthCannotBeZero() {
		new BoxDimensions( 0, 1, 1 );
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void widthCannotBeNegative() {
		new BoxDimensions( 1, -1, 1 );
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void widthCannotBeZero() {
		new BoxDimensions( 1, 0, 1 );
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void heightCannotBeNegative() {
		new BoxDimensions( 1, 1, -1 );
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void heightCannotBeZero() {
		new BoxDimensions( 1, 1, 0 );
	}
	
	@Test
	public void calculatesSurfaceArea() {
		assertEquals( getExpectedSurfaceArea(), dimensions.getSurfaceArea() );
	}
	
	@Test
	public void calculatesAreaOfSmallestSide() {
		assertEquals( getExpectedAreaOfSmallestSide(), dimensions.getAreaOfSmallestSide() );
	}
	
	@Test
	public void calculatesPerimeterOfSmallestSide() {
		assertEquals( getExpectedPerimeterOfSmallestSide(), dimensions.getPerimeterOfSmallestSide() );
	}
	
	@Test
	public void calculatesVolume() {
		assertEquals( getExpectedVolume(), dimensions.getVolume() );
	}

	private int getExpectedSurfaceArea() {
		return 2 * (randomLength * randomWidth + randomLength * randomHeight + randomWidth * randomHeight);
	}

	private int getExpectedAreaOfSmallestSide() {
		return Math.min( Math.min( randomLength * randomWidth, randomLength * randomHeight ), randomWidth * randomHeight );
	}
	
	private int getExpectedPerimeterOfSmallestSide() {
		return 2 * Math.min( Math.min( randomLength + randomWidth, randomLength + randomHeight ), randomWidth + randomHeight );
	}
	
	private int getExpectedVolume() {
		return randomLength * randomWidth * randomHeight;
	}
}
