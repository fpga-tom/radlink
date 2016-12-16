package org.rad.kernel.cpp;

import org.rad.kernel.Block;
import org.rad.kernel.Operation;

public class CppOperation {

	public String get(Operation op) {

		if (Operation.ARG == op)
			return "arg";
		if (Operation.CONJ == op)
			return "conj";
		if (Operation.MUL == op)
			return "*";
		if (Operation.XOR == op)
			return "^";
		if (Operation.AND == op)
			return "&";
		if (Operation.OR == op)
			return "|";
		if (Operation.NOT == op)
			return "~";
		if (Operation.SUM == op)
			return "+";
		return "";
	}

	public String get(Block b, int vertex) {
		if (b.hasOperation(vertex))
			return get(b.getOperation(vertex));
		return "";
	}

}
