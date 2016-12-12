package org.rad.kernel.block.fm;

import org.rad.kernel.Block;
import org.rad.kernel.Operation;

public class FMDemod extends Block {

	public FMDemod() {
		addInput(0);
		addOutput(4);
		setCount(5);

		addTupleSum(0, 1, 1.0f);
		addTupleSum(1, 2, 1.0f);
		addTupleSum(0, 3, 1.0f);
		addTupleSum(3, 4, 1.0f);
		addOperationSum(1, Operation.CONJ);
		addOperationSum(3, Operation.MUL);
		addOperationSum(4, Operation.ARG);

	}

}