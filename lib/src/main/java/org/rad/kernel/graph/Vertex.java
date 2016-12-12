package org.rad.kernel.graph;

import java.util.ArrayList;
import java.util.List;

import org.rad.kernel.Operation;

public class Vertex {

	private Integer id;
	private String value;
	private List<Vertex> source = new ArrayList<Vertex>();
	private Operation op;

	public Vertex(int id, String value) {
		this.id = id;
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Vertex> getSource() {
		return source;
	}

	public void setSource(List<Vertex> source) {
		this.source = source;
	}

}
