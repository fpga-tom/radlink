package org.rad.kernel.parser.jgraphx;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class MxGeometry {

	@XmlElement(name = "mxRectangle")
	private MxRectangle mxRectangle;

	@XmlAttribute(required = false)
	private String as;

	@XmlAttribute(required = false)
	private double height;

	@XmlAttribute(required = false)
	private double width;

	@XmlAttribute(required = false)
	private double x;

	@XmlAttribute(required = false)
	private double y;

	@XmlAttribute(required = false)
	private boolean relative;

	@XmlElement(required = false)
	private List<MxPoint> mxPoint;

	public String getAs() {
		return as;
	}

	public void setAs(String as) {
		this.as = as;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean isRelative() {
		return relative;
	}

	public void setRelative(boolean relative) {
		this.relative = relative;
	}

	public List<MxPoint> getMxPoint() {
		return mxPoint;
	}

	public void setMxPoint(List<MxPoint> mxPoint) {
		this.mxPoint = mxPoint;
	}

	public MxRectangle getMxRectangle() {
		return mxRectangle;
	}

	public void setMxRectangle(MxRectangle mxRectangle) {
		this.mxRectangle = mxRectangle;
	}
}
