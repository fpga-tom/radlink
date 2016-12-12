package org.rad.kernel.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {

	private Graph parent;
	private List<Graph> children = new ArrayList<Graph>();
	private List<Vertex> vertex = new ArrayList<Vertex>();
	private List<Edge> edge = new ArrayList<Edge>();
	private boolean binary;

	public List<Vertex> getVertex() {
		return vertex;
	}

	public void setVertex(List<Vertex> vertex) {
		this.vertex = vertex;
	}

	public List<Edge> getEdge() {
		return edge;
	}

	public void setEdge(List<Edge> edge) {
		this.edge = edge;
	}

	public Graph getParent() {
		return parent;
	}

	public void setParent(Graph parent) {
		this.parent = parent;
	}

	public List<Graph> getChildren() {
		return children;
	}

	public void setChildren(List<Graph> children) {
		this.children = children;
	}

	public List<Vertex> getInput() {
		return vertex.parallelStream().filter(p -> "In".equals(p.getValue())).collect(Collectors.toList());
	}

	public List<Vertex> getOutput() {
		return vertex.parallelStream().filter(p -> "Out".equals(p.getValue())).collect(Collectors.toList());
	}

	public List<Edge> getSources(Vertex v) {
		return edge.parallelStream().filter(p -> p.getDest() == v.getId()).collect(Collectors.toList());
	}

	public List<Vertex> findByOperation(String op) {
		return vertex.parallelStream().filter(p -> op.equalsIgnoreCase(p.getValue())).collect(Collectors.toList());
	}

	public List<Vertex> findById(int id) {
		return vertex.parallelStream().filter(p -> p.getId().equals(id)).collect(Collectors.toList());
	}

	public boolean isMul(int id) {
		List<Vertex> v = findById(id);
		if ("mul".equalsIgnoreCase(v.get(0).getValue())) {
			return true;
		}
		return false;
	}

	public int getCount() {
		return vertex.size();
	}

	public boolean isBinary() {
		return binary;
	}

	public void setBinary(boolean binary) {
		this.binary = binary;
	}

}
