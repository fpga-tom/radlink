package org.rad.kernel;

import java.util.ArrayList;
import java.util.List;

public class Specification {

	private List<Integer> input = new ArrayList<Integer>();
	private List<Integer> output = new ArrayList<Integer>();

	public List<Integer> getInput() {
		return input;
	}

	public void setInput(List<Integer> input) {
		this.input = input;
	}

	public List<Integer> getOutput() {
		return output;
	}

	public void setOutput(List<Integer> output) {
		this.output = output;
	}

}
