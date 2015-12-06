package com.joshlessard.adventofcode2015;

public class BoxDimensions {

	private int length;
	private int width;
	private int height;

	public BoxDimensions( int length, int width, int height ) {
		validateDimension( length, width, height );
		this.length = length;
		this.width = width;
		this.height = height;
	}

	private void validateDimension( int... dimensions ) {
		for ( int dimension : dimensions ) {
			if ( dimension <= 0 ) {
				throw new IllegalArgumentException();
			}
		}
	}

	public int getSurfaceArea() {
		return 2 * (getBottomSurfaceArea() + getSideSurfaceArea() + getFrontSurfaceArea());
	}

	public int getAreaOfSmallestSide() {
		return Math.min( Math.min( getBottomSurfaceArea(), getSideSurfaceArea() ), getFrontSurfaceArea() );
	}

	public int getPerimeterOfSmallestSide() {
		return Math.min( Math.min( getBottomPerimeter(), getSidePerimeter() ), getFrontPerimeter() );
	}

	public int getVolume() {
		return length * width * height;
	}

	private int getBottomSurfaceArea() {
		return getArea( length, width );
	}

	private int getSideSurfaceArea() {
		return getArea( length, height );
	}

	private int getFrontSurfaceArea() {
		return getArea( width, height );
	}
	
	private int getArea( int a, int b ) {
		return a * b;
	}
	
	private int getBottomPerimeter() {
		return getPerimeter( length, width );
	}
	
	private int getSidePerimeter() {
		return getPerimeter( length, height );
	}
	
	private int getFrontPerimeter() {
		return getPerimeter( width, height );
	}

	private int getPerimeter( int a, int b ) {
		return 2 * (a + b);
	}
}
