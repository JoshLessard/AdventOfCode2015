package com.joshlessard.adventofcode2015;

public class ValueComponent implements CircuitComponent {

	private final String name;
	private final int outputSignal;

	public ValueComponent( String name, int outputSignal ) {
		this.name = name;
		this.outputSignal = outputSignal;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void addInputSignal( int inputSignal ) {
		throw new IllegalStateException();
	}

	@Override
	public boolean isOutputSignalReady() {
		return true;
	}

	@Override
	public int getOutputSignal() {
		return outputSignal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + name.hashCode();
		result = prime * result + outputSignal;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ValueComponent other = (ValueComponent) obj;
		if (!name.equals(other.name)) {
			return false;
		}
		if (outputSignal != other.outputSignal) {
			return false;
		}
		return true;
	}
}
