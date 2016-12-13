package org.rad.kernel.cpp.parallel;

import org.rad.kernel.Pair;
import org.rad.kernel.Tuple;

public class Range {

	private int height;
	private int width;
	private int tile;

	public Range(int tile, int height, int width) {
		this.height = height;
		this.width = width;
		this.tile = tile;

	}

	public boolean check(Tuple t) {

		int left = tile * width;
		int top = 0;

		int right = (tile + 1) * width;
		int bottom = height;

		if (left <= t.getI() && t.getI() < right) {
			if (top <= t.getJ() && t.getJ() < bottom) {
				return true;
			}
		}
		return false;

	}

	public boolean check(Pair t) {

		int left = tile * width;
		int top = 0;

		int right = (tile + 1) * width;
		int bottom = height;

		if (left <= t.getVertex() && t.getVertex() < right) {
			return true;
		}
		return false;

	}

}
