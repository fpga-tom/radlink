package org.rad.gui;

public enum CellValueTypeEnum {

	INHERITED("inherited"), COMPLEX("complex"), BOOL("bool");

	private String typeName;

	CellValueTypeEnum(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

}
