package org.rad.kernel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Block {

	private Block parent;
	private List<Block> children = new ArrayList<Block>();
	private Specification specification = new Specification();
	private int count;
	private List<Matrix> matrix = new ArrayList<Matrix>();
	private List<Pair> op = new ArrayList<Pair>();
	public static final int SUM = 0;
	public static final int MUL = 1;

	public Block() {
		this(Algebra.Classic, Algebra.Multiplicative);
	}

	public Block(Algebra sum, Algebra mul) {
		Matrix sumMatrix = new Matrix(sum);
		Matrix mulMatrix = new Matrix(mul);
		matrix.add(sumMatrix);
		matrix.add(mulMatrix);
	}

	public static Block binary() {
		return new Block(Algebra.BinaryClassic, Algebra.BinaryMultiplicative);
	}

	public static Block complex() {
		return new Block();
	}

	public void add(Block b) {
		getChildren().add(b);
		b.parent = this;

	}

	public List<Matrix> generate() {
		int offset = 0;
		for (Block b : children) {
			List<Matrix> m = b.generate();
			for (int i = 0; i < matrix.size(); i++) {
				matrix.get(i).add(m.get(i), offset);
			}
			for (Pair o : b.getOp()) {
				op.add(new Pair(o, offset));
			}
			offset += b.getCount();
			count += b.getCount();
		}
		return matrix;
	}

	public Specification getSpecification() {
		return specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}

	public void addInput(int input) {
		getSpecification().getInput().add(input);
	}

	public void addOutput(int output) {
		getSpecification().getOutput().add(output);
	}

	public int getOutput(int output) {
		return getSpecification().getOutput().get(output);
	}

	public int getInput(int input) {
		return getSpecification().getInput().get(input);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void addCount(int count) {
		this.count += count;
	}

	public List<Pair> getOp() {
		return op;
	}

	public void setOp(List<Pair> op) {
		this.op = op;
	}

	public List<Block> getChildren() {
		return children;
	}

	public void setChildren(List<Block> children) {
		this.children = children;
	}

	public int getChildrenCount() {
		return children.size();
	}

	public void add(int idx, Matrix m, int offset) {
		getMatrix().get(idx).add(m, offset);
	}

	public void addSum(Matrix m, int offset) {
		add(SUM, m, offset);
	}

	public void addMul(Matrix m, int offset) {
		add(MUL, m, offset);
	}

	public List<Matrix> getMatrix() {
		return matrix;
	}

	public void setMatrix(List<Matrix> matrix) {
		this.matrix = matrix;
	}

	public void addTuple(int idx, int src, int dst, double value) {
		getMatrix().get(idx).getMatrix().add(new Tuple(src, dst, value));
	}

	public void addTupleSum(int src, int dst, double value) {
		addTuple(SUM, src, dst, value);
	}

	public void addTupleMul(int src, int dst, double value) {
		addTuple(MUL, src, dst, value);
	}

	public void addOperation(int vertex, Operation op) {
		getOp().add(new Pair(vertex, op));
	}

	public void connect(int idx, int output, Block b, int input) {
		getMatrix().get(idx).connect(this, output, b, input);
	}

	public void connectSum(int output, Block b, int input) {
		connect(SUM, output, b, input);
	}

	public void connectMul(int output, Block b, int input) {
		connect(MUL, output, b, input);
	}

	public Matrix getMatrixSum() {
		return getMatrix().get(SUM);
	}

	public Matrix getMatrixMul() {
		return getMatrix().get(MUL);
	}

	public boolean hasOperation(int vertex) {
		return op.parallelStream().filter(p -> p.getVertex() == vertex).collect(Collectors.toList()).size() > 0;
	}

	public Operation getOperation(int vertex) {
		return op.parallelStream().filter(p -> p.getVertex() == vertex).collect(Collectors.toList()).get(0).getOp();
	}

}