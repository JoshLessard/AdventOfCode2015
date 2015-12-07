package com.joshlessard.adventofcode2015;

public class Point {

	private final int x;
	private final int y;

	public Point( int x, int y ) {
		this.x = x;
		this.y = y;
	}

	public Point move( char move ) {
		return new Point( getNewXCoordinate( move ), getNewYCoordinate( move ) );
	}
	
	private int getNewXCoordinate( char move ) {
		switch( move ) {
			case '^':
			case 'v':
				return x;
			case '>':
				return x + 1;
			case '<':
				return x - 1;
			default:
				throw new IllegalArgumentException();
		}
	}
	
	private int getNewYCoordinate( char move ) {
		switch( move ) {
			case '^':
				return y + 1;
			case 'v':
				return y - 1;
			case '>':
			case '<':
				return y;
			default:
				throw new IllegalArgumentException();
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
