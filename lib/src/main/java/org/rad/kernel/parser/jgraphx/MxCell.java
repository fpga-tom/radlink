package org.rad.kernel.parser.jgraphx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class MxCell {

	@XmlElement(name = "mxGeometry")
	private MxGeometry mxGeometry;

	@XmlAttribute(required = true)
	private int id;

	@XmlAttribute(required = false)
	private int parent;

	@XmlAttribute(required = false)
	private boolean collapsed;

	@XmlAttribute(required = false)
	private boolean connectable;

	@XmlElement(name = "CellValue")
	private CellValue cellValue;

	@XmlAttribute(required = false)
	private String value;

	@XmlAttribute(required = false)
	private int vertex;

	@XmlAttribute(required = false)
	private String style;

	@XmlAttribute(required = false)
	private int source;

	@XmlAttribute(required = false)
	private int target;

	@XmlAttribute(required = false)
	private boolean edge;

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public boolean isCollapsed() {
		return collapsed;
	}

	public void setCollapsed(boolean collapsed) {
		this.collapsed = collapsed;
	}

	public boolean isConnectable() {
		return connectable;
	}

	public void setConnectable(boolean connectable) {
		this.connectable = connectable;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public MxGeometry getMxGeometry() {
		return mxGeometry;
	}

	public void setMxGeometry(MxGeometry mxGeometry) {
		this.mxGeometry = mxGeometry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public boolean isEdge() {
		return edge;
	}

	public void setEdge(boolean edge) {
		this.edge = edge;
	}

	public CellValue getCellValue() {
		return cellValue;
	}

	public void setCellValue(CellValue cellValue) {
		this.cellValue = cellValue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
