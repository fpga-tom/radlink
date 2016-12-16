package org.rad.kernel.block.dvbt;

import org.rad.kernel.Block;
import org.rad.kernel.Operation;

public class Scrambler extends Block {

	private static final int size = 15;
	private static final int x0 = 13;
	private static final int x1 = 14;

	public Scrambler() {

		for (int i = 0; i < size - 1; i++) {
			addTupleSum(i, i + 1, 1.0);
		}
		addTupleSum(x0, size, 1.0);
		addTupleSum(size, 0, 1.0);
		addOperation(size, Operation.XOR);

	}

}
