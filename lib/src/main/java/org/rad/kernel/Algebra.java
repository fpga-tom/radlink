package org.rad.kernel;

public enum Algebra {

	Classic(Operation.MUL, Operation.SUM), Multiplicative(Operation.MUL, Operation.MUL), BinaryClassic(Operation.AND,
			Operation.OR), BinaryMultiplicative(Operation.AND, Operation.AND);

	/**
	 * Defines dot product
	 */
	private Operation dot;
	/**
	 * Defines matrix multiplication operation
	 */
	private Operation sum;

	Algebra(Operation dot, Operation sum) {
		this.dot = dot;
		this.sum = sum;
	}

	public Operation getDot() {
		return dot;
	}

	public Operation getSum() {
		return sum;
	}

}
