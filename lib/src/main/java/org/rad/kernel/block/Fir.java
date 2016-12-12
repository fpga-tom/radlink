package org.rad.kernel.block;

import org.rad.kernel.Block;

public class Fir extends Block {

	private double[] taps;

	public Fir(double[] taps) {
		this.taps = taps;
		int output = taps.length;
		addInput(0);
		addOutput(output);
		setCount(output + 1);

		if (taps.length == 0) {
			System.err.println("FIR: taps size is 0");
		}

		for (int i = 0; i < taps.length - 1; i++) {
			addTupleSum(i, i + 1, 1.0f);
		}
		for (int i = 0; i < taps.length; i++) {
			addTupleSum(i, output, taps[i]);
		}

	}
}