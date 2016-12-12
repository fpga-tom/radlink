package org.rad.kernel.graph;

import java.util.List;

import org.rad.kernel.Block;
import org.rad.kernel.Operation;

public class BlockBuilder {

	public static Block build(Graph graph) {
		List<Vertex> in = graph.getInput();
		List<Vertex> out = graph.getOutput();

		Block result = null;
		if (graph.isBinary()) {
			result = Block.binary();
		} else {
			result = Block.complex();
		}

		result.addInput(in.get(0).getId());
		result.addOutput(out.get(0).getId());
		result.addCount(graph.getCount());

		for (Edge e : graph.getEdge()) {
			if (graph.isMul(e.getDest())) {
				result.addTupleMul(e.getSource(), e.getDest(), e.getValue());
			} else {
				result.addTupleSum(e.getSource(), e.getDest(), e.getValue());
			}
		}

		for (Vertex v : graph.getVertex()) {
			Operation op = Operation.fromString(v.getValue());
			if (op != null && op.isUnary()) {
				result.addOperationSum(v.getId(), op);
			}
		}

		for (Graph g : graph.getChildren()) {
			result.add(build(g));
		}

		return result;

	}

}
