package org.rad.kernel.parser.jgraphx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CellValue {

	@XmlAttribute
	private String as;

	@XmlAttribute
	private String name;

	@XmlElement(name = "CellValueTypeEnum")
	private CellValueTypeEnum cellValueTypeEnum;

	public String getAs() {
		return as;
	}

	public void setAs(String as) {
		this.as = as;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CellValueTypeEnum getCellValueTypeEnum() {
		return cellValueTypeEnum;
	}

	public void setCellValueTypeEnum(CellValueTypeEnum cellValueTypeEnum) {
		this.cellValueTypeEnum = cellValueTypeEnum;
	}

}
