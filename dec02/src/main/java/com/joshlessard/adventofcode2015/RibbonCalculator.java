package com.joshlessard.adventofcode2015;

import static java.util.Objects.requireNonNull;

public class RibbonCalculator implements Calculator<BoxDimensions> {

	@Override
	public int calculate( BoxDimensions boxDimensions ) {
		requireNonNull( boxDimensions );
		return boxDimensions.getPerimeterOfSmallestSide() + boxDimensions.getVolume();
	}
}
