package org.rad.gui.cell;

import java.io.Serializable;

public class CellValue implements Serializable {

	private String name;

	public CellValue() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private CellValueTypeEnum valueType;

	public CellValue(String name, CellValueTypeEnum valueType) {
		this.name = name;
		this.setValueType(valueType);
	}

	@Override
	public String toString() {
		return name;
	}

	public CellValueTypeEnum getValueType() {
		return valueType;
	}

	public void setValueType(CellValueTypeEnum valueType) {
		this.valueType = valueType;
	}

}
