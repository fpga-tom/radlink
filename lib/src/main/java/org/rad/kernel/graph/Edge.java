package org.rad.kernel.graph;

public class Edge {

	private int source;
	private int dest;
	private double value;

	public Edge(int source, int dest, double value) {
		this.source = source;
		this.dest = dest;
		this.setValue(value);
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getDest() {
		return dest;
	}

	public void setDest(int dest) {
		this.dest = dest;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Edge) {
			Edge o = (Edge) obj;
			if (o.dest == dest && o.source == source) {
				return true;
			}
		}
		return false;
	}

}
