package org.rad.kernel;

public class Pair {
	private int vertex;
	private Operation op;

	public Pair(int vertex, Operation op) {
		this.setVertex(vertex);
		this.setOp(op);
	}

	public Pair(Pair p, int offset) {
		this.setVertex(p.getVertex() + offset);
		this.setOp(p.getOp());
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public Operation getOp() {
		return op;
	}

	public void setOp(Operation op) {
		this.op = op;
	}
}
