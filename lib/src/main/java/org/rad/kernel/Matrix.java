package org.rad.kernel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
	private List<Tuple> matrix = new ArrayList<Tuple>();
	private List<Pair> op = new ArrayList<Pair>();
	private Algebra algebra;

	public Matrix(Algebra algebra) {
		this.algebra = algebra;
	}

	public List<Tuple> getMatrix() {
		return matrix;
	}

	public void setMatrix(List<Tuple> matrix) {
		this.matrix = matrix;
	}

	public List<Pair> getOp() {
		return op;
	}

	public void setOp(List<Pair> op) {
		this.op = op;
	}

	public void connect(Block a, int output, Block b, int input) {
		matrix.add(new Tuple(a.getOutput(output), b.getInput(input), 1.0));
	}

	public void add(Matrix m, int offset) {
		for (Tuple t : m.getMatrix()) {
			matrix.add(new Tuple(t, offset));
		}
		for (Pair o : m.getOp()) {
			op.add(new Pair(o, offset));
		}
	}

	public List<Integer> target() {
		return matrix.parallelStream().map(p -> p.getJ()).distinct().collect(Collectors.toList());
	}

	public List<Integer> source() {
		return matrix.parallelStream().map(p -> p.getI()).distinct().collect(Collectors.toList());
	}

	public Algebra getAlgebra() {
		return algebra;
	}

	public void setAlgebra(Algebra algebra) {
		this.algebra = algebra;
	}
}