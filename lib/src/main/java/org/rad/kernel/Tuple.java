package org.rad.kernel;

public class Tuple {
	private int i;
	private int j;
	private double v;
	
	public Tuple(int i, int j, double v) {
		this.setI(i);
		this.setJ(j);
		this.setV(v);
	}
	
	public Tuple(Tuple o, int offset) {
		this.setI(o.getI() + offset);
		this.setJ(o.getJ() + offset);
		this.setV(o.getV());
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}
}