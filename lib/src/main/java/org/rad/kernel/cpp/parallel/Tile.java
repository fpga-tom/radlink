package org.rad.kernel.cpp.parallel;

import java.util.ArrayList;
import java.util.List;

import org.rad.kernel.Block;
import org.rad.kernel.Matrix;
import org.rad.kernel.Pair;
import org.rad.kernel.Tuple;

public class Tile {

	private int height;
	private int width;
	private int tile;
	private List<Matrix> matrix = new ArrayList<Matrix>();

	public Tile(Block b, int tile, int height, int width) {
		this.tile = tile;
		this.height = height;
		this.width = width;

		for (Matrix m : b.getMatrix()) {
			Matrix n = new Matrix(m.getAlgebra());
			matrix.add(n);
			for (Tuple t : m.getMatrix()) {
				Range r = new Range(tile, height, width);
				if (r.check(t)) {
					n.getMatrix().add(t);
				}
			}

			for (Pair t : m.getOp()) {
				Range r = new Range(tile, height, width);
				if (r.check(t)) {
					n.getOp().add(t);
				}
			}
		}

	}

	public int getTile() {
		return tile;
	}

	public void setTile(int tile) {
		this.tile = tile;
	}

	public List<Matrix> getMatrix() {
		return matrix;
	}

	public void setMatrix(List<Matrix> matrix) {
		this.matrix = matrix;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
