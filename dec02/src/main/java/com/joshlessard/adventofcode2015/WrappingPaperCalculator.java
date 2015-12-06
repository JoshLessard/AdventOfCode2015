package com.joshlessard.adventofcode2015;

import static java.util.Objects.requireNonNull;

public class WrappingPaperCalculator implements Calculator<BoxDimensions> {

	public int calculate( BoxDimensions boxDimensions ) {
		requireNonNull( boxDimensions );
		return boxDimensions.getSurfaceArea() + boxDimensions.getAreaOfSmallestSide();
	}
}
