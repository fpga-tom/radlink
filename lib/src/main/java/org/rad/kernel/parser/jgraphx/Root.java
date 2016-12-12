package org.rad.kernel.parser.jgraphx;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

	@XmlElement(name = "mxCell")
	private List<MxCell> mxCell;

	public List<MxCell> getMxCell() {
		return mxCell;
	}

	public void setMxCell(List<MxCell> mxCell) {
		this.mxCell = mxCell;
	}

}
