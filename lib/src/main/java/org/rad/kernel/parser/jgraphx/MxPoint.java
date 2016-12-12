package org.rad.kernel.parser.jgraphx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class MxPoint {

	@XmlAttribute(required = true)
	private String as;

	@XmlAttribute(required = true)
	private double x;

	@XmlAttribute(required = true)
	private double y;

	public String getAs() {
		return as;
	}

	public void setAs(String as) {
		this.as = as;
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

}
