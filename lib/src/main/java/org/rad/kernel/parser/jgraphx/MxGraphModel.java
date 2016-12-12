package org.rad.kernel.parser.jgraphx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mxGraphModel")
@XmlAccessorType(XmlAccessType.FIELD)
public class MxGraphModel {

	@XmlElement(required = true)
	private Root root;

	public Root getRoot() {
		return root;
	}

	public void setRoot(Root root) {
		this.root = root;
	}

}
