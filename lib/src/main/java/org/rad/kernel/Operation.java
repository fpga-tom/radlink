package org.rad.kernel;

public enum Operation {

	/* UNARY OPERATIONS */
	CONJ(true, null), ARG(true, null), NOT(true, null),
	/* BINARY OPERATIONS */
	SUM(false, Float.valueOf(0)), MUL(false, Float.valueOf(1)), XOR(false, Boolean.FALSE), AND(false,
			Boolean.TRUE), OR(false, Boolean.FALSE);

	private boolean unary;
	private Object one;

	Operation(boolean unary, Object one) {
		this.unary = unary;
		this.one = one;
	}

	public static Operation fromString(String op) {

		for (Operation o : Operation.values()) {
			if (o.name().equalsIgnoreCase(op)) {
				return o;
			}
		}
		return null;
	}

	public boolean isUnary() {
		return unary;
	}

	public Object getOne() {
		return one;
	}
}